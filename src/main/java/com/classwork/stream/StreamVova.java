package com.classwork.stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVova {
	public static void main(String[] args) {
		try (Stream<String> lines = Files.lines(Paths.get("alice"))) {
			lines.map(StreamUtil::capitalizeWordsInLine)
					.collect(StreamUtil.capitalizeWordsCollector("alice.txt"))
					.forEach(System.out::println);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String text;
		try (Stream<String> lines = Files.lines(Paths.get("streamTask/streamText.txt"))) {
			text = lines.reduce(new StringBuilder(""), StringBuilder::append, StringBuilder::append).toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		StreamUtil.getSentencesList(text).stream().sorted(Comparator.comparingInt(StreamUtil::countWordsInSentence))
				.forEach(System.out::println);

		System.out.println("\n-------Task 3 - Split collection - negative-positive -------");
		List<Integer> integerList = List.of(23, 43, 0, -64, 23, 13, 123, -54, 82391, -2454, 30, -213);
		Map<NumberType, List<Integer>> map;
		map = integerList.stream()
				.collect(Collectors.groupingBy(integer -> integer >= 0 ? NumberType.POSITIVE : NumberType.NEGATIVE,
						Collectors.mapping(Function.identity(), Collectors.toList())));
		System.out.println(map.entrySet());

	}
}

final class StreamUtil {

	private StreamUtil() {
	}

	public static String capitalizeWordsInLine(String line) {
		Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
		Matcher matcher = wordPattern.matcher(line);
		StringBuilder sb = new StringBuilder();
		while (matcher.find()) {
			matcher.appendReplacement(sb, capitalizeString(matcher.group()));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private static String capitalizeString(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static Collector<String, List<String>, List<String>> capitalizeWordsCollector(String filePath) {
		UnaryOperator<List<String>> finisher = lines -> {
			try {
				Files.write(Paths.get(filePath), lines);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return lines;
		};
		return Collector.of(ArrayList::new, List::add, ((e1, e2) -> e1), finisher);
	}

	public static int countWordsInSentence(String sentence) {
		Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
		Matcher matcher = wordPattern.matcher(sentence);
		int wordsCount = 0;
		while (matcher.find()) {
			wordsCount++;
		}
		return wordsCount;
	}

	public static List<String> getSentencesList(String text) {
		Pattern sentencePattern = Pattern.compile("[\\w\\s,\\-\"]+\\.");
		Matcher matcher = sentencePattern.matcher(text);
		List<String> sentences = new ArrayList<>();
		while (matcher.find()) {
			sentences.add(matcher.group().trim());
		}
		return sentences;
	}
}

enum NumberType {
	POSITIVE, NEGATIVE;
}
