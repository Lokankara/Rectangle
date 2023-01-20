package com.test.sierra.exam;
public class Sunny extends Weather {
	public static void main(String[] args) {
		try {
			new Sunny().do1();
//			new Sunny().do2();
			new Sunny().do3();
		} catch (Throwable t) {
			System.out.print("exc ");
		}
	}
}

class Weather {
	void do1() {
		System.out.print("do1 ");
	}

	private void do2() {
		System.out.print("do2 ");
	}

	protected void do3() {
		System.out.print("do3 ");
	}
}