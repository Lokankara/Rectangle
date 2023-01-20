package com.test.sierra;

public class SubSubAlpha extends Alpha {

	private SubSubAlpha() {
		s += " Subsub ";
	}

	public static void main(String[] args) {
		new SubSubAlpha();
		System.out.println(s);
	}

}

class Alpha {
	static String s = " ";

	protected Alpha() {
		s += " Alpha ";
	}
}

class SubAlpha extends Alpha {
	private SubAlpha() {
		s += " sub ";
	}
}