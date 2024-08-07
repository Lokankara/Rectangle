package com.classwork.stream.horstmann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

public class CollectorHorstmann {
	public static void main(String[] args) throws IOException {

		Map<Integer, String> idToName = Person.people().collect(Collectors.toMap(Person::getId, Person::getName));
		System.out.println("idToName: " + idToName);

		Map<Integer, Person> idToPerson = Person.people().collect(Collectors.toMap(Person::getId, Function.identity()));
		System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

		idToPerson = Person.people()
				.collect(Collectors.toMap(Person::getId, Function.identity(), (existingValue, newValue) -> {
					throw new IllegalStateException();
				}, TreeMap::new));
		System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

		Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
		System.out.println("countryToLocaleSet: " + countryToLocaleSet);

		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(Locale::getCountry, counting()));
		System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

		Stream<City> cities = readCities("cities.txt");
		Map<String, Integer> stateToCityPopulation = cities
				.collect(groupingBy(City::getState, summingInt(City::getPopulation)));
		System.out.println("stateToCityPopulation: " + stateToCityPopulation);

		cities = readCities("cities.txt");
		Map<String, Optional<String>> stateToLongestCityName = cities.collect(
				groupingBy(City::getState, mapping(City::getName, maxBy(Comparator.comparing(String::length)))));
		System.out.println("stateToLongestCityName: " + stateToLongestCityName);

		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> countryToLanguages = locales
				.collect(groupingBy(Locale::getDisplayCountry, mapping(Locale::getDisplayLanguage, toSet())));
		System.out.println("countryToLanguages: " + countryToLanguages);

		cities = readCities("cities.txt");
		Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities
				.collect(groupingBy(City::getState, summarizingInt(City::getPopulation)));
		System.out.println(stateToCityPopulationSummary.get("NY"));

		cities = readCities("cities.txt");
		Map<String, String> stateToCityNames = cities.collect(
				groupingBy(City::getState, reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + ", " + t)));

		cities = readCities("cities.txt");
		stateToCityNames = cities.collect(groupingBy(City::getState, mapping(City::getName, joining(", "))));
		System.out.println("stateToCityNames: " + stateToCityNames);
	}

	public static Stream<City> readCities(String filename) throws IOException {
		return Files.lines(Paths.get(filename)).map(l -> l.split(", "))
				.map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
	}
}
