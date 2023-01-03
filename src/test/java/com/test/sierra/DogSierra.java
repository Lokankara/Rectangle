package com.test.sierra;

class DogSierra {
	void makeNoise() {
		System.out.print("bark ");
	}

	static void play() {
		System.out.print("Cannot use super in a static context ");
	}
}

class Bloodhound extends DogSierra {
	void makeNoise() {
		System.out.print("Cannot make a static reference to the non-static method makeNoise() from the type Bloodhound");
	}

	public static void main(String[] args) {
		new Bloodhound().go();
		play();
//		makeNoise();
	}

	void go() {
		play();
		makeNoise();
		makeNoise();
	}
}
