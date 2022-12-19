/**
 * 
 */
package com.test.heller.zoo;

/**
 * @author PPoliak
 *
 */
class Animal {
	float weight;

	Animal(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Animal [weight=" + weight + "]";
	}

	public Animal() {
	}
}
