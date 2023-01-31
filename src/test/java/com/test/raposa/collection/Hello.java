package com.test.raposa.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Hello<T> {
	T t;

	public Hello(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}

	public static void main(String[] args) {

		
		 int [] random = {6, -4, 12, 0, -10};
		 int x = 12;
		 Arrays.sort(random);
		 
		 int y = Arrays.binarySearch(random, x);
		 System.out.println(y);
		
		Map<Integer, Integer> mapi = new HashMap<Integer, Integer>(10);
		for (int i = 1; i <= 10; i++) {
			mapi.put(i, i * i);
		}
		System.out.println(mapi.get(4));

		System.out.print(new Hello<String>("hi"));
		System.out.print(new Hello("there"));

		Set<Number> numbers = new HashSet<Number>();
		numbers.add(new Integer(86));
		numbers.add(75);
		numbers.add(1111175);
		numbers.add(new Integer(86));
		numbers.add(null);
		numbers.add(309L);
		Iterator iter = numbers.iterator();
		while (iter.hasNext()) {
			System.out.printf("%s ", iter.next());
		}
		TreeSet<String> tree = new TreeSet<String>();
		tree.add("one");
		tree.add("One");
		tree.add("ONE");
		System.out.println(tree.ceiling("On"));

		Map<String, Double> map = new HashMap<String, Double>();
		map.put(" pi ", 3.14159);
		map.put(" e ", 2.71828D);
		map.put("log(1) ", new Double(0.0));
//		map.put('x', new Double(123.4));
		System.out.println(map);

		String[] values = { "abc", "Abb", "aab" };
		Arrays.sort(values, new MyComparator());
		for (String s : values) {
			System.out.print(s + " ");
		}
	}

	static class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return a.toLowerCase().compareTo(b.toLowerCase());
		}
	}
}