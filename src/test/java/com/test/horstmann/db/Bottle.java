package com.test.horstmann.db;

import java.text.DecimalFormat;

class Bottle {
	private int id;
	private String name;
	private double volume;
	private String material;

	public Bottle(int id, String name, double volume, String material) {
		this.id = id;
		this.name = name;
		this.volume = volume;
		this.material = material;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return String.format("%s milliliters %s %s bottle#%d", new DecimalFormat("#.####").format(volume * 1000),
				material, name, id);
	}
}
