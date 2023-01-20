package com.test.heller;

import java.util.Scanner;

public class RegEx {

	public RegEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String scanMe = "aeiou9876543210AEIOU";
		Scanner scanner = new Scanner(scanMe);
		String delim = "\\d*";
		scanner.useDelimiter(delim);
		while (scanner.hasNext())
			System.out.print(scanner.next());
		Double d = 121221.121232d;
		System.out.format("%20.5f%n", d);
		System.out.format("%20.15f%n", d);
		System.out.format("%-20.5f%n", d);
		System.out.format("%-20.15f%n", d);
	}
}
