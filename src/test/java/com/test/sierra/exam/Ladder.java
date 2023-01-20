package com.test.sierra.exam;

import java.util.Scanner;

public class Ladder {
	public static void main(String[] args) {
		args = new String[] { "x", "Ladder" };
		System.out.print("#52 ");

		try {
			System.out.println(doStuff(args));
		} catch (Exception e) {
			System.out.println("exc");
		}
//		doStuff(args);

		System.out.print("#53 ");
		String in = "1234,77777,689";
		Scanner sc = new Scanner(in);
		sc.useDelimiter(",");
		while (sc.hasNext())
			System.out.print(sc.nextInt() + " ");
		while (sc.hasNext())
			System.out.print(sc.nextShort() + " ");
	}

	static int doStuff(String[] args) {
		return Integer.parseInt(args[0]);
	}

}