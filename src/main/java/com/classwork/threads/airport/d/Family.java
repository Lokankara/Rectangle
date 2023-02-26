package com.classwork.threads.airport.d;

class Family implements Comparable<Family> {
	private final String name;
	private final String travelTo;
	private final int count;

	public Family(String name, String traveTo, int count) {
		this.count = count;
		this.name = name;
		this.travelTo = traveTo;
	}

	public String getName() {
		return name;
	}

	public String getTravelTo() {
		return travelTo;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int compareTo(Family f) {
		return this.count - f.count;
	}

	@Override
	public String toString() {
		return "Family " + name + " of " + count + " people going to " + travelTo;
	}
}
