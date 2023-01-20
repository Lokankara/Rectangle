package com.test.sanghera;

import java.util.Scanner;

public class MyScanner {

	public MyScanner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str = "a,b,cd,420";
		Scanner sc = new Scanner(str);
		while (sc.hasNext()) {
			System.out.print(sc.next());
		}
	}
}
