/**
 * 
 */
package com.test.boyarsky.zoo.aquarium.jellies;

/**
 * @author PPoliak
 *
 */
public class JellyFish extends Jelly {
	public int length = 5;

	public static void main(String[] args) {
		JellyFish jellyfish = new JellyFish();
		com.test.boyarsky.zoo.Animal animal = new JellyFish();
		System.out.println(jellyfish.length);
		System.out.println(animal.length);
	}
}