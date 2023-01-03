/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public abstract class BigCat extends Animal {

	public BigCat(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return "BigCat";
	}
	public abstract void roar();
}