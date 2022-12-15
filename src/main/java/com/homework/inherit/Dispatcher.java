package com.homework.inherit;

import java.util.ArrayList;
import java.util.List;

interface Wheels {
}

interface CanFly {
}

interface CanSwim {
}

class Dispatcher {
	public static void main(String[] args) {

		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		AirFactory aeroPlaneFactory = new AeroPlaneFactory();
		AirFactory fighterFactory = new FighterFactory();
		Air passengerAeroPlane = aeroPlaneFactory.build();
//		passengerAeroPlane.alert();
		Fighter fighter = (Fighter) fighterFactory.build();

		Air hawk = aeroPlaneFactory.build("Hawk", 10000);
		vehicles.add(hawk);
		vehicles.add(passengerAeroPlane);
		hawk.alert();
		Air fantom = fighterFactory.build("Fantom", 12000);

		vehicles.add(fantom);
		vehicles.add(fighter);

		for (Vehicle vehicle : vehicles) {
			System.out.println("Vehicles: " + vehicle);
		}
	}
}

abstract class Vehicle {
	private String name;
	private int price;
	private boolean run;

	protected void run() {
		this.run = !run ? true : false;
	};

	@Override
	public String toString() {
		return String.format("Vehicle [name=%s, run=%s, price=%d]", name, run, price);
	}

	public Vehicle(String name) {
		this.name(name);
	}

	public Vehicle() {
		this.name("Vehicle");
	}

	public Vehicle(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Vehicle(int price) {
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

abstract class Air extends Vehicle implements CanFly {

	private static boolean alert;

	public Air() {
		super();
	}

	public Air(String name) {
		super(name);
	}

	protected void alert() {
		alert = !isAlert() ? true : false;
	}

	public Air(String name, int price) {
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

	public boolean isRun() {
		return run;
	}

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
		return String.format("Fighter [alert=%s, price=%d, name=%s, run=%s]", isAlert(), price(), name(), isRun());
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
			super.alert(false);
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
		return String.format("AeroPlane [alert=%s, price=%d, name=%s, run=%s]", isAlert(), price(), name(), isRun());
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
		return String.format("PassengerAeroPlane [alert=%s, price=%d, name=%s, run=%s]", isAlert(), price(), name(),
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
		return String.format("TransportAeroPlane [alert=%s, price=%d, name=%s, run=%s]", isAlert(), price(), name(),
				isRun());
	}
}
