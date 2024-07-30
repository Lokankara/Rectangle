package test.java.com.test.boyarsky.zoo.birds;

import test.java.com.test.heller.zoo.birds.Bird;

public class Parrot extends Bird {
	public void fly() {
	}

	public static int getRefCount() {
		return referenceCount;
	}

	Parrot() {
		referenceCount++;
	}

	@Override
	public String toString() {
		return getClass() + "#" + hashCode();
	}

}
