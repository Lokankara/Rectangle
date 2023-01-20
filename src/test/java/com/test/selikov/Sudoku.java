package com.test.selikov;

public class Sudoku {
	static int[][] game;

	public static void main(String[] args) {
		game[3][3] = 6;
		Object[] obj = game;
		game[3][3] = 0;
		System.out.println(game[3][3]);
	}
}
