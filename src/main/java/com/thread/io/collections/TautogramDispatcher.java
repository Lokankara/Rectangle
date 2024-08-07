package com.thread.io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;

public class TautogramDispatcher {

	public final static List<String> filenames = new ArrayList<>(Arrays.asList("matrix.txt", "robot.txt", "robby.txt"));
	public final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";
//	public final static Map<String, Long> tautograms = Collections.synchronizedMap(new LinkedHashMap<>());
	public final static Map<String, Long> tautograms = new ConcurrentHashMap<>();

	public static void main(String[] args) {

		List<Thread> threadPool = new ArrayList<>();


		Controller.instantiateThreads(filenames, threadPool);

		long start = System.nanoTime();
		Controller.launchThreads(threadPool);
		Controller.joinThreads(threadPool);
		long end = System.nanoTime();

		System.out.printf("Time: %s milliseconds%n", (end - start) / 1_000_000);

		Map<String,Long> sortedMap = Controller.sortMap(tautograms);
		Controller.print(sortedMap, 0);
	}
}
class Controller {

	public static void instantiateThreads(
			List<String> filenames, List<Thread> threadPool) {

		for (int i = 0; i < filenames.size(); i++) {
			threadPool.add(new FileThread(new Resource(
					String.format("%s%s", TautogramDispatcher.path, filenames.get(i)))));
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

		tautograms.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
		return sortedMap;
	}

	public static void print(Map<String, Long> sortedMap, int key) {
		sortedMap.entrySet()
			.stream().filter(entry -> entry.getValue() > key)
			.forEach(System.out::println);
		
	}
}

final class Resource {
	private final File file;
//	private final Map<String, Long> tautograms;

	public Resource(String filename) {
		this.file = new File(filename);
//		this.tautograms = new ConcurrentHashMap<>();
	}

	public File getFile() {
		return file;
	}

public void reduce(String next) {
		TautogramDispatcher.tautograms.compute(next, (key, value) -> value == null ? 1 : ++value);
	}
}
class FileThread extends Thread {

	private final Resource resource;

	public FileThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		String next = "";
		try (Scanner scanner = new Scanner(resource.getFile())) {
			while (scanner.hasNext()) {
				next = scanner.next()
						.replaceAll("[{}\\[\\]()`'/\\\"\\\\*«»“”„,;:?!….\\\\-\\\\‒\\\\—\\\\―|~%@&]", " ")
						.toLowerCase();

				if (next.length() > 1 
						&& next.charAt(0) == next.charAt(next.length() - 1) 
						&& next.charAt(0) > 96
						&& next.charAt(0) < 123) {
					resource.reduce(next);
				}
			}
		} catch (IOException e) {
			System.err.printf("%s%n", e);
		}
	}
}
