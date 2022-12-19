package com.test.boyarsky.zoo.aquarium;

public interface Aquatic extends CanSwim {
	public default int getNumberOfGills(int input) {
		return 2;
	}
}
