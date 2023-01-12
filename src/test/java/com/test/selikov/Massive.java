package com.test.selikov;

import java.util.Arrays;

public class Massive {

	private static int binarySearch;

	public static void main(String[] vars) {
		
		String[] days = new String[] { "Sunday", "Monday", "Tuesday",
				"Wednesday", "Thursday", "Friday", "Saturday" };
		
		printStormName("Arlene");
		printStormName(new String[] { "Bret" });
//		printStormNames(days);
		printStormNames(new String[] { "Don" });
		
		binarySearch = Arrays.binarySearch(days, "Monday");		
		System.out.println(binarySearch);
 
//		Arrays.linearSort(days, "Friday");
//		Arrays.search(days);
		Arrays.sort(days);
		System.out.println(Arrays.toString(days));

		String[] nums = new String[] { "1", "9", "10" };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		String[][] matrix = new String[2][2];
		matrix[0][0] = "Don't think you are, know you are."; // m1
		matrix[0][1] = "I'm trying to free your mind Neo"; // m2
		matrix[1][0] = "Is all around you "; // m3
		matrix[1][1] = "Why oh why didn't I take the BLUE pill?"; // m4
		
		String[] os = new String[] { "OS", "Mac", "Linux", "Windows" };
//		Arrays.sort(os);
		System.out.println(Arrays.binarySearch(os, "Mac"));
		char[][] ticTacToe = new char[3][3]; // r1
//		ticTacToe[1][3] = 'X'; // r2
		ticTacToe[2][2] = 'X';
//		ticTacToe[3][1] = 'X';
		System.out.println(ticTacToe.length + " in a row!"); // r3
		
		Integer[] lotto = new Integer[4];
		lotto[0] = new Integer(1_000_000);
		lotto[1] = new Integer(999_999);
		System.out.println(Arrays.toString(lotto));			
		
	}

	public static void printStormName(String... names) {
		System.out.println(Arrays.toString(names));
	}

	public static void printStormNames(String[] names) {
		System.out.println(Arrays.toString(names));
	}

}
