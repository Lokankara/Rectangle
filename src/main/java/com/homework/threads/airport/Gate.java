package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Gate {

	private BusStation station;
	private Queue<Family> passengersList;
	private List<Family> arrivedPassengers;
	private static Gate gate;

	public static Gate getGate() {
		return gate == null ? gate = new Gate() : gate;
	}

	private Gate() {
		this.station = BusStation.getStation();
		this.arrivedPassengers = new ArrayList<>();
		this.passengersList = new ConcurrentLinkedQueue<>();
	}

	void arrive(Plane plane) {
		View.display(String.format("%s arrived to the gate#%s%n", plane, Thread.currentThread().getId()));
		arrivedPassengers.addAll(plane.families);
		security(plane.families);
		plane.families.clear();
	}

	synchronized private void security(List<Family> passengers) {
		passengersList.addAll(passengers);
		if (passengersList.size() == arrivedPassengers.size()) {
			View.display(String.format("Security control, prepare your documents%n"));
			station.boarding(arrivedPassengers);
			passengersList.clear();
		}
	}
}
