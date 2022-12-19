package com.test.heller.food;

/**
 * @author PPoliak
 *
 */
public class Foods {

	public Foods() {
		// TODO Auto-generated constructor stub
	}

	public Fruit feedMe() {
		return new Fruit();
	}

	public static void main(String[] args) {
		Grapefruit g = new Grapefruit();
		Citrus c = (Citrus) g;
		Lemon lem = (Lemon) c;
//		(Citrus) is an assignment from a subclass to a superclass, so the cast is not necessary.
//		(Lemon) compiles because it obeys the compile-time casting rules. 
//		At runtime, the JVM notices that the class of the object referenced by c is not compatible with the Lemon class, so an exception is thrown.
	}
}
