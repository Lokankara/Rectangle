/**
 * 
 */
package com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public interface SharkFamily extends HasFins {
	public default int getNumberOfFins() {
		return 8;
	}

	public double getLongestFinLength();

	public default boolean doFinsHaveScales() { // DOES NOT COMPILE
		return false;
	}
}