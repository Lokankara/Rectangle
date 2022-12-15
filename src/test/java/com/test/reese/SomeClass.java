package com.test.reese;

public class SomeClass {
	public SomeClass(int i, float f) {
	}

	public SomeClass(float f, int i) {
	}

	public SomeClass(float f) {
	}

	public void SomeClass() {
	}

	public SomeClass() {
	}

	public int i;

	public static void main(String argv[]) {
		SomeClass sc = new SomeClass();
		sc.i = 5;
		int j = sc.i;
//	 sc.i = 5.0;
		System.out.println(sc.i);
		System.out.println(argv[1]);
	}
}