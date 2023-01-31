package com.test.sierra.collection;

import java.util.*;

class AlgaeDiesel {
	public static void main(String[] args) {
		String[] sa = { "foo", "bar", "baz" };
		List<String> list = Arrays.asList(sa);
		Collections.sort(list);

//		Comparator<String> c = Collections.reverseOrder();

		int search = Collections.binarySearch(list, "foo");
		System.out.println(search);
	}
}