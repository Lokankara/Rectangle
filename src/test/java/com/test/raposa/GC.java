package com.test.raposa;

import java.util.Date;

public class GC {
	public static void main(String[] args) {
		System.out.println("GC");
		Date one = new Date();
		Date two = new Date();
		Date three = one;
		one = null;
		Date four = one;
		three = null;
		two = null;
		two = new Date();
	}
}