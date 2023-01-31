package com.test.sierra.collection;

import java.util.*;

public class MixUp {
	public static void main(String[] args) {
		Object o = new Object();
		Set s = new HashSet();
		s = new TreeSet();
		s = new LinkedHashSet();
		s.add("o");
		s.add(o);
		s.forEach(a -> System.out.println(a));
	}
}