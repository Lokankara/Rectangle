package com.thread.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class DirReader {
	private DirReader() {
	}
	public static List<String> searchFiles(String extend) {
		int maxDepth = 5;
		List<String> filenames = new ArrayList<>();
		Path path = FileSystems.getDefault().getPath("src");

		if (Files.exists(path) && Files.isDirectory(path)) {
			try (Stream<Path> streamDir = Files.find(path, maxDepth, (p, a) -> String.valueOf(p).endsWith(extend))) {
				filenames = streamDir.map(Path::toString).toList();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return filenames;
	}
}
