package com.test.sierra.exam;

class Horses {
	static String s = "";

	void beBrisk() {
		s += "trot ";
	}
}

public class Andy extends Horses {
	void beBrisk() {
		s += "tolt ";
	}

	public static void main(String[] args) {
		Horses x0 = new Horses();
		Horses x1 = new Andy();
		x1.beBrisk();
		Andy x2 = (Andy) x1;
		x2.beBrisk();
		Andy x3 = (Andy) x0;
		x3.beBrisk();
		System.out.println(s);
	}
}