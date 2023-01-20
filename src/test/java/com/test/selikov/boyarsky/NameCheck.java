package com.test.selikov.boyarsky;

public class NameCheck {
	public static void main(String... data) {
		String john = "john";
		String jon = new String(john);
		System.out.print((john == jon) + " " + (john.equals(jon)));

		int meal = 5;
		int tip = 2;
		int total = meal + (meal > 6 ? ++tip : --tip);

		System.out.println(total);
	}
}