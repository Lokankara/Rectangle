package com.homework.collector;

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
