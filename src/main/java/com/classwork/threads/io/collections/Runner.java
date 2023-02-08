package com.classwork.threads.io.collections;

import java.util.Map;
import java.util.Queue;

class Runner implements Runnable {

	private Accumulator tr;
	private Queue<String> dataQueue;
	private Map<String, Long> counters;

	public Runner(Accumulator tr, Map<String, Long> counters, Queue<String> dataQueue) {
		this.tr = tr;
		this.dataQueue = dataQueue;
		this.counters = counters;
	}

	@Override
	public void run() {
		while (!dataQueue.isEmpty()) {
			String line = dataQueue.poll();
			if (line != null) {
				String[] words = tr.mapToTokens(line);
				String[] legalWords = tr.filterIllegalTokens(words);
				String[] lowerCaseWords = tr.mapToLowerCase(legalWords);
				for (String word : lowerCaseWords) {
					tr.reduce(counters, word);
				}
			}
		}
	}
}
