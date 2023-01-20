package com.test.sierra.exam;

import java.util.regex.*;

class Regex2 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		boolean b = false;
		while (b = m.find()) {
			System.out.print(m.start() + m.group());
		}
	}
}