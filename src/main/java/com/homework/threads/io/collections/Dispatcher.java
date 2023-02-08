package com.homework.threads.io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dispatcher {

	public final static List<String> filenames = new ArrayList<>(Arrays.asList("matrix.txt", "robot.txt", "robby.txt"));
	public final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";
	public final static Map<String, Long> tautograms = Collections.synchronizedMap(new LinkedHashMap<>());

	public static void main(String[] args) {

		List<Thread> threadPool = new ArrayList<>();


		Controller.instantiateThreads(filenames, threadPool);

		long start = System.nanoTime();
		Controller.launchThreads(threadPool);
		Controller.joinThreads(threadPool);
		long end = System.nanoTime();

		System.out.printf("Time: %s milliseconds%n", (end - start) / 1_000_000);

		Controller.sortMap(tautograms).entrySet().stream().filter(entry -> entry.getValue() > 2)
				.forEach(System.out::println);
	}
}
