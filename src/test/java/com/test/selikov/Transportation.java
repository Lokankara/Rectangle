package com.test.selikov;

public class Transportation {
	public static String travel(int distance) {
		return distance < 1000 ? "train" : "10";
	}

	public static void main(String[] answer) {
		System.out.print(travel(500));
	}
}