package com.classwork.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parallel {

	public static void main(String[] args) throws IOException {
		int numThreads = 4; // number of threads to use
		Path dir = Paths.get(""); // directory containing text files

		// create a thread pool with the desired number of threads
		var pool = new java.util.concurrent.ForkJoinPool(numThreads);

		List<Path> files = Files.list(dir).filter(p -> p.toString().endsWith(".md")).toList();

		// use a parallel stream to read the files and split them into words
		Stream<String> wordsStream = pool.submit(() -> files.parallelStream()
				.flatMap(Parallel::readWordsFromFile))
				.join();

		// calculate the average word length using a parallel reduction
		double avgLength = wordsStream.parallel().mapToInt(String::length).average().orElse(Double.NaN);

		// print the result
		System.out.printf("Average word length: %.2f%n", avgLength);

		// shut down the thread pool
		pool.shutdown();
	}

	private static Stream<String> readWordsFromFile(Path file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
			return reader.lines().flatMap(line -> Arrays.stream(line.split("\\s+"))).map(Parallel::normalizeWord);
		} catch (IOException e) {
			System.err.printf("Error reading file %s: %s%n", file, e.getMessage());
			return Stream.empty();
		}
	}

	private static String normalizeWord(String word) {
		return word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}
}
