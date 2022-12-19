package com.test.sanghera;

class A {
	A(){}
	A(String message) {
		System.out.println(message + " from A.");
	}
}

class B extends A {
	B() {
		System.out.println("Hello from B.");
	}
}

public class RunSubClass implements Test {
	public static void main(String[] args) {
		B b = new B();
	}
}

interface Test {
	String chap = "Hello, Dear. Ch3, #1";
}