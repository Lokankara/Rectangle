package com.test.sanghera;

public class SubClass extends SuperClass {

	public static void main(String[] args) {
		SubClass sub = new SubClass(5);
		System.out.println("Constructor call must be the first statement in a constructor");

	}

	SubClass(int j) {
		super(j);
		System.out.println("The value of j is " + j);
	}

	public SubClass(int i, int j) {
		super(i, j);
	}

	public SubClass(int i, int j, int k) {
		super(i, i);
	}
}

class SuperClass {
	SuperClass() {
	}

	SuperClass(int i) {
		System.out.println("The value of i is " + i);
	}

	public SuperClass(int i, int j) {
		// TODO Auto-generated constructor stub
	}
}