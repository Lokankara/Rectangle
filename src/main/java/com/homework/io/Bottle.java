package com.homework.io;

class Bottle implements Comparable<Bottle> {

	protected static int referenceCount = 0;
	private Double volume;
	private String material;
	private String drink;
	private boolean full;
	// order 1: 0,5; 2: 0.51-0.99; 3: 1.0
	private int capacity;
	private int id;

	public Bottle() {
		setId(++referenceCount);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(double volume) {
		this.capacity = volume < 0.5 ? 1 : volume >= 0.5 && volume < 1 ? 2 : 3;
	}

	public Integer getId() {
		return id;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDrink() {
		return drink;
	}

	public void setLiquid(String liquid) {
		this.drink = liquid;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Bottle{");
		stringBuilder.append("id=");
		stringBuilder.append(id);
		stringBuilder.append(", volume=");
		stringBuilder.append(volume);
		stringBuilder.append(", material='");
		stringBuilder.append(material);
		stringBuilder.append('\'');
		stringBuilder.append(", liquid='");
		stringBuilder.append(drink);
		stringBuilder.append('\'');
		stringBuilder.append(", full=");
		stringBuilder.append(full);
		stringBuilder.append('}');
		return stringBuilder.toString();
	}

	public void setId(int parseInt) {
		this.id = parseInt;
	}

	@Override
	public int compareTo(Bottle a) {
		int result = this.getDrink().compareTo(a.getDrink()) != 0 
				? this.getDrink().compareTo(a.getDrink())
				: this.getMaterial().compareTo(a.getMaterial());
	
		return  result != 0 ? result : (int)(this.getVolume() - a.getVolume());
	}
}