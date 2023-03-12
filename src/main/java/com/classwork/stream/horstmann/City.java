package com.classwork.stream.horstmann;

import java.util.Locale;
import java.util.stream.Stream;

public class City {

	String name;
	String state;
	int population;

	public String getState() {
		return state;
	}

	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}

	

	public City(String name, String state, int population) {
		super();
		this.name = name;
		this.state = state;
		this.population = population;
	}

	public static Stream<City> cities() {
		return Stream.of(new City("Ea", "X", 100500), new City("A","B", 200500), new City("S","C", 300500));
	}
}

