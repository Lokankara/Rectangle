package com.homework.threads.io.collections;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {

	public static void instantiateThreads(List<String> filenames, List<Thread> threadPool) {

		for (int i = 0; i < filenames.size(); i++) {
			threadPool.add(new FileThread(new Resource(String.format("%s%s", Dispatcher.path, filenames.get(i)))));
		}
	}

	public static void joinThreads(List<Thread> threadPool) {

		for (int i = 0; i < threadPool.size(); i++) {
			try {
				threadPool.get(i).join();
			} catch (InterruptedException e) {
				threadPool.get(i).interrupt();
				System.err.println(e);
			}
		}
	}

	public static void launchThreads(List<Thread> threadPool) {

		for (int i = 0; i < threadPool.size(); i++) {
			threadPool.get(i).start();
		}
	}

	public static Map<String, Long> sortMap(Map<String, Long> tautograms) {
		Map<String, Long> sortedMap = new LinkedHashMap<>();

		tautograms.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

		return sortedMap;
	}
}
