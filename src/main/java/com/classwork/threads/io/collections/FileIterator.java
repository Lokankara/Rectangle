package com.classwork.threads.io.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

class FileIterator implements Iterator<String>, AutoCloseable {
	private final BufferedReader br;
	private String nextLine;

	public FileIterator(String fileName) throws IOException {
		br = new BufferedReader(new FileReader(fileName));
		nextLine = br.readLine();
	}

	@Override
	public boolean hasNext() {
		return nextLine != null;
	}

	@Override
	public String next() {
		String lineToReturn = nextLine;
		try {
			nextLine = br.readLine();
		} catch (IOException e) {
			nextLine = null;
		}
		return lineToReturn;
	}

	@Override
	public void close() throws IOException {
		br.close();
	}
}