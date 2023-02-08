package com.classwork.threads.basic;

import java.util.List;

public class MarksCounterDispatcher {

	public final static String marks = "[`'\"\\*«»“”„,;:?!….\\-\\‒\\—\\―|~%@&]";
	public final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";

	public static void main(String[] args) {

		List<String> filenames = DirReader.searchFiles(".txt");

		long durationOneThread = Controller.readOneThread(filenames);
		long durationMultiThread = Controller.readMultiThreads(filenames);

		Controller.oneTreeSet.forEach(System.out::println);
		Controller.multiTreeSet.forEach(System.out::println);

		System.out.printf("Files reads %d millis in single thread%n", durationOneThread/1_000_000);
		System.out.printf("Files reads %d millis in multi threads%n", durationMultiThread/1_000_000);
		System.out.printf("Difference between times: %s millis%n", (durationOneThread - durationMultiThread)/1_000_000);
	}
}
