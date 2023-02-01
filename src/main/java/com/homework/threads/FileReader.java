package com.homework.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class FileReader {

	private final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";

	public FileReader() {
	}

	static void readFile(String inputFilename) {

		File file = new File(String.format("%s%s", path, inputFilename));
//		var wordz = new TreeSet<String>();

		long totalTime = 0;
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNext()) {
//				String word = scanner.next();
				long callTime = System.currentTimeMillis();
//				wordz.add(word);
				callTime = System.currentTimeMillis() - callTime;
				totalTime += callTime;

//						Iterator<String> iter = words.iterator();
//						iter.forEachRemaining(e -> System.out.printf("%s%n",e));
//						for (int i = 1; i <= 20 && iter.hasNext(); i++)
//							System.out.printf("%s ", iter.next());
			}
//			wordz.forEach(e -> System.out.printf("%s%n", e));
//						
//			System.out.printf("%n%d distinct words. %d milliseconds.", wordz.size(), totalTime);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
