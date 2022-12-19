///**
// * 
// */
//package com.homework.inherit;
//
///**
// * @author PPoliak
// *
// */
//
//public class Wheel{}
//
//abstract class Auto extends Vehicle implements Wheels {
//	protected String owner;
//	private int wheels;
//
//	public Auto() {
//		super("Auto");
//		this.wheels = 4;
//	}
//
//	public Auto(int wheels) {
//		super("Auto");
//		this.wheels = wheels;
//	}
//
//	public Auto(int wheels, String name) {
//		super(name);
//		this.wheels = wheels;
//	}
//
//	public Auto(int wheels, String name, int price) {
//		super(name, price);
//		this.wheels = wheels;
//	}
//
//	public Auto(int wheels, String name, int price, String owner) {
//		super(name, price);
//		this.owner = owner;
//		this.wheels = wheels;
//	}
//
//	public Auto(String name, int price, String owner) {
//		super(name, price);
//		this.wheels = 4;
//		this.owner = owner;
//	}
//
//	public Auto(String owner, int price) {
//		super(price);
//		this.wheels = 4;
//		this.owner = owner;
//	}
//
//	public Auto(String name) {
//		super(name);
//		this.wheels = 4;
//	}
//
//	public String owner() {
//		return owner;
//	}
//
//	public void owner(String owner) {
//		this.owner = owner;
//	}
//
//	public int wheels() {
//		return wheels;
//	}
//
//	public void wheels(int wheels) {
//		this.wheels = wheels;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Auto [wheels=%d, name=%s, isRun=%s, price=%d]", wheels(), name(), isRun(), price());
//	}
//}
//
//class Car extends Auto {
//
//	public Car() {
//		super("Car");
//	}
//
//	public Car(int wheels) {
//		super(wheels);
//	}
//
//	public Car(String name, int price) {
//		super(price, name);
//	}
//
//	public Car(int wheels, String name, int price) {
//		super(wheels, name, price);
//	}
//
//	public Car(int wheels, String name, int price, String owner) {
//		super(wheels, name, price, owner);
//	}
//
//	public Car(int wheels, String name) {
//		super(name, wheels);
//	}
//
//	public Car(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Car [wheels=%d, price=%d, name=%s, isRun=%s]", wheels(), price(), name(), isRun());
//	}
//}
//
//class Bus extends Auto {
//	// price vs wheels
//	public Bus(int wheels) {
//		super(wheels);
//	}
//
//	public Bus(String name, int price) {
//		super(price, name);
//	}
//
//	public Bus(int wheels, String name, int price) {
//		super(wheels, name, price);
//	}
//
//	public Bus(int wheels, String name) {
//		super(name, wheels);
//	}
//
//	public Bus(String name) {
//		super(name);
//	}
//
//	public Bus() {
//		super("Bus");
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Bus [wheels=%d, price=%d, name=%s, isRun=%s]", wheels(), price(), name(), isRun());
//	}
//}
//
//class Truck extends Auto {
//
//	public Truck(int wheels) {
//		super(wheels);
//	}
//
//	public Truck(int wheels, String name) {
//		super(name, wheels);
//	}
//
//	public Truck(int wheels, String name, int price) {
//		super(name, price);
//	}
//
//	public Truck(String name) {
//		super(name);
//	}
//
//	public Truck() {
//		super("Truck");
//	}
//
//	public Truck(String name, int price, String owner) {
//		super(name, price);
//		this.owner = owner;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Truck  [owner=%s, wheels=%d, price=%d, name=%s, isRun=%s]", owner(), wheels(), price(),
//				name(), isRun());
//	}
//}
