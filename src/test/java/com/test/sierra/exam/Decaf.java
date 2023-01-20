package com.test.sierra.exam;

import java.util.regex.*;

public class Decaf {
	public static void main(String[] args) {
		String[] patterns = new String[] { "0([0-7])?", "0([0-7])*", "0([0-7])+" };
		String arg = "1012 0208 430";
		for (String pattern : patterns) {
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(arg);

			while (m.find())
				System.out.printf(m.group() + " ");
			System.out.printf("%n");
		}
	}
}