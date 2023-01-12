package com.test.sierra.exam;

public class Jail {
	private int x = 4;

	public static void main(String[] args) {
		int x = 6;
		new Jail().new Cell().slam();
	}

	class Cell {
		void slam() {
			System.out.println("throw away key " + x);
			System.out.println("Multiple markers at this line\r\n"
					+ "	- Illegal modifier for parameter x; only final is permitted\r\n"
					+ "	- The value of the local variable x is not used");
		}
	}
}
