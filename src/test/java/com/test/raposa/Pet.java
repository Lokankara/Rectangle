package com.test.raposa;

public class Pet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	{
		System.out.print("A");
	}

	public Pet() {
		System.out.print("B");
	}

	{
		System.out.print("C");
	}

}

class Cat extends Pet {
	public Cat() {
		System.out.print("D");
	}

	static {
		System.out.print("E");
	}
}
