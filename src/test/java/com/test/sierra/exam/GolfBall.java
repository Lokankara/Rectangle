package com.test.sierra.exam;

class Ball {
	static String s = "";

	void doStuff() {
		s += "bounce ";
	}
}

class Basketball extends Ball {
	void doStuff() {
		s += "swish ";
	}
}

public class GolfBall extends Ball {
	public static void main(String[] args) {
		Ball b = new GolfBall();
		Basketball bb = (Basketball) b;
		b.doStuff();
		bb.doStuff();
		System.out.println(s);
	}

	void doStuff() {
		s += "fore ";
	}
}