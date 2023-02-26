package com.classwork.threads.airport.d;

import java.util.List;

class Plane {
	private final List<Family> families;

	public Plane(List<Family> families) {
		this.families = families;
	}

	public List<Family> getFamilyList() {
		return this.families;
	}
}