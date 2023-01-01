//package com.homework.inherit;
//
//import java.util.ArrayList;
//import java.util.List;
//
//interface Wheels{}
//interface CanFly{}
//interface CanSwim{}
//interface Factory<T> {T create();}
//interface AutoFactory extends Factory<Auto> {public Auto create();}
//
///**
// * Abstract class Vehicle with Getters and Setters, 
// * Constructors, @Override toString() and fields: 
// * <li>String name;
// * <li>double distance;
// * <li>double fuel;
// * <li>boolean run;
// * 
// * <ul> Interfaces:
// * <li> Wheels, <li> CanFly, <li> CanSwim, <li> Factory
//
// * <ul> Abstract classes:
// * <li> Auto implements Wheels, 
// * <li> Air implements CanFly, 
// * <li> Ship implements CanSwim, 
// * <li> Liner extends abstract class Vehicle 
// * <li> SailLiner extends abstract class Liner
// * <li> AeroPlane extends abstract class Air
//
// * <ul> Default classes: 
// * <li> Car, Bus, Truck extends abstract class Auto 
// * <li> TugBoat, Tanker extends abstract class Ship 
// * <li> PassengersSailLiner extends abstract class Liner
// * <li> Fighter extends abstract class AeroPlane
// * <li> TransportAeroPlane and PassengersAeroPlane extends abstract class AeroPlane
// * */
//class Inheritance {
//	public static void main(String[] args) {
//
//		List<Vehicle> vehicles = new ArrayList<Vehicle>(); 
//		AutoFactory carFactory = new CarFactory();
//		AutoFactory truckFactory = new TruckFactory();
//		Vehicle vehicle = carFactory.create();
//		Vehicle truck = truckFactory.create();
//		Car car = (Car) carFactory.create();
//
//		vehicles.add(car);
//		vehicles.add(truck);
//		vehicles.add(vehicle);
//		vehicle.run();
//		vehicles.add(vehicle);
//
//		System.out.println(vehicles);			
//	}
//}
//
//abstract class Vehicle implements Wheels, CanFly, CanSwim {
//
//	protected String name;
//	protected double distance;
//	protected double fuel;
//	protected boolean run;
//
//	public Vehicle(String name) {
//		this.name = name;
//	}
//	public Vehicle() {
//		this.name = "Vehicle";
//	}
//	void run() {
//		run = !run ? true : false;
//	};
//	@Override
//	public String toString() {
//			return String.format(
//				"Vehicle %s: fuel=%f, distance=%f work=%b", 
//				name, fuel, distance, run);
//	}
//	public double fuel() {
//		return fuel;
//	}
//	public void fuel(double fuel) {
//		this.fuel = fuel;
//	}
//	public double distance() {
//		return distance;
//	}
//	public void distance(double distance) {
//		this.distance = distance;
//	}
//}
//
//abstract class Auto extends Vehicle implements Wheels {
//
//	protected int wheels;
//
//	public Auto(String name) {
//		super(name);
//	}
//	public Auto() {
//		super("Auto");
//		this.wheels = 4;
//	}
//	public int wheels() {
//		return wheels;
//	}
//	public void wheels(int wheels) {
//		this.wheels = wheels;
//	}
//}
//
//abstract class Air extends Vehicle implements CanFly {
//
//	public Air(String name) {
//		super(name);
//	}
//	String info() {
//		return name;
//	};
//}
//
//abstract class Ship extends Vehicle implements CanSwim{
//	
//	public Ship(String name) {
//		super(name);
//	}
//	String info() {
//		return name;
//	};
//}
//
//abstract class Liner extends Vehicle {
//
//	public Liner(String name) {
//		super(name);
//	}
//}
//
//abstract class SailLiner extends Liner implements CanSwim {
//
//	public String info() {
//		return name;
//	}
//	public SailLiner(String name) {
//		super(name);
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Sail Liner [name=%s, fuel=%f, distance=%f, run=%s]", 
//				name, fuel, distance, run);
//	}
//}
//
//abstract class AeroPlane extends Air implements CanFly {
//	
//	public AeroPlane(String name) {
//		super(name);
//	}
//}
//
//
//class Fighter extends AeroPlane {
//	public Fighter(String name) {
//		super(name);
//	}
//}
//
//class PassengerAeroPlane extends AeroPlane {
//	public PassengerAeroPlane(String name) {
//		super(name);
//	}
//}
//
//class TransportAeroPlane extends AeroPlane {
//	public TransportAeroPlane(String name) {
//		super(name);
//	}
//}
//
//class PassengersSailLiner extends SailLiner {
//	public PassengersSailLiner(String name) {
//		super(name);
//	}
//	public String info() {
//		return name;
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Passengers Sail Liner [name=%s, fuel=%f, distance=%f, run=%s]", 
//				name, fuel, distance, run);
//	}
//}
//
//class TugBoat extends Ship {
//
//	public String info() {
//		return name;
//	}
//	public TugBoat(String name) {
//		super(name);
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Tugboat [name=%s, fuel=%f, distance=%f, run=%s]", 
//				 name, fuel, distance, run);
//	}
//}
//
//class Tanker extends Ship {
//
//	public double fuel() {
//		return super.fuel;
//	}
//	public double distance() {
//		return super.distance;
//	}
//	public String info() {
//		return name;
//	}
//	public Tanker(String name) {
//		super(name);
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Tanker [name=%s, fuel=%f, distance=%f, run=%s]", 
//				 name, fuel, distance, run);
//	}
//}
//
//class Car extends Auto {
//
//	public String info() {
//		return name;
//	}
//	public Car(String name) {
//		super(name);
//	}
//	public Car() {
//		super("Car");
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Car [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
//				name, wheels, fuel, distance,run);
//	}
//}
//
//class Bus extends Auto {
//
//	public String info() {
//		return name;
//	}
//	public Bus(String name) {
//		super(name);
//	}
//	public Bus() {
//		super("Bus");
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Bus [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
//				wheels, name, fuel, distance, run);
//	}
//}
//
//class Truck extends Auto {
//
//	public double fuel() {
//		return super.fuel;
//	}
//	public String info() {
//		return name;
//	}
//	public Truck(String name) {
//		super(name);
//	}
//	public Truck() {
//		super("Truck");
//	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Truck [name=%s, wheels=%d, fuel=%f, distance=%f, run=%s]", 
//				name, wheels, fuel, distance, run);
//	}
//}
//
//class CarFactory implements AutoFactory {
//	public Car create() {
//		return new Car();
//	}
//}
//
//class TruckFactory implements AutoFactory {
//	public Truck create() {
//		return new Truck();
//	}
//}
