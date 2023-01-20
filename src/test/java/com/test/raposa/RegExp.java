
package com.test.raposa;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	public static void main(String[] args) {

		Pattern pattern = Pattern.compile(".+es");
		String[] words = { "unless", "guesses", "boxes", "guest" };
		for (String word : words) {
			if (pattern.matcher(word).matches()) {
				System.out.println(word);
			}
		}

		pattern = Pattern.compile("[qrstuv]*.ing");
		String[] test = { "ing", "ring", "bingo", "trying", "running", "being" };
		for (String word : test) {
			if (pattern.matcher(word).matches()) {
				System.out.println(word);
			}
		}

		Pattern p = Pattern.compile("[0-4]+[a-z]*[5-9]?");
		String[] values = { "4a", "112abc6", "2345", "01a", "a5", "4a56", "4a" };
		for (String value : values) {
			Matcher m = p.matcher(value);
			if (m.matches()) {
				System.out.println(value + " matches [0-4]+[a-z]*[5-9]?");
			}
		}

		String s = "[A-Z]\\w*\\s+[A-Z]\\w+";
		Pattern x = Pattern.compile(s);
		String[] names = { "John Doe", "JohnDoe", "John\tDoe", "John doe", "J D", "J D5" };
		for (String name : names) {
			Matcher m = x.matcher(name);
			if (m.matches()) {
				System.out.println(name + " matches " + s);
			}
		}

		String data = "3035551212,123 Main St.\tDenver,CO:50431";
		String[] results = data.split("[;,:\\t]");
		for (String result : results) {
			System.out.println(result);
		}

		String abc = "abc,def,g,hi,jklm,o";
		String[] array = abc.split(",", 3);
		for (String a : array) {
			System.out.println(a);
		}

		String source = "abc de fgh 123 ijk";
		Scanner scan = new Scanner(source);
		while (scan.hasNext()) {
			if (scan.hasNextInt()) {
				int sc = scan.nextInt();
				System.out.println("int = " + sc);
			} else {
				String token = scan.next();
				System.out.println(token);
			}
		}
		String status = "probable,questionable;doubtful:out";
		Scanner in = new Scanner(status).useDelimiter("[,;:]");
		while (in.hasNext()) {
			String token = in.next();
			System.out.println(token);
		}
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a String, int and double: ");
		String first = console.next();
		int middle = console.nextInt();
		double last = console.nextDouble();
		System.out.println("first = " + first);
		System.out.println("middle = " + middle);
		System.out.println("last = " + last);
	}
}