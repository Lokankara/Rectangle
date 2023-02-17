package com.classwork.threads.io.deadlock.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

	public static void checkfiles(String a, String b) {

		List<String> fileA = readFile(a);
		List<String> fileB = readFile(b);
		int count = 0;
		for (int i = 0; i < fileA.size(); i++) {
			if (!fileA.get(i).equalsIgnoreCase(fileB.get(i))) {
				System.out.printf("%s != %s %n", fileA.get(i), fileB.get(i));
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Files are equals in IgnoreCase mode");
		} else {
			System.err.println("Files are not equals");
		}
	}

	private static List<String> readFile(String filename) {
		List<String> file = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNext()) {
				file.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		return file;
	}
}
