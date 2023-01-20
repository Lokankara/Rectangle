package com.test.sierra.exam;

abstract interface Pixie {
	abstract void sprinkle();

	static int dust = 3;
}

abstract class TinkerBell implements Pixie {
	String fly() {
		return "flying ";
	}
}

public class ForReal extends TinkerBell {
	public static void main(String[] args) {
		new ForReal().sprinkle();
	}

	public void sprinkle() { System.out.println(fly() + " " + dust); }
}