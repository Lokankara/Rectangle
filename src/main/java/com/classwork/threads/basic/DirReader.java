package com.classwork.threads.basic;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DirReader {

	public static List<String> searchFiles(String extend) {
		List<String> filenames = new ArrayList<>();
		Path path = FileSystems.getDefault().getPath("src");
		if (Files.exists(path) && Files.isDirectory(path)) {
			int maxDepth = 3;
			try (Stream<Path> streamDir = Files.find(path, maxDepth, (p, a) -> String.valueOf(p).endsWith(extend))) {
				long counter = streamDir.map(String::valueOf).peek(filenames::add).count();
				System.out.printf("Found %s file(s): %s%n", counter, filenames);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return filenames;
	}
}
