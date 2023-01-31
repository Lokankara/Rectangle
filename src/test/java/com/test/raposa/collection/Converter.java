package com.test.raposa.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Converter {

	public static void main(String[] args) {

		List<String> list = List.of("one", "two", "three", "four");
		String[] array = list.<String>toArray(new String[0]);
		for (String string : array) {
			System.out.println(string);
		}
		List<Long> longs = new ArrayList<>();

		while (longs.size() < 10) {
			longs.add(Math.round(Math.random() * 10));
		}
		Collections.sort(longs);
		int index = Collections.binarySearch(longs, new Long(5));
		String string = (index >= 0) ? String.format("5 found at index %d", index) : ("5 not found");
		System.out.println(string);

//		longs.forEach(i -> System.out.printf("%d ", i));

		List<String> strings = Arrays.<String>asList(array);

//		strings.forEach(s -> System.out.printf("%s ", s));
//		System.out.println();
		
		Arrays.sort(array);
		Arrays.binarySearch(array, "one");
		for (String arr : array) {
			System.out.println(arr);
		}
		
	}
}
