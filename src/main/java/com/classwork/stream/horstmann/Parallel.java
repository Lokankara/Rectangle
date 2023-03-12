package com.classwork.stream.horstmann;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.homework.stream.LazyEager;
import com.homework.stream.ParallelStreams;

public class Parallel {

	private static final Word w = new Word(0);
	private static final Map<Integer, Integer> map = new ConcurrentHashMap<>();
	private static final AtomicInteger sentence = new AtomicInteger(0);

	public static void main(String[] args) {

		Map<String, String> languageNames = locales().collect(Collectors.toMap(Locale::getDisplayLanguage,
				l -> l.getDisplayLanguage(l), (existingValue, newValue) -> existingValue));

//		System.out.println("languageNames: " + languageNames);

		Map<String, Set<String>> countryLanguageSets = locales()
				.collect(Collectors.toMap(Locale::getDisplayCountry, l -> Set.of(l.getDisplayLanguage()), (a, b) -> {
					Set<String> union = new HashSet<>(a);
					union.addAll(b);
					return union;
				}));

//		System.out.println("countryLanguageSets: " + countryLanguageSets);

		Map<String, Set<Locale>> countryToLocaleSet = locales().collect(groupingBy(Locale::getCountry, toSet()));

		Map<String, List<Locale>> countryToLocales = locales().collect(Collectors.groupingBy(Locale::getCountry));

		List<Locale> swissLocales = countryToLocales.get("CH");

		Map<Boolean, List<Locale>> englishAndOtherLocales = locales()
				.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

		List<Locale> englishLocales = englishAndOtherLocales.get(true);

		Map<String, Long> countryToLocaleCounts = locales().collect(groupingBy(Locale::getCountry, counting()));
		
		Map<String, Set<String>> countryToLanguages = locales().collect(
				 groupingBy(Locale::getDisplayCountry,
				 mapping(Locale::getDisplayLanguage,
				 toSet())));
		
		
		Map<String, Integer> stateToCityPopulation = City.cities().
				collect(groupingBy(City::getState, summingInt(City::getPopulation)));

		Map<String, Optional<City>> stateToLargestCity = City.cities().collect(
				 groupingBy(City::getState,
				maxBy(Comparator.comparing(City::getPopulation))));

		Map<Character, Integer> stringCountsByStartingLetter = strings()
				.collect(
				 groupingBy(s -> s.charAt(0),
				collectingAndThen(toSet(), Set::size)));
		
		Map<Character, Set<Integer>> stringLengthsByStartingLetter = 
				strings()
				.collect(
				 groupingBy(s -> s.charAt(0),
				mapping(String::length, toSet())));
		
		Map<String, Set<City>> largeCitiesByState
		 = City.cities().collect(
		 groupingBy(City::getState,
		 filtering(c -> c.getPopulation() > 500000,
		 toSet()))); // States without large cities have empty sets

		Map<String, IntSummaryStatistics> stateToCityPopulationSummary = City.cities().collect(
				 groupingBy(City::getState,
				summarizingInt(City::getPopulation)));

		
		System.out.println(countryToLocaleSet);
		System.out.println(stateToCityPopulationSummary);
		System.out.println(stringLengthsByStartingLetter);
		System.out.println(stringCountsByStartingLetter);
		System.out.println(stateToCityPopulation);
		System.out.println(stateToLargestCity);
		System.out.println(countryToLanguages);
		System.out.println(countryToLocaleCounts);
		
		// [.!?] 33 46 63, [auioe] 97 101 105 111 117, [a-z] 96-122
//		{1=0, 2=9, 3=0, 4=8, 5=10, 6=9, 7=1, 8=9, 9=3, 10=10, 11=7, 12=7}

		ParallelStreams.sentences.toLowerCase().chars().filter(c -> c == 33 || c == 46 || c == 63 || c > 95 && c < 123)
				.forEach(c -> {
					synchronized (w) {
						if (c == 33 || c == 46 || c == 63) {
//							System.out.printf("%s ", w.getAndSet(0));
							map.put(sentence.incrementAndGet(), w.getAndSet(0));
//							System.out.println(Thread.currentThread().getName());
						} else {
							if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
								w.dec();
							} else {
								w.inc();
							}
						}
					}
				});

		System.out.println(map);

		List<Integer> numbers = LazyEager.getNumbers(0, 10, 1_500_000);

		Map<Boolean, List<Integer>> mapList = numbers.stream().parallel()
				.collect(partitioningBy(i -> i > 5, mapping(n -> n % 2 == 0 ? n * 2 : n * 5, toList())));

	}

	private static Stream<String> strings() {
		return Arrays.stream(ParallelStreams.sentences.split("."));
	}

	private static Stream<Locale> locales() {
		return Stream.of(Locale.getAvailableLocales());
	}


}

class Word {
	int count;

	public Word(int count) {
		super();
		this.count = count;
	}

	public synchronized int getAndSet(int i) {
		int r = count;
		count = i;
		return r;
	}

	public int getInc() {
		return count;
	}

	public synchronized void inc() {
		count++;
	}

	public synchronized void dec() {
		count--;
	}

	public synchronized void set(int i) {
		count = 0;
	}
}