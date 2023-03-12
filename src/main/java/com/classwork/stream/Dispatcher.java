package com.classwork.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Dispatcher {
	private static final String[] files = { "READ.md", "TODO.md", "HELP.md" };

	public static void main(String[] args) throws InterruptedException {

		List<Path> filePaths = Arrays.stream(files).map(Paths::get).toList();

		AtomicInteger totalLength = new AtomicInteger(0);
		AtomicInteger wordCount = new AtomicInteger(0);

		List<Thread> threads = filePaths.stream()
				.map(filePath -> new Thread(new TextFileReader(filePath, totalLength, wordCount))).toList();

		threads.forEach(Thread::start);

		for (Thread thread : threads) {
			thread.join();
		}

		double averageLength = (double) totalLength.get() / wordCount.get();
		System.out.println("Average length of words: " + averageLength);
	}
}

class TextFileReader implements Runnable {
	private final Path filePath;
	private final AtomicInteger totalLength;
	private final AtomicInteger wordCount;

	public TextFileReader(Path filePath, AtomicInteger totalLength, AtomicInteger wordCount) {
		this.filePath = filePath;
		this.totalLength = totalLength;
		this.wordCount = wordCount;
	}

	@Override
	public void run() {
		try (Stream<String> lines = Files.lines(filePath)) {
			lines.flatMap(line -> Stream.of(line.split("\\s+"))).filter(word -> !word.isEmpty()).forEach(word -> {
				totalLength.addAndGet(word.length());
				wordCount.incrementAndGet();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
