package com.test.sierra.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
	
	static class PQsort implements Comparator<Integer> { // inverse sort
		public int compare(Integer one, Integer two) {
			return two - one; // unboxing
		}
	}

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("2");
		pq.add("4");
//		System.out.print(pq.peek() + " ");
		pq.offer("1");
		pq.add("3");
//		pq.remove("1");
//		System.out.print(pq.poll() + " ");
//		if(pq.remove("2")) System.out.print(pq.poll() + " ");
//		System.out.println(pq.poll() + " " + pq.peek());
//		System.out.println(pq);

		int[] ia = { 1, 5, 3, 7, 6, 9, 8 }; // unordered data
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // use natural order
		for (int x : ia)
			pq1.offer(x);
		for (int x : ia) // review queue
			System.out.print(pq1.poll() + " ");
		System.out.println("");
		PQsort pqs = new PQsort(); // get a Comparator
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs); // use Comparator
		for (int x : ia) // load queue
			pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for (var x : ia) // review queue
			System.out.print(pq2.poll() + " ");
	}
}
