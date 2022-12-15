package com.test.sanghera;

abstract class Shape {
	abstract void draw(); // Note that there are no curly braces here.

	void message() {
		System.out.println("I cannot live without being a parent.");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Circle drawn.");
	}
}

class Cone extends Shape {
	void draw() {
		System.out.println("Cone drawn.");
	}
}

public class RunShape {
	public static void main(String[] args) {
 Circle circle = new Circle();
 Cone cone = new Cone();
 circle.draw();
 cone.draw();
 cone.message();
 }
}