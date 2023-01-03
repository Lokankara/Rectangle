package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
public abstract interface CanFly {

	void fly();

	void fly(int speed);

	abstract void takeoff();

	public abstract double dive();

}

interface HasWings {
	public abstract Object getWindSpan();
}

abstract class Falcon implements CanFly, HasWings {

}