package com.homework.threads.io.collections;

import java.io.File;

final class Resource {
	private final File file;
//	private final Map<String, Long> tautograms;

	public Resource(String filename) {
		this.file = new File(filename);
//		this.tautograms = new ConcurrentHashMap<>();
	}

	public File getFile() {
		return file;
	}

// synchronized 
	public void reduce(String next) {
		Dispatcher.tautograms.compute(next, (key, value) -> value == null ? 1 : ++value);
	}
}