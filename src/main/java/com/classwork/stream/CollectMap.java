package com.classwork.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.homework.stream.CollectorsDispatcher;

import java.util.stream.Collector;

public class CollectMap {
	public static void main(String[] args) {
		String[] FIRST_NAMES = { "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Evelyn",
				"Abigail" };
		String[] NAMES = { "Emma", "Noah", "Olivia", "Liam", "Ava", "William", "Sophia", "Mason", "Isabella", "James",
				"Mia", "Benjamin", "Charlotte", "Jacob", "Amelia", "Michael", "Evelyn", "Elijah" };

		Function<Integer, ArrayList> keyMapper = ArrayList::new;
		Function<Integer, ArrayList> valueMapper = ArrayList::new;
		List<String> nameList = Stream.of(NAMES, FIRST_NAMES).flatMap(Arrays::stream)
				.collect(Collectors.toCollection(ArrayList::new));

		Collector<String, ?, Map<Boolean, Long>> collector = Collectors.partitioningBy(s -> s.length() > 4,
				Collectors.counting());
		Map<Boolean, Long> booleanLongMap = nameList.stream().collect(collector);

		Collector<String, ?, Map<Boolean, List<String>>> collectorList = Collectors.partitioningBy(s -> s.length() > 4);
		Map<Boolean, List<String>> listMap = nameList.stream().collect(collectorList);

		Collector<String, ?, Map<Integer, List<String>>> collectorString = Collectors.groupingBy(String::length);
		Map<Integer, List<String>> integerListMap = nameList.stream().collect(collectorString);

		Collector<String, ?, Map<Integer, Set<String>>> collectorSet = Collectors.groupingBy(String::length,
				Collectors.toCollection(TreeSet::new));
		Map<Integer, Set<String>> integerSetMap = nameList.stream().collect(collectorSet);

		Collector<String, ?, Map<Integer, String>> mapCollector = Collectors.toMap(String::length, Function.identity(),
				"%s %s"::formatted, ConcurrentHashMap::new);
		Map<Integer, String> collectMap = nameList.stream().collect(mapCollector);

		Collector<String, ?, LinkedHashMap<Character, String>> linkedCollector = Collectors
				.toMap(name -> name.charAt(0), name -> name, "%s, %s"::formatted, LinkedHashMap::new);
		LinkedHashMap<Character, String> linkedHashMap = nameList.stream().collect(linkedCollector);

		Collector<List<Integer>, ?, List<Integer>> flatMapping = Collectors
				.flatMapping(l -> l.stream().filter(i -> i % 2 == 0), Collectors.toList());
		List<Integer> listInt = Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)).collect(flatMapping);

		Collector<List<Integer>, ?, Map<Integer, List<Integer>>> listMapCollector = Collectors.groupingBy(
				Collection::size, Collectors.flatMapping(l -> l.stream().filter(i -> i % 2 == 0), Collectors.toList()));
		Map<Integer, List<Integer>> map = Stream.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10))
				.collect(listMapCollector);
		

		List<Integer> numbers = CollectorsDispatcher.getNumbers(0, 9, 10);
		
		Map<Integer, List<Integer>> indexMap = IntStream.range(0, numbers.size()).boxed()
				.collect(Collectors.groupingBy(numbers::get));

		Map<Boolean, Integer> index = new HashMap<>();
		Integer max = Collections.max(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			Integer integer = numbers.get(i);
			if (integer == max) {
				index.put(true, i);
			}
		}

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

		
		System.err.println(mapIndex);
		System.out.println(indexMap);

	}
}