package com.classwork.hws;

public class Wheel {
	public static void main(String[] args) {
		Carz Max = new Carz();
		Max.brand = "Mercedes";
		Max.carWheels = "Summer wheels";
		Max.wheelChange("Winter wheels");
		System.out.println(Max.carWheels);
		Carz Jack = new Carz();
		Jack.brand = "BMW";
		Jack.carWheels = "Winter wheels";
		ServiceStation.wheelChange(Jack, "Summer wheels");
		System.out.println(Jack.carWheels);
	}
}

class Carz { // Model
	String brand, carWheels;

	void wheelChange(String winterWheels) {
		System.out.println("Lift the car using jack");
		carWheels = winterWheels;
	}
}

class ServiceStation { // Controller
	static void wheelChange(Carz c, String summerWheels) {
		System.out.println("Lift the car using hoist");
		c.carWheels = summerWheels;
	}
}
