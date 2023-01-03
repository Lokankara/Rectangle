/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public class Tiger extends Animal {
	private int age;
	private String name;

	private void roar() {
		System.out.println("The " + getAge() + " year old tiger says: Argthhh!");
	}

	@Override
	public  int getAge() {
		return age;
	}

	@Override
	public String getName() {
		return name;
	}
}