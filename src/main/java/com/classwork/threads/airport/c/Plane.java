package com.classwork.threads.airport.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Plane implements Runnable {
	
	private int id;                              // 1, 2, or 3
	private ArrayList<Family> families;          // exactly 100 members

	Plane(int id, ArrayList<Family> families) {
		this.id = id;
		this.families = families;
	}

	Plane() {}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public ArrayList<Family> getFamilies() {
		return this.families;
	}

	public void freePassengers() {
		this.families.clear();
	}

	public void setFamilies(ArrayList<Family> families) {
		this.families = families;
	}

	public void setRandomFamilies(String lastUsedFamilyName) {
		if (lastUsedFamilyName.length() != 2) {
			System.out.println("Wrong family name set for plane with id " + this.id);
			return;
		}
		int allMembers = 0;
		int familyMembers = 0;
		char firstChar = lastUsedFamilyName.charAt(0);
		char secondChar = lastUsedFamilyName.charAt(1);
		String name = null;
		while (allMembers < 97) {
			if (secondChar != 'z') {
				secondChar += 1;
			} else {
				firstChar += 1;
				secondChar = 'a';
			}
			familyMembers = (int) (Math.random() * 4 + 1);
			name = Character.toString(firstChar) + Character.toString(secondChar);
			this.families.add(new Family(name, City.getRandom(), familyMembers));
			allMembers += familyMembers;
		}
		if (secondChar != 'z') {
			secondChar += 1;
		} else {
			firstChar += 1;
			secondChar = 'a';
		}
		name = Character.toString(firstChar) + Character.toString(secondChar);
		this.families.add(new Family(name, City.getRandom(), 100 - allMembers));
	}

	@Override
	public String toString() {
		return "Plane(ID) " + this.id + " : " + this.families;
	}

	@Override
	public void run() {
		System.out.println("Service of plane with ID " + this.id + " is started.");

		for (Family f : this.families) {
			Controller.boardAFamily.accept(f);
		}
		this.freePassengers();

		System.out.println("Service of plane with ID " + this.id + " is finished.");
	}
	
}

class Bus {
	
	private City driveTo;                        // Enum - Kalush Kosiv Galych Kolomiya
	private int passengersCapacity;              // from 6 to 8
	private int passengersCount;

	Bus(City driveTo, int passengersCapacity) {
		this.driveTo = driveTo;
		this.passengersCapacity = passengersCapacity;
	}

	Bus() {
	}

	public City getDriveTo() {
		return this.driveTo;
	}

	public void setDriveTo(City driveTo) {
		this.driveTo = driveTo;
	}

	public int getPassengersCapacity() {
		return this.passengersCapacity;
	}

	public int getPassengersCount() {
		return this.passengersCount;
	}

	public void addPassengers(int numberOfPassengers) {
		this.passengersCount += numberOfPassengers;
	}

	@Override
	public String toString() {
		return this.driveTo + " "
				+ ": " + this.passengersCount + " from " + this.passengersCapacity;
	}
	
}

class Family {
	
	private String name;                         // "aa", "ab", ... ,"zz"
	private City travelTo;                       // Enum - Kalush Kosiv Galych Kolomiya
	private int count;                           // from 1 to 4
	
	Family(String name, City travelTo, int count) {
		this.name = name;
		this.travelTo = travelTo;
		this.count = count;
	}
	
	Family() {}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getTravelTo() {
		return this.travelTo;
	}

	public void setTravelTo(City travelTo) {
		this.travelTo = travelTo;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.travelTo + " " + this.count;
	}
	
}

enum City {
	
	KALUSH, KOSIV, GALYCH, KOLOMIYA;

	private static final ArrayList<City> CITIES = new ArrayList<>(Arrays.asList(City.values()));
	private static final int SIZE = CITIES.size();
	private static final Random R = new Random();

	public static City getRandom() {
		return CITIES.get(R.nextInt(SIZE));
	}	
}
