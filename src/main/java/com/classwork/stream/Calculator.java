package com.classwork.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;
import java.io.File;

public class Calculator {

	public static final List<String> filename = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		IntStream.range(4000, 4001)
				.forEach(j -> filename.add("https://www.gutenberg.org/cache/epub/%d/pg%d.txt".formatted(j, j)));


		List<Thread> pool = new ArrayList<>();

		filename.stream().parallel().forEach(file -> {
			Runnable calculator = new WordLengthCalculator(file);
			pool.add(new Thread(calculator));
		});

		for (Thread thread : pool) {
			thread.start();
		}
	
	}
}

class WordLengthCalculator implements Runnable {
	private final String file;
	private final AtomicLong totalLength = new AtomicLong(0);
	private final AtomicLong wordCount = new AtomicLong(0);
	
	public WordLengthCalculator(String file) {
		this.file = file;
	}

	@Override
	public void run() {
		long start = System.nanoTime();

		getStream().forEach(s -> Pattern.compile("\\b\\w+\\b").matcher(s).results().parallel().forEach(match -> {
			totalLength.addAndGet(match.group().length());
			wordCount.incrementAndGet();
		}));

		System.out.printf("The length of all words: %s%n", totalLength);
		System.out.printf("Number of words: %s%n", wordCount);
		System.out.printf("Average word length: %.2f%n", (totalLength.doubleValue() / wordCount.doubleValue()));

		long end = System.nanoTime();
		System.out.printf("Execution time: %s milliseconds%n", (end - start) / 1000_000);
	}

	private Stream<String> getStream() {
		
		InputStream stream = null;
		try {
			URL url = new URL(file);
			try {
				stream = new GZIPInputStream((url.openStream()));
			} catch (Exception e) {
				stream = url.openStream();
			}
			return new BufferedReader(new InputStreamReader(stream)).lines();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return Stream.empty();
		}
	}
}
