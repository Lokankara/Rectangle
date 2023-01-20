package com.test.sierra;

public class IfaceTest implements MyInterface {

	public static void main(String[] args) {
		new IfaceTest().go();

	}

	void go() {
		System.out.println("class: " + doStuff());
//		System.out.println("iface: " + super.doStuff());
		System.out.println("iface: " + MyInterface.super.doStuff());
//		System.out.println("iface: " + MyInterface.doStuff());
//		System.out.println("iface: " + super.MyInterface.doStuff());

	}

}

interface MyInterface {
	default int doStuff() {
		return 42;
	}
}