package com.homework.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reducer {

	public static void main(String[] args) {// min, max, range
		Integer[] a = generateRandomNumber(2, 10, 4);
		Integer[] b = generateRandomNumber(2, 10, 7);
		System.out.printf("Two Arrays: %s, %s%n", 
				Arrays.toString(a), Arrays.toString(b));

		// Task#1 - create a third ArrayList as a concatenation of two arrays;
		List<Integer> concatList = concat(a, b);
		System.out.printf("The new ArrayList: %s%n", concatList);

		Integer[] array = Stream.of(a, b).flatMap(Stream::of).toArray(Integer[]::new);
		// Task#2.1 - determine the arithmetic mean of the elements of the array of integers
		double average = getAverage(array);
		// Task#2.2 - and the number elements that are greater than the arithmetic mean;
		Long greaterThanAverage = Arrays.stream(array).filter(i -> i > average).count();
		System.out.printf("Arithmetic mean: %.2f%n", average);
		System.out.printf("Elements that are greater than the arithmetic mean: %s%n", greaterThanAverage);

		// Task#3 - remove duplicate maximum and minimum from a collection of integers.
		List<Integer> integers = distinctMinMax(concatList);
		System.out.printf("Unique minimum and maximum: %s%n", integers);
	}
	
	private static Integer[] generateRandomNumber(int min, int max, int range) {
		return ThreadLocalRandom.current()
				.ints(min, max + 1)
				.limit(range)
				.boxed()
				.toArray(Integer[]::new);
	}
	
	private static ArrayList<Integer> concat(Integer[] a, Integer[] b) {
		return Stream.of(a, b)
				.flatMap(Arrays::stream)
				.collect(Collectors.toCollection(
						ArrayList::new));
	}
	
	private static double getAverage(Integer[] array) {
		return Arrays.stream(array)
				.mapToInt(Integer::intValue)
				.summaryStatistics()
				.getAverage();
	}

	private static List<Integer> distinctMinMax(List<Integer> integers) {
		IntSummaryStatistics statistics = integers.stream()
				.mapToInt(Integer::intValue).summaryStatistics();

		return IntStream.concat(
				integers
					.stream()
					.filter(i -> i < statistics.getMax() && i > statistics.getMin())
				.mapToInt(Integer::intValue), 
				IntStream.of(statistics.getMin(), statistics.getMax()))
				.boxed().toList();
	}
}
