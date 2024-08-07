/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public interface Herbivore {
	int amount = 10;

	public void eatGrass();

	public static int chew() {
		return 13;
	}
}