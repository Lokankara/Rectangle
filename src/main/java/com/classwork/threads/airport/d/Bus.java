package com.classwork.threads.airport.d;

class Bus {
	private final int passengersCount;
	private final String driveTo;

	public Bus(Town destination) {
		this.driveTo = destination.name();
		this.passengersCount = destination.getPersonInQueueCount();
	}
	
	public String getDriveTo() {
		return driveTo;
	}

	public int getPassengersCount() {
		return passengersCount;
	}
}