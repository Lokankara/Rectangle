package com.test.raposa;

import java.text.DecimalFormat;

public class AssertDemo {

	public AssertDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Integer x = 10;
		System.out.println(x);
		System.out.print("ch1 #10: ");
		assert x == null && x >= 0;

		System.out.print("ch1 #13: ");
		DecimalFormat df = new DecimalFormat("#,000.0#");
		double pi = 3.141592653;
		System.out.println(df.format(pi));
	}
}