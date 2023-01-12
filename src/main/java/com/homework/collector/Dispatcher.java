package com.homework.collector;

import java.util.Objects;

public class Dispatcher {

	public static void main(String[] args) {

		Car bmw = new Car("BMW");
		Car mazda = new Car("Mazda");
		Car toyota = new Car("Toyota");
		printCars(bmw, mazda, toyota);

		try {
			toyota.finalize();
			System.gc();
			printCars(bmw, mazda, toyota);

		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

		mazda = null;
		System.gc();
		printCars(bmw, mazda, toyota);

		bmw = null;
		toyota = null;
		System.gc();
		printCars(bmw, mazda, toyota);
	}

	private static void printCars(Car bmw, Car mazda, Car toyota) {
		System.out.println(Car.car);
		System.out.println(bmw);
		System.out.println(mazda);
		System.out.println(toyota);
	}
}

class Car {
	static Car car;

	private String model;

	@Override
	protected void finalize() throws Throwable {
		System.out.printf("Finalize %s%n", car);
		car = this;
	}

	public Car() {
	}

	@Override
	public String toString() {
		return String.format("Car model %s", model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model);
	}

	public Car(String model) {
		this.model = model;
		System.out.printf("Created new Car %s%n", model);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}