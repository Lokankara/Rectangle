package com.test.sierra;

public class TestEnums {
	static Animals a;

	public static void main(String[] args) {
		String s = a.DOG.sound + " " + a.FISH.sound;
		System.out.println(s);
	}

}

enum Animals {
	DOG("woof"), CAT("meow"), FISH("burble");

	String sound;

	Animals(String string) {
		sound = string;
	}
}