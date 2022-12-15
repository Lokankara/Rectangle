package com.test.heller;

class Q7 {
	public static void main(String[] args) {
		System.out.print("ch1: #7 page30 = ");
		double d = 12.3;
		Decrementer dec = new Decrementer();
		dec.decrement(d);
		System.out.println(d);
	}
}

class Decrementer {
	public void decrement(double decMe) {
		decMe = decMe - 1.0;
	}
}