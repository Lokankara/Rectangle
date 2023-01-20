package com.test.sierra.exam;

public class Boggy {
	final static int mine = 7;
	final static Integer i = 57;

	public static void main(String[] args) {
		int x = go(mine);
		System.out.print(mine + " " + x + " ");
		x += mine;
		Integer i2 = i;
		i2 = go(i);
		System.out.println(x + " " + i2);
		i2 = new Integer(60);
	}

	static int go(int x) {
		return ++x;
	}
}