/**
 * 
 */
package test.java.com.test.boyarsky.zoo.pets;

import test.java.com.test.boyarsky.zoo.CanBark;
import test.java.com.test.boyarsky.zoo.Mammal;

/**
 * @author PPoliak
 *
 */
public abstract class Dog extends Mammal implements CanBark {

	static int count;

	static int getCount() {
		return count;
	}

	public void bark() {
		System.out.print("woof ");
	}
}

class Hound extends Dog {
	public void sniff() {
		System.out.print("sniff ");
	}

	public void bark() {
		System.out.print("howl ");
	}

	@Override
	public void makeSound() {
		bark();
	}

	@Override
	public void alert() {
		if(alert) {
			makeSound();
		}
	}
}