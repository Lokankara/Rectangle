package com.test.sierra.exam;

import java.util.regex.*;

class Quetico {
	public static void main(String[] args) {

		String[] r = { "\\b", "\\B", "\\S", "\\W" };

		for (int i = 0; i < r.length; i++) {

			Pattern p = Pattern.compile(r[i]);

			Matcher m = p.matcher(args[0]);

			System.out.print("match positions: ");
			while (m.find()) {
//				System.out.printf("%s ", m.group());
				System.out.print(m.start() + " ");
			}
			System.out.println("");
		}
	}
}