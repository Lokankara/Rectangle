package com.test.selikov;

public class ConditionallyLogical {
	public static void main(String... data) {
		if (data.length >= 1 
				&& (data[0].equals("sound") || data[0].equals("logic")) && data.length < 2) {
			System.out.println(data[0]);
		}
		System.out.println(12 + 6 * 3 % (1 + 1) );
	}
}
