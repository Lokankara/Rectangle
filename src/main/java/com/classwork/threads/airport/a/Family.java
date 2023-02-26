package com.classwork.threads.airport.a;

class Family {
	private final String name;
	private String travelTo;
	private final int members;
	private boolean isFamilyInBus = false;


	public Family(Integer count, String generateName, int plane, String generateCity) {
		this.name = generateName;
		this.travelTo = generateCity;
		this.members = count;	}


	public String getName() {
		return name;
	}

	public String getTravelTo() {
		return travelTo;
	}

	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}

	public int getMembers() {
		return members;
	}

	public boolean getIsFamilyInBus() {
		return isFamilyInBus;
	}

	public void setFamilyInBus(boolean familyInBus) {
		isFamilyInBus = familyInBus;
	}

	@Override
	public String toString() {
		return "Family = " + this.name + " TravelTo=" + this.travelTo + " Members=" + this.members + " ";
	}
}