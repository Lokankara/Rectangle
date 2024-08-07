package com.test.boyarsky.zoo.birds;

public class Penguin extends Bird {

	public Penguin() {
		super();
		referenceCount++;
			}

	public void move() {
		System.out.println("Swim");
	}

	@Override
	public String toString() {
		return getClass() + "#" + hashCode();
	}
}