package com.classwork.threads.io.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Transformer {
	public String[] mapToTokens(String input) {
		return input.split("[ _\\.,\\-\\+]");
	}

	String[] filterIllegalTokens(String[] words) {
		List<String> filteredList = new ArrayList<>();
		Pattern p = Pattern.compile("\\b([a-zA-z])[a-zA-Z]*\\1\\b");
		Matcher m;
		for (String word : words) {
			m = p.matcher(word);
			if (m.find()) {
				filteredList.add(m.group());
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

	public synchronized void reduce(Map<String, Integer> counter, String word) {
		counter.compute(word, (key, value) -> value == null ? 1 : ++value);
	}
}
