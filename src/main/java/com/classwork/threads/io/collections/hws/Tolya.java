package com.classwork.threads.io.collections.hws;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Tolya {

	public static void main(String[] args) {
		Map<String, Long> map = Collections.synchronizedMap(new HashMap<>());

		FileWrapper fw1 = new FileWrapper("f1");
		FileWrapper fw2 = new FileWrapper("f2");
		FileWrapper fw3 = new FileWrapper("f3");

		WordFinder wf1 = new WordFinder(fw1, map);
		WordFinder wf2 = new WordFinder(fw2, map);
		WordFinder wf3 = new WordFinder(fw3, map);
		wf1.start();
		wf2.start();
		wf3.start();

		try {
			wf1.join();
			wf2.join();
			wf3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}

}

class FileWrapper {
	String filePath;

	FileWrapper(String filePath) {
		this.filePath = filePath;
	}

	void find(Map<String, Long> map) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			Pattern pattern = Pattern.compile("[a-zA-Z]{2,}");
			String line;
			while ((line = reader.readLine()) != null) {
				for (String temp : line.split(" ")) {
					Matcher matcher = pattern.matcher(temp);
					if (matcher.find() && temp.endsWith("" + temp.charAt(0))) {
						map.compute(temp, (key, value) -> value == null ? 1 : ++value);
					}
				}
			}
		} catch (Exception e) {
		}
	}
}

class WordFinder extends Thread {
	FileWrapper file;
	Map<String, Long> map;

	WordFinder(FileWrapper file, Map<String, Long> map) {
		this.file = file;
		this.map = map;
	}

	public void run() {
		file.find(map);
	}
}
