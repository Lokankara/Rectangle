/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public abstract class Animal {
	public int length = 2;
	private int age;
	protected String name;

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}


	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Animal(int age) {
		super();
		this.age = age;
		this.name = "Animal";
	}

	public Animal() {
	}

	public abstract int getAge();

	public abstract String getName();

	public void eat() {
		System.out.println("Animal is eating");
	}
}
