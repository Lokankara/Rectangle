package com.classwork.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analizer implements Runnable {
	public static final String PILLS = "EOF";
	private static final Lock bufferLock = new ReentrantLock();

	public static CountDownLatch countDownLatch;
	public static final List<String> files = new ArrayList<>();
	public static final DoubleAccumulator totalAverage = new DoubleAccumulator(Double::sum, 0);

	public static void main(String[] args) {
		AtomicLong totalWordCount = new AtomicLong();
		AtomicLong totalWordLength = new AtomicLong();

		IntStream.range(4000, 4006)
				.forEach(n -> files.add("https://www.gutenberg.org/cache/epub/%d/pg%d.txt".formatted(n, n)));

		new Thread(new Reader(new ArrayList<>(), "", bufferLock, files)).start();
		new Thread(new Reader(new ArrayList<>(), "", bufferLock, files)).start();
		new Thread(new CounterRunner(new ArrayList<>(), "", bufferLock, files)).start();
		new Thread(new CounterRunner(new ArrayList<>(), "", bufferLock, files)).start();

		countDownLatch = new CountDownLatch(files.size());

		List<Analizer> analyzers = IntStream.range(0, files.size())
				.mapToObj(i -> new Analizer(files, totalWordCount, totalWordLength)).toList();

		analyzers.forEach(analyzer -> analyzer.thread.start());

		analyzers.forEach(Analizer::join);

		double averageWordLength = (double) totalWordLength.get() / totalWordCount.get();

		System.out.printf("Average word length: %.2f%n", averageWordLength);
	}

	private final List<String> filePaths;
	private final AtomicLong totalWordCount;
	private final AtomicLong totalWordLength;
	private final Thread thread;

	public Analizer(List<String> filePaths, AtomicLong totalWordCount, AtomicLong totalWordLength) {
		this.filePaths = filePaths;
		this.totalWordCount = totalWordCount;
		this.totalWordLength = totalWordLength;
		this.thread = new Thread(this);
	}

	@Override
	public void run() {
		filePaths.stream().parallel().forEach(this::readFile);
	}

	private void join() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println(e.getMessage());
		}
	}

	private void readFile(String filename) {

		try {
			URL url = new URL(filename);

			BufferedReader reader = new BufferedReader(new InputStreamReader((url.openStream())));
			String line;
			while ((line = reader.readLine()) != null) {
				totalWordCount.addAndGet(countWords(line));
				totalWordLength.addAndGet(sumWordLengths(line));
			}
			System.out.printf("Average word length: %.2f%n", (double) (totalWordLength.get() / totalWordCount.get()));
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private long countWords(String line) {
		return Stream.of(line.split("\\s+")).parallel().count();
	}

	private long sumWordLengths(String line) {
		return Stream.of(line.split("\\s+")).parallel().mapToLong(String::length).sum();
	}
}

class Reader implements Runnable {
	private final List<String> files;
	private final String color;
	private final List<String> buffer;
	private final Lock bufferLock;

	public Reader(List<String> buffer, String color, Lock bufferLock, List<String> files) {
		this.files = files;
		this.buffer = buffer;
		this.color = color;
		this.bufferLock = bufferLock;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (String filename : files) {

			System.out.println(color + "Adding..." + filename);
			System.out.println(Thread.currentThread().getName());

			bufferLock.lock();
			try {
				buffer.add(filename);
			} finally {
				bufferLock.unlock();
			}

		}
		System.out.println(color + "Adding EOF and exiting...");

		bufferLock.lock();
		try {
			buffer.add(Analizer.PILLS);
		} finally {
			bufferLock.unlock();
		}
	}
}

class CounterRunner implements Runnable {
	private final List<String> files;
	private final List<String> buffer;
	private final String color;
	private final Lock bufferLock;

	public CounterRunner(List<String> buffer, String color, Lock bufferLock, List<String> files) {

		this.files = files;
		this.buffer = buffer;
		this.color = color;
		this.bufferLock = bufferLock;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		while (true) {

			if (bufferLock.tryLock()) {
				try {
					if (buffer.isEmpty()) {
						continue;
					}
					if (buffer.get(0).equals(Analizer.PILLS)) {

						System.out.println(color + "Exiting");
						break;
					} else {

						Map<Integer, Long> wordCounts = Arrays.stream(buffer.remove(0).split("\\PL+")).parallel()
								.collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
						System.out.println(wordCounts);
					}
				} finally {
					bufferLock.unlock();
				}
			}
		}
	}
}
