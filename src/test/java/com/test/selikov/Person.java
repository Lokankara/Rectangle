package com.test.selikov;

public class Person {

	public Person youngestChild;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Nil");
	}

	public static void main(String... args) {
		Person elena = new Person();
		Person diana = new Person();
		elena.youngestChild = diana;
		diana = null;
		Person zoe = new Person();
		elena.youngestChild = zoe;
		zoe = null;
		System.gc();
	}
}
