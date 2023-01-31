package com.test.sierra.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Before {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.add("Veronica");
		q.add("Wallace");
		q.add("Duncan");
		showAll(q);
		
		Set<String> set = new TreeSet();
		set.add("2");
		set.add("3");
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext())
		System.out.print(it.next() + " ");
	}

	public static void showAll(Queue q) {
		q.add(new Integer(42));
		while (!q.isEmpty())
			System.out.print(q.remove() + " ");
	}
}
