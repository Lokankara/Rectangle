package com.test.sierra.exam;

public class LogSplitter {
	public static void main(String[] args) {
		args = new String[] { "x1 23 y #", "\\d", "\\s", "\\w" };
		for (int x = 1; x < args.length; x++)
			System.out.print(args[0].split(args[x]).length + " ");
	}
}