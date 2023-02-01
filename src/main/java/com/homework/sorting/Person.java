package com.homework.sorting;

import java.util.Objects;

class Person {
	String name;
	String region;
	int birthYear;
	boolean isMale;

	public Person(String name, String region, int birthYear, boolean isMale) {
		super();
		this.name = name;
		this.region = region;
		this.birthYear = birthYear;
		this.isMale = isMale;
	}

	public Person() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthYear, isMale, name, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return birthYear == other.birthYear && isMale == other.isMale && Objects.equals(name, other.name)
				&& Objects.equals(region, other.region);
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, region=%s, birthYear=%d, isMale=%s]", name, region, birthYear, isMale);
	}
}
