package com.test.selikov;

public class OutsideLogic {
	public static void main(String... weather) {
//		System.out.print(weather[0] != null && weather[0].equals("sunny") && !false ? "Go Outside" : "Stay Inside");

		int characters = 5;
		int story = 3;
		double movieRating = characters <= 4 ? 3 : story>1 ? 2 : 1;
		
		System.out.println(movieRating);
	}
}