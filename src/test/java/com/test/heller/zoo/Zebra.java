package com.test.heller.zoo;

public class Zebra extends Animal {

	Zebra(float weight) {
		super(weight);
	}

	public Zebra() {
		super(200f);
	}

	@Override
	public String toString() {
		return "Zebra [weight=" + weight + "]";
	}

	public static void main(String[] args) {
		Animal a = new Animal(222.2f);
		Zebra z = new Zebra();
		System.out.println(String.format("#37, page 491%n %s%n%s", z, a));
		
	}
}