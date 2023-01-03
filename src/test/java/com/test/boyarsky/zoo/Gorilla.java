/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public class Gorilla extends Animal {
	public String getName() { // DOES NOT COMPILE
		return "Gorilla";
	}

	public Gorilla() {
		super();
	}

	@Override
	public int getAge() {
		return 100;
	}
}
