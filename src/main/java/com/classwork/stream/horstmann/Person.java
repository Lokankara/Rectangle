package com.classwork.stream.horstmann;

import java.util.stream.Stream;

public class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format("%s[id=%d,name=%s]", getClass().getName(), id, name);
	}

	public static Stream<Person> people() {
		return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"), new Person(1003, "Mary"));
	}
}