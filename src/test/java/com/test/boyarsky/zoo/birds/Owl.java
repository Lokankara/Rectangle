/**
 * 
 */
package com.test.boyarsky.zoo.birds;

/**
 * @author PPoliak
 *
 */
public class Owl implements Nocturnal {

	/**
	 * 
	 */
	public Owl() {
		// TODO Auto-generated constructor stub
	}

	public boolean isBlind() {
		return false;
	}

	public static void main(String[] args) {
		Nocturnal nocturnal = (Nocturnal) new Owl();
		System.out.println(nocturnal.isBlind());
	}
}

interface Nocturnal {
	default boolean isBlind() {
		return true;
	}
}
