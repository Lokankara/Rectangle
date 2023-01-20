package com.test.sierra;

class Rocket {
	private void blastOff() {
		System.out.println("Bang");
	}
}

public class Shuttle extends Rocket {

	public static void main(String[] args) {
		new Shuttle().go();
	}

	void go() {
		blastOff();
//		Rocket.blastOff();
	}

	private void blastOff() {
		System.out.println("sh-Bang");
	};
}

interface XA extends YA{}


interface YA{}