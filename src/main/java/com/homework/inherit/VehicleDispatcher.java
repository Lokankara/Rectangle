package com.homework.inherit;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

interface Wheel {
}

interface CanFly {
}

interface CanSwim {
}

/**
 * @author PPoliak
 *
 */
class VehicleDispatcher {
	private static final PrintStream out = System.out;

	public static void main(String[] args) {

		List<Vehicle> vehicles = new ArrayList<>();
		AirFactory aeroPlaneFactory = new AeroPlaneFactory();
		AirFactory fighterFactory = new FighterFactory();

		Air passengerAeroPlane = aeroPlaneFactory.build();
		passengerAeroPlane.alert();
		Fighter fighter = (Fighter) fighterFactory.build();
		Air hawk = aeroPlaneFactory.build("Hawk", 10000);
		vehicles.add(hawk);
		vehicles.add(passengerAeroPlane);
		hawk.alert();
		Air fantom = fighterFactory.build("Fantom", 12000);

		vehicles.add(fantom);
		vehicles.add(fighter);

		for (Vehicle vehicle : vehicles) {
			out.printf("Vehicles: %s", vehicle);
		}
	}
}

/**
 * Main java class represents three interfaces CanFly, Wheel, CanSwim
 */
abstract class Vehicle {
	private String name;
	private int price;
	private boolean run;

	protected void run() {
		this.run = !run ? true : false;
	}

	@Override
	public String toString() {
		return String.format("Vehicle {name:'%s', run:%s, price:%d}", name, run, price);
	}

	protected Vehicle(String name) {
		this.name(name);
	}

	protected Vehicle() {
		this.name("Vehicle");
	}

	protected Vehicle(String name, int price) {
		this.name = name;
		this.price = price;
	}

	protected Vehicle(int price) {
		this.name = "Vehicle";
		this.price = price;
	}

	public int price() {
		return price;
	}

	public void price(int price) {
		this.price = price;
	}

	public String name() {
		return name;
	}

	public void name(String name) {
		this.name = name;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
}

/**
 * Implementations interface Can Fly
 * <p>
 * Classes TransportAeroPlane and PassengerAeroPlane extends AeroPlane, can
 * calls the Class Fighter with protected alert method
 */
abstract class Air extends Vehicle implements CanFly {

	private static boolean alert;

	protected Air() {
		super();
	}

	protected Air(String name) {
		super(name);
	}

	protected void alert() {
		alert = !isAlert() ? true : false;
	}

	protected Air(String name, int price) {
		super(name, price);
	}

	public boolean isAlert() {
		return alert;
	}

	public static void alert(boolean call) {
		alert = call;
	}
}

class Fighter extends Air {

	private boolean run;

	@Override
	public boolean isRun() {
		return run;
	}

	@Override
	public void setRun(boolean run) {
		this.run = run;
	}

	public Fighter(String name) {
		super(name);
	}

	public Fighter(String name, int price) {
		super(name, price);
	}

	public Fighter(int price) {
		super("Fighter", price);
	}

	public Fighter() {
		super("Fighter");
	}

	@Override
	public String toString() {
		return String.format("Fighter {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(), isRun());
	}

	@Override
	public boolean isAlert() {
		if (super.isAlert()) {
			run();
		}
		return super.isAlert();
	}

	@Override
	protected void run() {
		if (!isRun()) {
			setRun(true);
			run();
			Air.alert(false);
		}
	}
}

class AeroPlane extends Air {
	public AeroPlane() {
		super("AeroPlane");
	}

	public AeroPlane(String name) {
		super(name);
	}

	public AeroPlane(String name, int price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return String.format("AeroPlane {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(), isRun());
	}
}

class PassengerAeroPlane extends AeroPlane {
	public PassengerAeroPlane(String name) {
		super(name);
	}

	public PassengerAeroPlane() {
		super("PassengerAeroPlane");
	}

	@Override
	public String toString() {
		return String.format("PassengerAeroPlane {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(),
				isRun());
	}
}

class TransportAeroPlane extends AeroPlane {
	public TransportAeroPlane(String name) {
		super(name);
	}

	public TransportAeroPlane() {
		super("TransportAeroPlane");
	}

	@Override
	public String toString() {
		return String.format("TransportAeroPlane {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(),
				isRun());
	}
}

/*
 * Implementations interface Wheel in subclass Auto <p> Java classes Car, Bus,
 * Truck extends Auto
 */
abstract class Auto extends Vehicle implements Wheel {

	protected String owner;
	private int wheels;

	protected Auto() {
		super("Auto");
		this.wheels = 4;
	}

	protected Auto(int wheels) {
		super("Auto");

		this.wheels = wheels;
	}

	protected Auto(int wheels, String name) {
		super(name);
		this.wheels = wheels;
	}

	protected Auto(int wheels, String name, int price) {
		super(name, price);
		this.wheels = wheels;
	}

	protected Auto(int wheels, String name, int price, String owner) {
		super(name, price);
		this.owner = owner;
		this.wheels = wheels;
	}

	protected Auto(String name, int price, String owner) {
		super(name, price);
		this.wheels = 4;
		this.owner = owner;
	}

	protected Auto(String owner, int price) {
		super(price);
		this.wheels = 4;
		this.owner = owner;
	}

	protected Auto(String name) {
		super(name);
		this.wheels = 4;
	}

	public Auto(int price, int wheels2) {
		// TODO Auto-generated constructor stub
	}

	public String owner() {
		return owner;
	}

	public void owner(String owner) {
		this.owner = owner;
	}

	public int wheels() {
		return wheels;
	}

