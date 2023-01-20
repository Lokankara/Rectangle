package com.homework.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SetTest {

	private static String inputFilename = "matrix.txt";
	private final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";

	public static void main(String[] args) {

		File file = new File(String.format("%s%s", path, inputFilename));
		var wordz = new TreeSet<String>();
		var words = new HashSet<String>();
		long totalTime = 0;
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNext()) {
				String word = scanner.next();
				long callTime = System.currentTimeMillis();
				words.add(word);
				wordz.add(word);
				callTime = System.currentTimeMillis() - callTime;
				totalTime += callTime;

//				Iterator<String> iter = words.iterator();
//				iter.forEachRemaining(e -> System.out.printf("%s%n",e));
//				for (int i = 1; i <= 20 && iter.hasNext(); i++)
//					System.out.printf("%s ", iter.next());
			}
			wordz.forEach(e -> System.out.printf("%s%n", e));
//				
			System.out.printf("%n%d distinct words. %d milliseconds.", words.size(), totalTime);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}