package com.test.sierra;

import java.text.*;

public class Slice {
	public static void main(String[] args) {
		String s = "9123456";
		double d = 9123456d;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(d) + " ");
		try {
			System.out.println(nf.parse(s));
		} catch (Exception e) {
			System.out.println("got exc");
		}
	}
}