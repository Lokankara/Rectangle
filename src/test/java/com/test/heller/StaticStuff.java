package com.test.heller;

class StaticStuff {
	static int x = 10;
	static {
		x += 5;
	}

	public static void main(String args[]) {
		System.out.print("ch.3, # 5 ");
		System.out.println("x = " + x);
	}

	static {
		x /= 5;
	}
}