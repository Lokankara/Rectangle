package com.test.jaworsky;

import java.util.*;

public class Question {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		v1.add("This");
		v1.add(v2);
		String s = (String) v1.elementAt(0);
		v1 = v2;
		v2 = v1;
		v1.add(s);

		HashSet set = new HashSet();
		String s1 = "abc";
		String s2 = "def";
		String s3 = "";
		set.add(s1);
		set.add(s2);
		set.add(s1);
		set.add(s2);
		Iterator i = set.iterator();
		while (i.hasNext()) {
			s3 += (String) i.next();
		}
		System.out.println(s3);

		TreeMap map = new TreeMap();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");

		displayMap(map);
	}

	static void displayMap(TreeMap map) {
		Collection c = map.entrySet();
		Iterator i = c.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			System.out.print(o.toString());
		}
	}
}