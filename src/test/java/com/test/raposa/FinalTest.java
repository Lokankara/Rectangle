package com.test.raposa;

public class FinalTest {

	public static void main(String[] args) {
		House h = new House();
		h.address = "123 Main Street";
		h = null;
		System.gc();
	}
}

class House {
	public String address;

	public void finalize() {
		System.out.println("Inside House");
		address = null;
	}
}