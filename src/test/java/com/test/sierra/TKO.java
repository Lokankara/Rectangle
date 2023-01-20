package com.test.sierra;

class TKO {
	public static void main(String[] args) {
		String s = "-";
		Integer x = 343;
		long L343 = 343L;
		if (x.equals(L343))
			s += ".e1 ";
		if (x.equals(343))
			s += ".e2 ";
		Short s1 = (short) ((new Short((short) 343)) / (new Short((short) 49)));
		if (s1 == 7)
			s += "=s ";
		if (s1 < new Integer(7 + 1))
			s += "fly ";
		System.out.println(s);

		System.out.printf("sierra5, ch#6: 9)  ", 123);
		System.out.format("%b ", 123);
//		 System.out.format("%c", "x");
		  System.out.printf("%d ", 123);
//		  System.out.printf("%f", 123);
//		  System.out.printf("%d", 123.45);
		  System.out.printf("%.2f ", 123.45);
		 System.out.format("%s", new Long("123"));
	}
}