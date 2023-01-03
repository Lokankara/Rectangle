package com.test.schildt;

public class SimpleInheritance {

	public static void main(String[] args) {
			
		A superOb = new A();
		B subOb = new B();
		superOb.i = 10;
		superOb.j = 20;
//		superOb.showij();

		subOb.i = 7;
		subOb.j = 8;
		subOb.k = 9;
//		subOb.showij();
//		subOb.showk();
//		subOb.sum();
		subOb.setij(10, 20);

	}
}

class A {
	int i, j;
	
	void setij(int x, int y) {
	i = x;
	j = y;
    }
	
	void showij() {
		System.out.printf("Parent: i: %s, j: %s%n", i, j);
	}
}

class B extends A {
	int total;
	int k;
	void showk() {
		System.out.printf("Child: i: %s, j: %s, k: %s%n", i, j, k);
	}

	public int sum() {
		int sum = k + j + i;
		this.total = sum;
		System.out.printf("Sum: i: %s, j: %s, k: %s => %s%n", i, j, k, total);
		return sum;
	}
}
