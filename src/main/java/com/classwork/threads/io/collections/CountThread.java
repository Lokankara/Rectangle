package com.classwork.threads.io.collections;

import java.io.IOException;
import java.util.Queue;

import com.homework.threads.io.collections.Dispatcher;

public class CountThread extends Thread {

	private String filename;
	private Queue<String> dataQueue;

	public CountThread(Queue<String> dataQueue, String filename) {
		this.filename = filename;
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		try (FileIterator fc = new FileIterator(Dispatcher.path + filename)) {
			while (fc.hasNext()) {
				dataQueue.add(fc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}