	public void wheels(int wheels) {
		this.wheels = wheels;
	}

	@Override
	public String toString() {
		return String.format("Auto {wheels:%d, name:'%s', isRun:%s, price:%d}", wheels(), name(), isRun(), price());
	}
}

class Car extends Auto {

	public Car() {
		super("Car");
	}

	public Car(int wheels) {
		super(wheels);
	}

	public Car(int wheels, int price) {
		super(price, wheels);
	}

	public Car(int wheels, String name, int price) {
		super(wheels, name, price);
	}

	public Car(int wheels, String name, int price, String owner) {
		super(wheels, name, price, owner);
	}

	public Car(String name, int price, String owner) {
		super(name, price, owner);
	}

	public Car(String name, int price) {
		super(name, price);
	}

	public Car(int price, String owner) {
		super(price, owner);
	}

	public Car(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("Car {wheels:%d, price:%d, name:'%s', isRun:%s}", wheels(), price(), name(), isRun());
	}
}

class Bus extends Auto {

	public Bus(int wheels) {
		super(wheels);
	}

	public Bus(int wheels, String name) {
		super(name, wheels);
	}

	public Bus(int wheels, String name, int price) {
		super(wheels, name, price);
	}

	public Bus(String name, int price) {
		super(price, name);
	}

	public Bus(String name) {
		super(name);
	}

	public Bus() {
		super("Bus");
	}

	@Override
	public String toString() {
		return String.format("Bus {wheels:%d, price:%d, name:'%s', isRun:%s}", wheels(), price(), name(), isRun());
	}
}

class Truck extends Auto {

	public Truck(int wheels) {
		super(wheels);
	}

	public Truck(int wheels, String name) {
		super(name, wheels);
	}

	public Truck(int wheels, String name, int price) {
		super(name, price);
	}

	public Truck(String name) {
		super(name);
	}

	public Truck() {
		super("Truck");
	}

	public Truck(String name, int price, String owner) {
		super(name, price);
		this.owner = owner;
	}

	@Override
	public String toString() {
		return String.format("Truck  {owner:%s, wheels:%d, price:%d, name:'%s', isRun:%s}", owner(), wheels(), price(),
				name(), isRun());
	}
}

/**
 * Implementations interface Can Swim
 * <p>
 * Abstract classes Ship, Boat, and Liner extends Vehicle, classes - TugBoat
 * extends Boat, - Tanker extends Ship - PassengersSailLiner extends SailLiner -
 * TransportLiner, Ship and PassengerAeroPlane extends AeroPlane
 */
abstract class Ship extends Vehicle {

	Ship(String name) {
		super(name);
	}

	Ship() {
		super("Ship");
	}

	@Override
	public String toString() {
		return String.format("Ship {name:'%s', isRun:%s}", name(), isRun());
	}
}

abstract class Boat extends Vehicle {

	Boat(String name) {
		super(name);
	}

	Boat() {
		super("Boat");
	}

	@Override
	public String toString() {
		return String.format("Boat {name:'%s', isRun:%s}", name(), isRun());
	}
}

abstract class Liner extends Vehicle {

	Liner() {
		super("Liner");
	}

	Liner(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("Liner {name:'%s', isRun:%s}", name(), isRun());
	}
}

abstract class SailLiner extends Liner implements CanSwim {
	SailLiner() {
		super("SailLiner");
	}

	SailLiner(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("SailLiner {name:'%s', isRun:%s}", name(), isRun());
	}
}

class PassengersSailLiner extends SailLiner {
	public PassengersSailLiner() {
		super("PassengersSailLiner");
	}

	public PassengersSailLiner(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("PassengersSailLiner {price:%d, name:'%s', isRun:%s}", price(), name(), isRun());
	}

}

class TugBoat extends Boat {

	public TugBoat() {
		super("TugBoat");
	}

	public TugBoat(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("TugBoat {price:%d, name:'%s', isRun:%s}", price(), name(), isRun());
	}
}

class Tanker extends Ship {
	public Tanker() {
		super("Tanker");
	}

	public Tanker(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("Tanker {price:%d, name:'%s', isRun:%s}", price(), name(), isRun());
	}
}

//Vehicle Factory
interface Factory<T> {
	T build();
}

interface AirFactory extends Factory<Air> {
	Air build();

	Air build(String name);

	Air build(String name, int price);
}

class AeroPlaneFactory implements AirFactory {

	public AeroPlaneFactory() {
		super();
	}

	@Override
	public AeroPlane build() {
		return new AeroPlane("AeroPlane");
	}

	@Override
	public AeroPlane build(String name) {
		return new AeroPlane(name);
	}

	@Override
	public AeroPlane build(String name, int price) {
		return new AeroPlane(name, price);
	}
}

class FighterFactory implements AirFactory {

	public FighterFactory() {
		super();
	}

	@Override
	public Fighter build() {
		return new Fighter("Fighter");
	}

	@Override
	public Fighter build(String name) {
		return new Fighter(name);
	}

	@Override
	public Fighter build(String name, int price) {
		return new Fighter(name, price);
	}
}

interface AutoFactory extends Factory<Auto> {
	public Auto build();

	public Auto build(String name);

	public Auto build(String name, int price);

	public Auto build(String name, int price, int wheels);
}

class CarFactory implements AutoFactory {

	@Override
	public Car build() {
		return new Car();
	}

	@Override
	public Car build(String name) {
		return new Car(name);
		}

	@Override
	public Car build(String name, int price) {
		return new Car(name, price);
		}

	@Override
	public Auto build(String name, int price, int wheels) {
		return new Car(wheels, name, price);
	}
}
