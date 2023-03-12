package com.homework.stream;

import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsDispatcher {

	private static String sentences = "You must have a cup of tea. If you don't think, you shouldn't talk. I have an excellent idea. Let's change the subject. Ah, but it's very rude to sit down without being invited. Careful, she's stark raving mad. I shall elucidate. Twinkle twinkle little bat. How I wonder what you're at. Up and above the world you fly, like a tea tray in the sky. You can always take more than nothing. Why is a raven like a writing desk.";

	public static void main(String[] args) {

		List<Integer> numbers = getNumbers(0, 9, 10);

		// Task#1 - swap minimum and maximum
		List<Integer> swapped = swap(numbers);

		System.out.printf("Source:  %s%n", numbers);
		System.out.printf("Swapped: %s%n", swapped);

		// Task#2 - find number elements that are greater than the arithmetic mean;
		List<Integer> greaterThanAverage = findGreater(numbers);
		System.out.printf("Elements that are greater than the arithmetic mean: %s%n", greaterThanAverage);

		Map<Integer, Long> differenceSounds = defineDifference(sentences);
		System.out.printf("Difference between quantity consonants and vowels:%n%s%n", differenceSounds);
	}

	private static Map<Integer, Long> defineDifference(String sentences) {
		Matcher matcher = Pattern.compile("[^.!?]+[.!?]").matcher(sentences);
		return IntStream.range(1, sentences.length() + 1).filter(i -> matcher.find()).boxed()
				.collect(Collectors.toMap(number -> number,
						number -> count(matcher.group(), "zxcvbnmsdfghjklqwrtyp") - count(matcher.group(), "aeiou")));
	}

	private static LinkedList<Integer> swap(List<Integer> numbers) {
		IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();

		return numbers.stream().collect(LinkedList::new,
				(list, number) -> list.add(
						number == stats.getMin() ? stats.getMax() : number == stats.getMax() ? stats.getMin() : number),
				LinkedList::addAll);
	}

	private static List<Integer> findGreater(List<Integer> numbers) {
		return numbers.stream().filter(n -> n > numbers.stream().mapToInt(i -> i).average().orElse(0.0)).toList();
	}

	private static long count(String sentence, String pattern) {
		return sentence.toLowerCase().chars().filter(letter -> pattern.indexOf(letter) > -1).count();
	}

	public static List<Integer> getNumbers(int min, int max, int range) {
		return IntStream.range(0, range).mapToObj(i -> ThreadLocalRandom.current().nextInt(min, max + 1)).toList();
	}
}
