package com.test.raposa.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class TestList {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add(7);
		for (var s : list) {
			System.out.print(s);
		}
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(4);
		values.add(5);
		values.set(1, 6);
		values.remove(0);
		for (Integer v : values) {
			System.out.print(v);
		}
		Stack<String> greetings = new Stack<String>();
		greetings.push("hello");
		greetings.push("hi");
		greetings.push("ola");
		greetings.pop();
		greetings.peek();
		Iterator iter = greetings.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		List<String> lists = new Vector<String>();
//		  HashSet < Number > hs = new HashSet < Integer > ();
		Map<String, ? extends Number> hm = new HashMap<String, Integer>();
		HashSet<? super ClassCastException> set = new HashSet<Exception>();
//		List<Object> valuez = new LinkedHashSet<Object>();
	}

}
