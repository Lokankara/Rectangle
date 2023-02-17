package com.classwork.threads.io.collections;

import java.io.IOException;
import java.util.Queue;

public class CountThread extends Thread {

	Queue<String> dataQueue;
	String filename;

	public CountThread(Queue<String> dataQueue, String filename) {
		super();
		this.dataQueue = dataQueue;
		this.filename = filename;
	}

	@Override
	public void run() {
		try (FileIterator fc = new FileIterator(filename)) {
			while (fc.hasNext()) {
				dataQueue.add(fc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
