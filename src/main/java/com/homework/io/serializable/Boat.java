package com.homework.io.serializable;

import java.util.Objects;

class Boat {

	private int place;
	private String material;

	public Boat(int place, String material) {
		super();
		this.place = place;
		this.material = material;
	}
	public Boat() {	}
	public int getPlace() {return place;}
	public void setPlace(int place) {this.place = place;}
	public String getMaterial() {return material;}
	public void setMaterial(String material) {this.material = material;}
	@Override
	public String toString() {return String.format("Boat [place=%d, material=%s]", place, material);}
	@Override
	public int hashCode() {return Objects.hash(material, place);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Boat other = (Boat) obj;
		return Objects.equals(material, other.material) && place == other.place;}
}