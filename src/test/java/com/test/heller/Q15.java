package com.test.heller;

public class Q15 {
	static String s;

	public static void main(String[] args) {
		System.out.println("#15 =>>>" + s + "<<");

		int d = 0XABCD;
		int c = 0xabcd;
//		 int a = abcd;
//		 int b = ABCD;
//		 int e = 0abcd;
//		 int f = 0ABCD;
		System.out.println(String.format("#16 =>>>%d%n%d<<", c, d));

		double d1 = 1.2d;
		double d2 = 1.2D;
//	double d3 = 1.2d5;
//	double d4 = 1.2D5;

		char c1 = 0x1234;
//	char c3 = \u1234;
		char c3 = '\u1234';
		System.out.printf("#17-18 =>>>%s%n%s<<=>>>%s%n%s<<", c1, d1, c3, d2);

		StringBuffer sbuf = new StringBuffer();
		sbuf = null;
		System.gc();
	}
}