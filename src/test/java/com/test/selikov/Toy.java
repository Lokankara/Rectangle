package com.test.selikov;

public class Toy {
	public void play() {
		System.out.print("play-");
	}
	
	public void finalize() {
		System.out.print("clean-");
	}

	public static void main(String[] args) throws InterruptedException {
		Toy car = new Toy();
		car.play();
		System.gc();
		Toy doll = new Toy();
		doll.play();
		car = null;
//		Thread.sleep(100);
		System.gc();
		doll = null;
		System.gc();

	}
}
