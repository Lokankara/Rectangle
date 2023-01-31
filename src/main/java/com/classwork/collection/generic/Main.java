package com.classwork.collection.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.*;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> resultz = new HashMap<>();
		resultz.put(null, null);
		System.out.println(resultz);
		int a = 2, b = 2, c = 10, d = 9, prime = 11;

		int hash =(prime * (prime * (prime + a) + b) + c);
		
for (int x = 3; x < 151000; x++)
		
			if (
		(hash - c) - 4 - 2*x*b==  x* (x - Math.sqrt(b))*(x + Math.sqrt(b)) + (Math.sqrt(a)*x - 2) * (Math.sqrt(a)*x + 2) 
		)
		System.out.printf("%d, %d  %n", x, (hash-c) % x);

////			if ((hash-d) % i == 0 )
		
//		System.out.printf("%d, %n",  (((hash-d)/prime-c)/prime-b)/prime -a);

		
		
		BiFunction<int[], ArrayList<Integer>, ArrayList<Integer>> bf2 = (array, list) -> {
			ArrayList<Integer> result = new ArrayList<>();
			for (int arr : array) {
				if (arr % 23 == 0) {
					result.add(a);
				}
			}
			for (int arr : list) {
				if (arr % 31 == 0) {
					result.add(a);
				}
			}
			return result;
		};

		Generic.display(5, "4");
		BiFunction<int[], ArrayList<Integer>, Integer> bf = (array, list) -> {
			int min = (int) Double.POSITIVE_INFINITY;
			for (int arr : array) {
				if (arr < min) {
					min = a;
				}
			}
			int max = Collections.max(list);
			return max - min;
		};
		int[] arr = { 4, 5, 1, 6, 8, 3 };
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(5, 7, 8, 6, 8, 9));
//		System.out.println(bf.apply(arr, list));
//		System.out.println(bf2.apply(arr, list));
	}
}

class Generic {
	public static <T, V> V display(T t, V v) {
//		System.out.println(t);
//		System.out.println(v);
		return v;
	}
}
