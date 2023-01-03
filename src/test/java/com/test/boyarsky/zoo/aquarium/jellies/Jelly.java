/**
 * 
 */
package com.test.boyarsky.zoo.aquarium.jellies;

/**
 * @author PPoliak
 *
 */
public class Jelly extends com.test.boyarsky.zoo.Animal {

	int length = 3;
	protected int age;

	public Jelly() {
	}

	@Override
	public String getName() {
		return "Jelly";
	}

	@Override
	public int getAge() {
		return age;
	}
}
