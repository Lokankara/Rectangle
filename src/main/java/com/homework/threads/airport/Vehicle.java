package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

abstract class Vehicle implements Runnable {

	Thread thread;
	protected List<Family> families;

	public Vehicle(List<Family> families) {
		this.families = families;
	}
	public List<Family> getFamilies() {
		return families;
	}

	public boolean setFamilies(List<Family> families) {
		this.families = families;
		return true;
	}

	public int getMembers() {
		return families.stream().mapToInt(Family::getCount).sum();
	}
}

class Plane extends Vehicle {
	// Producer
	private int id;
	Thread thread;
	Gate gate;

	public Plane(int id, List<Family> families, Gate gate) {
		super(new ArrayList<>(families));
		this.id = id;
		this.thread = new Thread(this, "Plane");
		this.gate = gate;
	}

	@Override
	public void run() {
		gate.arrive(this);

	}

	@Override
	public String toString() {
		return String.format("Aircraft#%d with %s seats carries %s families", id, getMembers(), families.size());
	}
}

class Bus extends Vehicle implements Comparator<Bus> {
	// Consumer
	private int freeSeats;
	private String driveTo;
	BusStation station;

	public Bus(String city, List<Family> families, BusStation station) {
		super(new ArrayList<>(families));
		this.driveTo = city;
		freeSeats = ThreadLocalRandom.current().nextInt(6, 9);
		this.thread = new Thread(this, "Bus");
		this.station = station;
	}

	@Override
	public void run() {
		station.departure(this);
	}

	@Override
	public boolean setFamilies(List<Family> families) {
		if (freeSeats >= families.size()) {
			freeSeats -= families.size();
			super.setFamilies(families);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("Bus [passengersCount=%d, driveTo=%s, families=%s]", freeSeats, driveTo, families);
	}

	@Override
	public int compare(Bus a, Bus b) {
		return Integer.compare(a.freeSeats, b.freeSeats);
	}
}