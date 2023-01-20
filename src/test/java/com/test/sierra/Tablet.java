package com.test.sierra;

public class Tablet extends Electronic implements Gadget{

	public static void main(String[] args) {
		new Tablet().doStuff();
		new Tablet().getPower();
	}

	@Override
	public void doStuff() {
		// TODO Auto-generated method stub
		
	}

}


abstract class Electronic {
	void getPower() {
		System.out.println("plug in");
	}
}