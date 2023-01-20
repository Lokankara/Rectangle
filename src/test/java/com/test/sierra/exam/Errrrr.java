package com.test.sierra.exam;

public class Errrrr {
	static String a = null;
	static String s = "";

	public static void main(String[] args) {
		args = new String[] { "x" };
		try {
			a = args[0];
			System.out.print(a);
			s += "t1 ";
		} catch (RuntimeException re) {
			s += "c1 ";
		} finally {
			s += "f1 ";
		}
		System.out.println(" " + s);
	}
}
