/**
 * 
 */
package com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */

public class Shark extends Fish {
	private int numberOfFins = 8;

	public Shark(int age) {
		super(age);
		this.size = 4;
	}

	public void displaySharkDetails() {
		System.out.print("Shark with age: " + getAge());
		System.out.print(" and " + size + " meters long");
		System.out.print(" with " + numberOfFins + " fins");
	}
}