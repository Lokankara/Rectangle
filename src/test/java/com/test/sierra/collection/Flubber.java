package com.test.sierra.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Flubber {

	public static void main(String[] args) {
		System.out.println("If the equals() method returns false, the hashCode() comparison == might return true.");
		System.out.println("often two dissimilar objects can return the same hashcode value.");
		System.out.println("If the hashCode() comparison == returns true, the equals() method might return true.");
		System.out.println("if the hashCode() comparison returns ==, the two objects might or might not be equal");
		System.out.println("Whenever it is invoked on the same object more than once during"
				+ "an execution of a Java application, the {@code hashCode} method"
				+ "must consistently return the same integer, provided no information"
				+ "used in {@code equals} comparisons on the object is modified."
				+ "This integer need not remain consistent from one execution of an"
				+ "application to another execution of the same application."
				+ "\r\nIf two objects are equal according to the {@link"
				+ "equals(Object) equals} method, then calling the {@code"
				+ "hashCode} method on each of the two objects must produce the" + "same integer result."
				+ "\r\nIt is <em>not</em> required that if two objects are unequal"
				+ "according to the {@link equals(Object) equals} method, then"
				+ "calling the {@code hashCode} method on each of the two objects"
				+ "must produce distinct integer results.  However, the programmer"
				+ "should be aware that producing distinct integer results for"
				+ "unequal objects may improve the performance of hash tables.");

		// List<String> x = new LinkedList<String>();
//		 TreeSet<String> x = new TreeSet<String>();
//		  HashSet<String> x = new HashSet<String>();
		Queue<String> x = new PriorityQueue<String>();
//		 ArrayList<String> x = new ArrayList<String>();
//	 LinkedList<String> x = new LinkedList<String>();

		x.add("one");
		x.add("two");
		x.add("TWO");
		System.out.println(x.poll());
		System.out.println(x);

		List<List<Integer>> table = new ArrayList<List<Integer>>();
		for (int i = 0; i <= 10; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= 10; j++)
				row.add(i * j);
			table.add(row);
		}
		for (List<Integer> row : table)
			System.out.println(row);

		List<String> a = new ArrayList<String>();
		a.add(" x");
		a.add("xx");
		a.add("Xx");
		Comparator<String> c = Collections.reverseOrder();
		Collections.sort(a,c);
		for (String s : a)
			System.out.println(s);
	}

}
