package com.homework.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Dispatcher {

	public static void main(String[] args) {
		List<Fest> festivals = new ArrayList<>();
		festivals.add(new Fest("Dynamo", "Eindhoven", YearMonth.AUGUST));
		festivals.add(new Fest("Woodstock", "Kammer", YearMonth.JULY));
		festivals.add(new Fest("Wacken", "Schleswig-Holstein", YearMonth.MAY));

		Collections.sort(festivals);
		festivals.forEach(System.out::println);
	}
}

class Fest implements Comparable<Fest>{
	private String name;
	private String place;
	private YearMonth month;

	@Override
	public int compareTo(Fest fest) {
		int compareByName = this.getName().compareTo(fest.getName());
		int compareByPlace = this.getPlace().compareTo(fest.getPlace());
		int compareByMonth = this.getMonth().compareTo(fest.getMonth());
	
		return compareByName == 0 
				? compareByPlace != 0 
				? compareByPlace 
				: compareByMonth 
				: compareByName;
	}

	
	public Fest(String name, String place, YearMonth month) {
		super();
		this.name = name;
		this.place = place;
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public YearMonth getMonth() {
		return month;
	}

	public void setMonth(YearMonth month) {
		this.month = month;
	}

	@Override
	public int hashCode() {
		return Objects.hash(month, name, place);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fest other = (Fest) obj;
		return month == other.month && Objects.equals(name, other.name) && Objects.equals(place, other.place);
	}

	@Override
	public String toString() {
		return String.format("Festival [name=%s, place=%s, month=%s]", name, place, month);
	}
}

enum YearMonth {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}
