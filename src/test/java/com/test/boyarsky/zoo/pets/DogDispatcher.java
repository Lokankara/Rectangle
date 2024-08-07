/**
 * 
 */
package com.test.boyarsky.zoo.pets;

import com.test.boyarsky.zoo.Dispatcher;

/**
 * @author PPoliak
 *
 */
public class DogDispatcher implements Dispatcher<Dog> {

	public DogDispatcher() {
	}

	public static void main(String[] args) {
		
		new DogDispatcher().go();
	}

	void go() {
		new Hound().bark();
		((Dog) new Hound()).bark();
		((Hound) new Hound()).sniff();
		Dog dog = new Hound();
		System.out.println("Dog zoo: "+ dog);
	}
}
