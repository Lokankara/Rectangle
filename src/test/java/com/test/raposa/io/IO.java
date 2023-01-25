package com.test.raposa.io;

import java.io.PrintWriter;

public class IO {

	private static char[] readPassword;

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		 pw.format("%2$d is bigger than %2$d%n", 10, 5);
		 double d = 2.73258;
		 int x = 3;
		 pw.format("%4.2f%s %d%n", d, " is almost", x);
		 pw.close();

		 java.io.Console out = System.console();
		 readPassword = out.readPassword("%s", "Enter a password: ");
		 System.out.println("You entered " + readPassword);
	}
}
