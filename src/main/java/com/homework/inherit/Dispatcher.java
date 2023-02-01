package com.homework.inherit;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

interface Passenger {}
interface Cargo {}

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
public class Dispatcher {

	private static final PrintStream out = System.out;

	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		Fighter fantomFighter = new Fighter("Fantom");
		Fighter fantom = new Fighter("Fantom");
		out.println(fighter);
		out.println(fantomFighter);
		out.println(fighter);
		out.println(fighter.equals(fantom));
		out.println(fantom.equals(fantomFighter));
		out.println(fantomFighter.equals(fighter));

		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("BMW", "Serg", 12000, 2020));
		cars.add(new Car("Porsche", "Serg", 20000, 2022));
		cars.add(new Car("Kia", 3000, 2000));

		ArrayList<Car> ownerCars = new ArrayList<>();
		ArrayList<Car> isSergCars = new ArrayList<>();

		for (Car car : cars) {
			if (car.getOwner().contains("Serg")) {
				ownerCars.add(car);
			}
		}

		for (Car car : cars) {
			if (car.isSerg()) {
				isSergCars.add(car);
			}
		}

		out.printf("Sizes: %s%n", isSergCars.size() == ownerCars.size());
		for (int id = 0; id < isSergCars.size(); id++) {
			out.printf("Car#%d equals: %b%n", id + 1, isSergCars.get(id).equals(ownerCars.get(id)));
		}
		out.println(isSergCars);
	}
}

class Car extends Auto {

	private String model;
	private String owner = "";
	private int price;
	private int produceYear;

	public boolean isSerg() {
		return "Serg".equals(owner) ? true : false;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProduceYear() {
		return produceYear;
	}

	public void setProduceYear(int produceYear) {
		this.produceYear = produceYear;
	}

	public Car(String model, int price, int produceYear) {
		super();
		this.model = model;
		this.price = price;
		this.produceYear = produceYear;
	}

	public Car(String model, String owner, int price, int produceYear) {
		super();
		this.model = model;
		this.owner = owner;
		this.price = price;
		this.produceYear = produceYear;
	}

	@Override
	public String toString() {
		return String.format("Car {model:'%s', owner:'%s', price:%d, year:%d}", model, owner, price, produceYear);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(model, owner, price, produceYear);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model) && Objects.equals(owner, other.owner) && price == other.price
				&& produceYear == other.produceYear;
	}
}

/**
 * Main java class represents three interfaces CanFly, Wheel, CanSwim
 */
abstract class Vehicle  {
	protected String name;
	protected int price;
	protected boolean run;

	protected void run() {
		this.run = !run ? true : false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, run);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		return Objects.equals(name, other.name) && price == other.price && run == other.run;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(run);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fighter other = (Fighter) obj;
		return run == other.run;
	}

	@Override
	public String toString() {
		return String.format("Fighter {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(), run);
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
			this.run = true;
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
		this.name = name;
}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("AeroPlane {alert:%s, price:%d, name:'%s', run:%s}", isAlert(), price(), name(), isRun());
	}
}

class PassengerAeroPlane extends AeroPlane {
	private int passengers;

	public PassengerAeroPlane(String name) {
		super(name);
	}

	public PassengerAeroPlane() {
		super("PassengerAeroPlane");
	}

	public PassengerAeroPlane(int passengers) {
		super();
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(passengers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerAeroPlane other = (PassengerAeroPlane) obj;
		return passengers == other.passengers;
	}

	@Override
	public String toString() {
		return String.format("PassengerAeroPlane {alert:%s, price:%d, name:'%s',passengers:%d, run:%s}", isAlert(),
				price(), name(), passengers, isRun());
	}
}

class TransportAeroPlane extends AeroPlane {

	private int maxWeight;

	public TransportAeroPlane(String name) {
		super(name);
	}

	public TransportAeroPlane() {
		super("TransportAeroPlane");
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(maxWeight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportAeroPlane other = (TransportAeroPlane) obj;
		return maxWeight == other.maxWeight;
	}

	@Override
	public String toString() {
		return String.format("TransportAeroPlane {alert:%s, price:%d, name:'%s', weight:%d, run:%s}", isAlert(),
				price(), name(), maxWeight, isRun());
	}
}

/*
 * Implementations interface Wheel in subclass Auto <p> Java classes Car, Bus,
 * Truck extends Auto
 */
abstract class Auto extends Vehicle implements Wheel {

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

	protected Auto(String name) {
		super(name);
		this.wheels = 4;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	@Override
	public String toString() {
		return String.format("Auto {wheels:%d, name:'%s', owner:'%s', run:%s, price:%d}", wheels, name(), isRun(),
				price());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(wheels);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return wheels == other.wheels;
	}
}

class Bus extends Auto {

	public Bus(String name) {
		super(name);
	}

	public Bus() {
		super("Bus");
	}

	@Override
	public String toString() {
		return String.format("Bus {wheels:%d, price:%d, name:'%s', run:%s}", getWheels(), price(), name(), isRun());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}

class Truck extends Auto {

	private int wheels;

	public Truck(String name) {
		super(name);
	}

	public Truck() {
		super("Truck");
	}

	public Truck(int wheels) {
		super();
		this.wheels = wheels;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	@Override
	public String toString() {
		return String.format("Truck {wheels:%d, price:%d, name:'%s', run:%s}", getWheels(), price(), name(), isRun());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(wheels);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		return wheels == other.wheels;
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
		return String.format("Ship {name:'%s', run:%s}", name(), isRun());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
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
		return String.format("Boat {name:'%s', run:%s}", name(), isRun());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
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
		return String.format("Liner {name:'%s', run:%s}", name(), isRun());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
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
		return String.format("SailLiner {name:'%s', run:%s}", name(), isRun());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}

class PassengersSailLiner extends SailLiner {

	private int passengers;

	public PassengersSailLiner() {
		super("PassengersSailLiner");
	}

	public PassengersSailLiner(String name) {
		super(name);
	}

	public PassengersSailLiner(int passengers) {
		super();
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return String.format("PassengersSailLiner {price:%d, name:'%s', passengers:%d, run:%s}", price(), name(),
				passengers, isRun());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(passengers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengersSailLiner other = (PassengersSailLiner) obj;
		return passengers == other.passengers;
	}
}

class TugBoat extends Boat {
	private int maxWeight;

	public TugBoat() {
		super("TugBoat");
	}

	public TugBoat(String name) {
		super(name);
	}

	public TugBoat(String name, int maxWeight) {
		super(name);
		this.maxWeight = maxWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return String.format("TugBoat {price:%d, name:'%s', maxWeight, run:%s}", price(), name(), maxWeight, isRun());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(maxWeight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TugBoat other = (TugBoat) obj;
		return maxWeight == other.maxWeight;
	}
}

class Tanker extends Ship {

	private int weight;

	public Tanker() {
		super("Tanker");
	}

	public Tanker(String name) {
		super(name);
	}

	public Tanker(String name, int weight) {
		super(name);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("Tanker {price:%d, name:'%s', weight:%d, run:%s}", price(), name(), weight, isRun());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(weight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tanker other = (Tanker) obj;
		return weight == other.weight;
	}
}