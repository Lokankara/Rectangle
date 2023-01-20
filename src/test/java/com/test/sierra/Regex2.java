package com.test.sierra;

import java.util.regex.*;

class Regex2 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
//		boolean b = false;
		while (m.find()) {
			System.out.print("position: " + m.start());
			System.out.println(", group: " + m.group());
		}
	}
}
