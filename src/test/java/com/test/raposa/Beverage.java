package com.test.raposa;

public class Beverage {
	int ounces = 12;
	boolean carbonated = false;

	public void drink() {
		System.out.println("Beverage");
	}

	public static void main(String[] args) {
		System.out.println(new SodaPop());
		Beverage b = new Coffee();
		b.drink();
	}
}

class SodaPop extends Beverage {
	public String toString() {
		return ounces + " " + carbonated;
	}
}

class Coffee extends Beverage {
	public String toString() {
		return ounces + " " + carbonated;
	}

	public void drink() {
		System.out.println("Coffee");
	}
}