package com.homework.io.serializable;

import java.util.Objects;

class Wheel {
	private int load;
	private int diameter;
	public Wheel(){}
	public Wheel(int load, int diameter) {
		super();
		this.load = load;
		this.diameter = diameter;
	}
	public int getLoad() {return load;}
	public void setLoad(int load) {this.load = load;}
	public int getDiameter() {return diameter;}
	public void setDiameter(int diameter) {this.diameter = diameter;}
	@Override
	public String toString() {return String.format("Wheel [load=%d, diameter=%d]", load, diameter);}
	@Override
	public int hashCode() {return Objects.hash(diameter, load);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Wheel other = (Wheel) obj;
		return diameter == other.diameter && load == other.load;}
}