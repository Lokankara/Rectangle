package com.test.selikov;

public class Dancing {
	private static int dayOfWeek;

	public static void main(String[] vars) {
		int leaders = 10 * (2 + (1 + 2 / 5));
		int followers = leaders * 2;
		System.out.print(leaders + followers < 10);
		System.out.print(leaders + followers < 10 ? "Too few" : "Too many");
		int time = 11;
		int day = 4;
		String dinner = time > 10 ? day < 5 ? "Takeout" : "Salad" : "Leftovers";

		final byte saturday = 6;
		switch (dayOfWeek) {
		default:
			System.out.print("Another Weekday");
			break;
		case saturday:
			System.out.print("Weekend!");
		}
		int tiger = 2;
		short lion = 3;
		long winner = lion + 2 * (tiger + lion);
		System.out.print(winner);
	}
}