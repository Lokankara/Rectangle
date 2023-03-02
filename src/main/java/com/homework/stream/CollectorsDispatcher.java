package com.homework.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
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

		List<Integer> numbers = getNumbers(-10, 10, 10);
		IntSummaryStatistics statistics = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
		int min = statistics.getMin();
		int max = statistics.getMax();

		List<Integer> swapped = numbers.stream().map(number -> number == min ? max : number == max ? min : number)
				.toList();
		
		System.out.println(numbers);
		System.out.println(swapped);

		Map<Integer, List<Integer>> mapIndex = new HashMap<>();

		for (int i = 0; i < numbers.size(); i++) {
			if (!mapIndex.keySet().contains(numbers.get(i))) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				mapIndex.put(numbers.get(i), list);
			} else {
				List<Integer> list = mapIndex.get(numbers.get(i));
				list.add(i);
			}
		}

		Map<Integer, List<Integer>> indexMap = IntStream.range(0, numbers.size()).boxed()
				.collect(Collectors.groupingBy(numbers::get));

		System.err.println(mapIndex);
		System.out.println(indexMap);

		int[] array = IntStream.range(0, numbers.size()).filter(i -> numbers.get(i) == statistics.getMin()).toArray();

		Map<Boolean, Integer> index = new HashMap<>();
		for (int i = 0; i < numbers.size(); i++) {
			Integer integer = numbers.get(i);
			if (integer == statistics.getMax()) {
				index.put(true, i);
			}
		}

//		Collector<String, ?, Map<Boolean, Long>> collector = Collectors.partitioningBy(s -> s.length() > 4,
//				Collectors.counting());

		List<Integer> greaterThanAverage = numbers.stream()
				.filter(a -> a > numbers.stream().mapToInt(i -> i).average().orElse(0.0)).toList();
		System.out.println(greaterThanAverage);

		Matcher matcher = Pattern.compile("[^.!?]+[.!?]").matcher(sentences);
		Map<Integer, Long> differenceSounds = IntStream.range(1, sentences.length() + 1).filter(i -> matcher.find())
				.boxed().collect(Collectors.toMap(number -> number, number -> calculate(matcher.group())));

		System.out.println(differenceSounds);
	}

	private static long calculate(String sentence) {
		return count(sentence, "zxcvbnmsdfghjklqwrtyp") - count(sentence, "aeiou");
	}

	private static long count(String sentence, String letters) {
		return sentence.toLowerCase().chars().filter(letter -> letters.indexOf(letter) > -1).count();
	}

	private static List<Integer> getNumbers(int min, int max, int range) {
		return IntStream.range(0, range).mapToObj(i -> ThreadLocalRandom.current().nextInt(min, max + 1)).toList();
	}
}
