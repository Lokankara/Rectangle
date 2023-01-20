package com.test.horstmann;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		var parts = new TreeSet<Item>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		System.out.println(parts);

		var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}

class Item implements Comparable<Item> {
	private String description;
	private int partNumber;

	public Item(String aDescription, int aPartNumber) {
		description = aDescription;
		partNumber = aPartNumber;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return String.format("#%d, desc:%s", partNumber, description);
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		var other = (Item) otherObject;
		return Objects.equals(description, other.description) && partNumber == other.partNumber;
	}

	public int hashCode() {
		return Objects.hash(description, partNumber);
	}

	public int compareTo(Item other) {
		int diff = Integer.compare(partNumber, other.partNumber);
		return diff != 0 ? diff : description.compareTo(other.description);
	}
}