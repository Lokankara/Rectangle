package com.test.sierra.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Tree {

	public static void main(String[] args) {

		TreeSet<String> s = new TreeSet<String>();
		TreeSet<String> subs = new TreeSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");

		subs = (TreeSet) s.subSet("b", true, "d", true);
		System.out.println(s.size() + " " + subs.size());

		s.add("g");
		s.pollFirst();
		s.pollFirst();
		s.add("c2");
		System.out.println(s.size() + " " + subs.size());

		
		TreeSet<String> map = new TreeSet<>();
		map.add("one");
		map.add("two");
		map.add("three");
		map.add("four");
		map.add("one");
		Iterator<String> it = map.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
