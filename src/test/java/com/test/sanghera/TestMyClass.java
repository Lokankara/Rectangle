package com.test.sanghera;

class MyClass {
	String hello = "Hello, Dear. Ch3, #1";

	void printMessage() {
		System.out.println(hello);
	}
}

class TestMyClass {
	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.printMessage();
	}
}