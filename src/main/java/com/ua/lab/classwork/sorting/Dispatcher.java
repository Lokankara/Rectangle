package com.ua.lab.classwork.sorting;

import java.util.Arrays;

public class Dispatcher {

	public Dispatcher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Car[] cars = {
				new Car("Ford", "white", 5000, 240),
				new Car("Audi", "blue", 4000, 220),
				new Car("BMW", "red", 7000, 250),
				new Car("Opel", "green", 3000, 180),
		};
		System.out.println(Arrays.toString(cars));
		Arrays.sort(cars);
		System.out.println(Arrays.toString(cars));
	}
}

class Car implements Comparable{
	String model, color;
	int price, speed;
	public Car(String model, String color, int price, int speed) {
		super();
		this.model = model;
		this.color = color;
		this.price = price;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return String.format("Car [model=%s, color=%s, price=%d, speed=%d]", model, color, price, speed);
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
//		return this.price - ((Car) o).price;
		return this.model.compareTo(((Car) o).model);
	}
}