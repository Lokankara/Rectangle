package com.test.sierra.collection;

import java.util.*;

public class LongWordFinder {
	public static void main(String[] args) {
		String[] array = { "123", "12345678", "1", "12", "1234567890" };
		List<String> list = Arrays.asList(array);
		Collection<String> resultList = getLongWords(list);
		System.out.println(resultList);
	}

	static public <E extends CharSequence> Collection<E> getLongWords(Collection<E> coll) {
		Collection<E> longWords = new ArrayList<E>();
		for (E word : coll)
			if (word.length() > 6)
				longWords.add(word);
		return longWords;
	}
}