package com.classwork.threads.io.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Accumulator {
	public String[] mapToTokens(String input) {
		return input.split("[ _\\.,\\-\\+]");
	}

	String[] filterIllegalTokens(String[] words) {
		List<String> filteredList = new ArrayList<>();
		for (String word : words) {
			if (word.matches("[a-zA-Z]+")) {
				filteredList.add(word);
			}
		}
		return filteredList.toArray(new String[filteredList.size()]);
	}

	String[] mapToLowerCase(String[] words) {
		String[] filteredList = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			filteredList[i] = words[i].toLowerCase();
		}
		return filteredList;
	}

	public synchronized void reduce(Map<String, Long> counter, String word) {
		if (counter.containsKey(word)) {
			counter.put(word, counter.get(word) + 1);
		} else {
			counter.put(word, 1L);
		}
	}
}
