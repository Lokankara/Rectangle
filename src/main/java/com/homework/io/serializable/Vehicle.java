package com.homework.io.serializable;

import java.util.Objects;

class Vehicle implements Comparable<Vehicle> {
	public Vehicle() {}
	private int speed;
	private int year;
	private Engine engine;

	@Override
	public int compareTo(Vehicle v) {return Integer.compare(this.getYear(), v.getYear());}

	public Vehicle(int year, int speed, Engine engine) {
		super();
		this.speed = speed;
		this.year = year;
		this.engine = engine;
	}
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	public Engine getEngine() {return engine;}
	public void setEngine(Engine engine) {this.engine = engine;}
	@Override
	public String toString() {
		return String.format("Vehicle [speed=%d, year=%d, %s]", speed, year, engine);}
	@Override
	public int hashCode() {return Objects.hash(engine, speed, year);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(engine, other.engine) && speed == other.speed && year == other.year;}
}
