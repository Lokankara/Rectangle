package com.homework.stream;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.*;
import java.util.Arrays;

public class ParallelStreams {

	public static String sentences = "You must have a cup of tea. "
			+ "If you don't think, you shouldn't talk. "
			+ "I have an excellent idea. "
			+ "Let's change the subject. "
			+ "Ah, but it's very rude to sit down without being invited. "
			+ "Careful, she's stark raving mad. "
			+ "I shall elucidate. "
			+ "Twinkle twinkle little bat. "
			+ "How I wonder what you're at. "
			+ "Up and above the world you fly, like a tea tray in the sky. "
			+ "You can always take more than nothing. "
			+ "Why is a raven like a writing desk.";

	private static final AtomicInteger sentence = new AtomicInteger(0);
	private static final AtomicInteger difference = new AtomicInteger(0);

	public static void main(String[] args) {

		Integer[] numbers = getNumbers(0, 20, 100_000);

		Map<Integer, Long> evenParallelMap = getMapParallelMode(numbers);
		Map<Integer, Long> evenSequentialMap = getMapSequentialMode(numbers);
		
		System.out.println(evenParallelMap);
		System.out.println(evenSequentialMap);
		
		Map<Integer, Integer> mapCounter = defineDifference(sentences);
		System.out.println(mapCounter);
	}
	
	private static Map<Integer, Long> getMapSequentialMode(Integer[] numbers) {
		
		long start = System.nanoTime();
		
		Map<Integer, Long> sortedByValues = sortByValue(
				Arrays.stream(numbers)
				.sequential()
				.filter(n -> n % 2 == 0)
				.collect(groupingBy(i -> i, counting())));
		
		long end = System.nanoTime();

		System.out.printf("Execution time in sequential mode: %s microseconds%n", (end - start) / 1000);
		return sortedByValues;
	}

	private static Map<Integer, Long> getMapParallelMode(Integer[] numbers) {
		
		long start = System.nanoTime();
		
	    Map<Integer, Long> sortedByValues = sortByValue(
	    		Arrays.stream(numbers)
				.parallel()
				.filter(n -> n % 2 == 0)
				.collect(groupingByConcurrent(i -> i, counting())));

	    long end = System.nanoTime();
        
		System.out.printf("Execution time in parallel mode: %s microseconds%n", (end - start) / 1000);
		return sortedByValues;
	}

	private static Map<Integer, Long> sortByValue(Map<Integer, Long> map) {

		TreeMap<Integer, Long> sortedByValues = new TreeMap<>(
                (a, b) -> map.get(a).compareTo(map.get(b)) == 0
                        ? 1 : map.get(a).compareTo(map.get(b)));
        
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static Integer[] getNumbers(int min, int max, int range) {
		return ThreadLocalRandom.current()
				.ints(min, max + 1)
				.limit(range)
				.boxed()
				.toArray(Integer[]::new);
	}

	private static Map<Integer, Integer> defineDifference(String sentences) {
		// [.!?] 33 46 63, [auioe] 97 101 105 111 117, [a-z] 96-122
		return sentences.toLowerCase().chars()
				.parallel()
				.filter(ch -> ch == 33 || ch == 46 || ch == 63 || ch > 95 && ch < 123)
				.collect(ConcurrentHashMap::new, (map, ch) -> {
					if (ch == 33 || ch == 46 || ch == 63) {
//						synchronized (map) {
						map.put(sentence.incrementAndGet(), difference.getAndSet(0));
//						}
					} else {
						difference.addAndGet((ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117) ? -1 : 1);
					}
				}, ConcurrentHashMap::putAll);
	}
}
