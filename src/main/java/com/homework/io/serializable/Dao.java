package com.homework.io.serializable;

import java.util.ArrayList;
import java.util.Arrays;

public class Dao {

	Engine bmw = new Engine(200, "BMW");
	Engine man = new Engine(250, "MAN");
	
	ArrayList<Boat> boats = new ArrayList<Boat>(Arrays.asList(
			new Boat(4, "metal"), new Boat(2, "wood"), new Boat(5, "plastic")));

	ArrayList<Wheel> wheels = new ArrayList<Wheel>(Arrays.asList(
			new Wheel(100, 6), new Wheel(100, 6), new Wheel(100, 6)));
	
	ArrayList<Chassis> chassis = new ArrayList<Chassis>(Arrays.asList(
			new Chassis(wheels.get(0), 4), new Chassis(wheels.get(1), 2), new Chassis(wheels.get(2), 1 )));
	
	ArrayList<Vehicle> ships = new ArrayList<Vehicle>(Arrays.asList(
			new Ship(2010, 150, man, 100, 20, boats.get(0)),
			new Ship(1999, 220, bmw, 10, 5, boats.get(1)),
			new Ship(2020, 170, man, 20, 7, boats.get(2))
			));
	
	ArrayList<Vehicle> airplanes = new ArrayList<Vehicle>(Arrays.asList(
			new Airplane(1996, 200, man, "Transport", 1500, chassis.get(0)),
			new Airplane(1991, 200, bmw, "Fighter", 2000, chassis.get(1)),
			new Airplane(1969, 200, bmw, "Zeppelin", 1000, chassis.get(2))
			));

	public ArrayList<Vehicle> ships() {
		return ships;
	}

	public ArrayList<Vehicle> airplanes() {
		return airplanes;
	}
}
