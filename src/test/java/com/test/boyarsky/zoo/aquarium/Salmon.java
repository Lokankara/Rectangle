/**
 * 
 */
package com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public class Salmon {
	int count;

	/**
	 * 
	 */
	public Salmon() { //void
		count = 4;
	}

	public static void main(String[] args) {
		Salmon s = new Salmon();
		System.out.println(s.count);
	}
}
