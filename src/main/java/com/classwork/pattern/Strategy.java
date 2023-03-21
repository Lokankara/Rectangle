package com.classwork.pattern;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Strategy {
	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}

	public static void main(String[] args) {
		List<Integer> ns = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = sum(ns, ignore -> true);
		int odd = sum(ns, Strategy::isOdd);
		System.out.println(sum);
		System.out.println(odd);
	}

	public static int sum(List<Integer> numbers, Predicate<Integer> selector) {

		return numbers.stream().filter(selector)
				.map(Function.identity()).reduce(0, Integer::sum);
	}
}