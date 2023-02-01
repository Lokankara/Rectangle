package com.homework.threads;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DirReader {

	static void readDir() {
		Path path = FileSystems.getDefault().getPath("src");
		if (Files.exists(path) && Files.isDirectory(path)) {
			int maxDepth = 5;
			try (Stream<Path> streamDir = Files.find(path, maxDepth, (p, a) -> String.valueOf(p).endsWith(".txt"))) {
				long counter = streamDir.map(String::valueOf).peek(System.out::println).count();
				System.out.println("found: " + counter);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
