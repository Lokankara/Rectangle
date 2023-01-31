package com.test.sierra.collection;

import java.util.HashSet;
import java.util.Objects;

public class Group extends HashSet<Person> {
	public static void main(String[] args) {
		Group g = new Group();
		g.add(new Person("Hans"));
		g.add(new Person("Lotte"));
		g.add(new Person("Jane"));
		g.add(new Person("Hans"));
		g.add(new Person("Jane"));
		System.out.println("Total: " + g.size());
	}

	public boolean add(Person o) {
		System.out.println("Adding: " + o);
		return super.add(o);
	}
}

class Person {
	private final String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		return Objects.equals(name, other.name);
	}

	public String toString() {
		return name;
	}
}