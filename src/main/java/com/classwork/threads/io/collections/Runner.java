package com.classwork.threads.io.collections;

import java.util.Map;
import java.util.Queue;

class Runner implements Runnable {

    Transformer transform;
	private Queue<String> dataQueue;
	private Map<String, Integer> counters;

	public Runner(Transformer transform, Map<String, Integer> counters, Queue<String> dataQueue) {
		this.transform = transform;
		this.dataQueue = dataQueue;
		this.counters = counters;
	}

	@Override
	public void run() {
		while (!dataQueue.isEmpty()) {
			String line = dataQueue.poll();
			if (line != null) {
				String[] words = transform.mapToTokens(line);
				String[] legalWords = transform.filterIllegalTokens(words);
				String[] lowerCaseWords = transform.mapToLowerCase(legalWords);
				for (String word : lowerCaseWords) {
					transform.reduce(counters, word);
				}
			}
		}
	}
}
