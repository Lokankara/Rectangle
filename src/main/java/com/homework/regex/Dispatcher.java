package com.homework.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.*;

public class Dispatcher {

	private static int length = 5;
	private static String inputFilename = "matrix.txt";
	private final static String delimeter = " ";
	private final static String outputFilename = "matchers.txt";
	private final static String path = "C:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";

	public static void main(String[] args) {

		switch (args.length) {
		case 2:
			length = parse(args[1]);
		case 1:
			inputFilename = args[0];
		}

		File file = new File(String.format("%s%s", path, inputFilename));

		String patternString = String.format("\\b([aeoui])(.){%d}\\b", length - 1);
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

		Matcher matcher;

		try (Scanner scanner = new Scanner(file).useDelimiter(delimeter);
				PrintWriter writer = new PrintWriter(outputFilename, "UTF-8")) {

			while (scanner.hasNext()) {
				matcher = pattern.matcher(scanner.next());
				if (matcher.matches()) {
					writer.printf("%s%n", matcher.group());
				}
			}
			System.out.printf("Default length: %d%nSource file: %s%s%nFile %s has been written", 
					length, path, inputFilename, outputFilename);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static int parse(String arg) {
		try {
			return Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			System.out.printf("Can`t parse length: %s%n", e.getMessage());
			return length;
		}
	}
}
