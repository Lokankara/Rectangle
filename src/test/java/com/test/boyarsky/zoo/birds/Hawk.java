/**
 * 
 */
package com.test.boyarsky.zoo.birds;

/**
 * @author PPoliak
 *
 */
public class Hawk extends Bird {
	public Hawk() {
		super();
		referenceCount++;
	}

	public void move() {
		System.out.println("Fly");
	}

	@Override
	public String toString() {
		return getClass() + "#" + hashCode();
	}
}
