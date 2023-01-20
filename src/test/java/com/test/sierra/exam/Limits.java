package com.test.sierra.exam;

public class Limits {
	private int x = 2;
	protected int y = 3;
	private static int m1 = 4;
	protected static int m2 = 5;

	public static void main(String[] args) {

		String s = "-";
		boolean b = false;
		int x = 7, y = 8;
		if ((x < 8) ^ (b = true))
			s += "^";
		if (!(x > 8) | ++y > 5)
			s += "|";
		if (++y > 9 && b == true)
			s += "&&";
		if (y % 8 > 1 || y / (x - 7) > 1)
			s += "%";
		System.out.println(s);
		System.out.printf("%s%s%s%n", x, y, b);

		String sx = "4.5x4.a.3";
		String[] tokens = sx.split("\\s");
		for (String st : tokens)
			System.out.printf("%s ", st);
		tokens = sx.split("\\..");
		for (String st : tokens)
			System.out.printf("%s ", st);

		int x1 = 6;
		int y1 = 7;
		int m1 = 8;
		int m2 = 9;
		new Limits().new Secret().go();
	}

	class Secret {
		void go() {
			System.out.println();
			System.out.println(x + " " + y + " " + m1 + " " + m2);
		}
	}
}