/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
interface HasVocalCords {

	public abstract void makeSound();
}

public interface CanBark extends HasVocalCords {
	
	static boolean alert = false;

	void alert();
	
	static boolean isAlert() {
		return alert;
	};

	public void bark();
}
