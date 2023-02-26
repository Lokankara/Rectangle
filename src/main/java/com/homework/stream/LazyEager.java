package com.homework.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyEager {

	public static void main(String[] args) {

		String path = "";
		String filename = "alice";
		
		String sentences = readFile(path  + filename);
		String upperCaseWords = capitalze(sentences);
		List<String> sortedList = sortSentences(sentences);
	
		List<Integer> numbers = getNumbers(-100, 100, 20);
		List<Integer> positive = positiveOrNegative(numbers, true);
		List<Integer> negative = positiveOrNegative(numbers, false);

		Map<Boolean,List<Integer>> positiveOrNegative = positiveOrNegative(-100, 100, 20);

		print("Source word: ", sentences);
		print("Capitalized: ", upperCaseWords);

		sortedList.forEach(System.out::println);
		
		print("Source numbers: ", numbers);
		print("Positive numbers: ", positive);
		print("Negative numbers: ", negative);

		print("Positive numbers: ", positiveOrNegative.get(true));
		print("Negative numbers: ", positiveOrNegative.get(false));
		
	}

	private static String readFile(String filename) {
		  try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			  return stream.collect(Collectors.joining(System.lineSeparator()));
		  } catch (IOException e) {
			  System.err.println(e);
			  throw new RuntimeException();
		  }
	}
	
	private static List<String> sortSentences(String sentences) {
	       return Pattern.compile("(?<=[.])\\s+")
	    		   .splitAsStream(sentences)
	    		   .sorted(Comparator.comparingInt(sentence -> sentence.split("\\s+").length))
	    		   .toList();
	       	}

	private static String capitalze(String sentences) {
		return Arrays.stream(sentences.split(" "))
				.map(sentence -> Pattern.compile("\\b( ?=\\p{Ll})\\b")
						.splitAsStream(sentence)
						.map(word -> "%s%s".formatted(
								Character.toUpperCase(word.charAt(0)), 
								word.substring(1)))
						.collect(Collectors.joining()))
				.collect(Collectors.joining(" "));
	}

	private static List<Integer> getNumbers(int min, int max, int range) {
		return IntStream
				.range(0, range)
				.mapToObj(i -> ThreadLocalRandom.current().nextInt(min, max + 1))
				.toList();
	}

	private static List<Integer> positiveOrNegative(List<Integer> numbers, boolean flag) {
		return numbers.stream()
				.collect(Collectors.partitioningBy(n -> n >= 0))
				.get(flag);
	}

	private static Map<Boolean, List<Integer>> positiveOrNegative(int min, int max, int range) {
		return
			ThreadLocalRandom.current()
			.ints(min, max + 1)
			.limit(range)
			.boxed()
			.collect(Collectors.groupingByConcurrent(n -> n >= 0));
	}


	private static void print(String message, Object data) {
		System.out.printf("%s%s%n", message, data);
	}
}