package com.test.raposa;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegEx {

	public RegEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Pattern dot = Pattern.compile("x.y");
		String[] valuez = { "xy", "xay", "xaby", "xa" };
		for (String value : valuez) {
			if (dot.matcher(value).matches()) {
				System.out.println(value);
			}
		}
		String stuff = "of coursewyeswnowmaybe";
		String[] values = stuff.split("w");
		System.out.println(values.length);

		Pattern pattern = Pattern.compile("(\\d[a-z])+\\s\\w?");
		String[] valuex = { "9a4b x", "3a z", "a", "1a2b3c" };
		int counter = 0;
		for (String value : valuex) {
			if (pattern.matcher(value).matches()) {
				counter++;
			}
		}
		System.out.println(counter);
		String s = "Good morning sunshine the earth says hello";
		Scanner in = new Scanner(s);
		in.useDelimiter("\\s[s]");
		int c = 0;
		while (in.hasNext()) {
			in.next();
			c++;
		}
		System.out.println(c);
	}
}
