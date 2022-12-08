package com.homework.inherit;

/**
 * Abstract class Vehicle with Getters and Setters, Constructors, @Override toString() and fields: 
 * <li>String name;
 * <li>double distance;
 * <li>double fuel;
 * <li>boolean run;
 * <p>
 * Abstract classes Auto, Fly, Ship, Liner extends Abstract class Vehicle 
 * <p>
 * Abstract class SailLiner extends abstract class Liner
 * <p>
 * Abstract class AeroPlane extends abstract class Fly
 * <p>
 * Classes Car, Bus, Truck extends abstract class Auto 
 * <p>
 * Classes TugBoat, Tanker extends abstract class Ship 
 * <p>
 * Class PassengersSailLiner extends abstract class Liner
 * <p>
 * Class Fighter extends abstract class Fly
 * <p>
 * Classes TransportAeroPlane and PassengersAeroPlane extends abstract class AeroPlane
 * */
class Inheritance {
	public static void main(String[] args) {

		VehicleFactory carFactory = new CarFactory();
		Vehicle vehicle = carFactory.create();
		vehicle.run();
		System.out.println(vehicle);
	}
}

interface Factory<T> {
	T create();
}

abstract interface VehicleFactory extends Factory<Vehicle> {
}

class CarFactory implements VehicleFactory {
	public Car create() {
		return new Car();
	}
}

class TruckFactory implements Factory<Truck> {
	public Truck create() {
		return new Truck();
	}
}

abstract class Fly extends Vehicle {
	public Fly(String name) {
		super(name);
	}

	String info() {
		return name;
	};
}

class PassengerAeroPlane extends AeroPlane {
	
	public PassengerAeroPlane(String name) {
		super(name);
	}
}

class TransportAeroPlane extends AeroPlane {
	
	public TransportAeroPlane(String name) {
		super(name);
	}
}

abstract class AeroPlane extends Fly {
	
	public AeroPlane(String name) {
		super(name);
	}
}
class Fighter extends Fly {
	
	public Fighter(String name) {
		super(name);
	}
}

abstract class Ship extends Vehicle {
	public Ship(String name) {
		super(name);
	}

	String info() {
		return name;
	};
}

abstract class Liner extends Vehicle {

	public Liner(String name) {
		super(name);
	}
}

abstract class SailLiner extends Liner {

	public String info() {
		return name;
	}

	public SailLiner(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format(
				"Sail Liner [name=%s, fuel=%f, distance=%f, run=%s]", 
				name, fuel, distance, run);
	}
}

class PassengersSailLiner extends SailLiner {

	public PassengersSailLiner(String name) {
		super(name);
	}
	public String info() {
		return name;
	}
	@Override
	public String toString() {
		return String.format(
				"Passengers Sail Liner [name=%s, fuel=%f, distance=%f, run=%s]", 
				name, fuel, distance, run);
	}
}

class TugBoat extends Ship {

	public String info() {
		return name;
	}

	public TugBoat(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format(
				"Tugboat [name=%s, fuel=%f, distance=%f, run=%s]", 
				 name, fuel, distance, run);
	}
}

class Tanker extends Ship {

	public double fuel() {
		return super.fuel;
	}
	public double distance() {
		return super.distance;
	}
	public String info() {
		return name;
	}

	public Tanker(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format(
				"Tanker [name=%s, fuel=%f, distance=%f, run=%s]", 
				 name, fuel, distance, run);
	}
}

abstract class Auto extends Vehicle {
	protected int wheels;

	public Auto(String name) {
		super(name);
	}
	
	public Auto() {
		super("Auto");
		this.wheels = 4;
	}

	public int wheels() {
		return wheels;
	}

	public void wheels(int wheels) {
		this.wheels = wheels;
	}
}

class Car extends Auto {

	public String info() {
		return name;
	}

	public Car(String name) {
		super(name);
	}
	
	public Car() {
		super("Car");
	}

	@Override
	public String toString() {
		return String.format(
				"Car [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
				name, wheels, fuel, distance,run);
	}
}

class Bus extends Auto {

	public String info() {
		return name;
	}

	public Bus(String name) {
		super(name);
	}

	public Bus() {
		super("Bus");
		}

	@Override
	public String toString() {
		return String.format(
				"Bus [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
				wheels, name, fuel, distance, run);
	}
}

class Truck extends Auto {

	public double fuel() {
		return super.fuel;
	}

	public String info() {
		return name;
	}

	public Truck(String name) {
		super(name);
	}

	public Truck() {
		super("Truck");
}

	@Override
	public String toString() {
		return String.format(
				"Truck [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
				wheels, name, fuel, distance, run);
	}
}

abstract class Vehicle {

	protected String name;
	protected double distance;
	protected double fuel;
	protected boolean run;

	public Vehicle(String name) {
		this.name = name;
	}
	
	public Vehicle() {
		this.name = "Vehicle";
	}

	void run() {
		run = !run ? true : false;
	};

	@Override
	public String toString() {
			return String.format(
				"Vehicle %s: fuel=%f, distance=%f work=%b", 
				name, fuel, distance, run);
	}

	public double fuel() {
		return fuel;
	}

	public void fuel(double fuel) {
		this.fuel = fuel;
	}

	public double distance() {
		return distance;
	}

	public void distance(double distance) {
		this.distance = distance;
	}
}
