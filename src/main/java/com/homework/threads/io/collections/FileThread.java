package com.homework.threads.io.collections;

import java.io.IOException;
import java.util.Scanner;

class FileThread extends Thread {

	private final Resource resource;

	public FileThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		String next = "";
		try (Scanner scanner = new Scanner(resource.getFile())) {
			while (scanner.hasNext()) {
				next = scanner.next()
						.replaceAll("[{}\\[\\]()`'/\\\"\\\\*«»“”„,;:?!….\\\\-\\\\‒\\\\—\\\\―|~%@&]", " ")
						.toLowerCase();

				if (next.length() > 1 
						&& next.charAt(0) == next.charAt(next.length() - 1) 
						&& next.charAt(0) > 96
						&& next.charAt(0) < 123) {
					resource.reduce(next);
				}
			}
		} catch (IOException e) {
			System.err.printf("%s%n", e);
		}
	}
}
