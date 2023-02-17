package com.classwork.threads.io.collections.hws;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bodya {

	public static void main(String[] args) throws InterruptedException {

		WordCounter wordCounter1 = new WordCounter(new File("f1"), Collections.synchronizedMap(new HashMap<>()));
		WordCounter wordCounter2 = new WordCounter(new File("f2"), wordCounter1.words());
		WordCounter wordCounter3 = new WordCounter(new File("f3"), wordCounter2.words());

		Thread t1 = new Thread(wordCounter1);
		Thread t2 = new Thread(wordCounter2);
		Thread t3 = new Thread(wordCounter3);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println(wordCounter1.words());
	}
}

class WordCounter implements Runnable {

	File file;
	Map<String, Long> words;

	public Map<String, Long> words() {
		return words;
	}
	
	public WordCounter(File file, Map<String, Long> words) {
		this.file = file;
		this.words = Collections.synchronizedMap(words);
	}

	@Override
	public void run() {
		String word;
		int wordLength;

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				word = scanner.next();
				wordLength = word.length();

				if (wordLength > 1 && Character.toLowerCase(word.charAt(0)) == Character
						.toLowerCase(word.charAt(wordLength - 1))) {
					words.compute(word, (key, value) -> value == null ? 1 : ++value);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
