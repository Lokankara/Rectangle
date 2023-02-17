package com.classwork.threads.io.collections.hws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Handler {
//	public final static Map<String, Long> tautograms = Collections.synchronizedMap(new HashMap<>());
//	public final static ConcurrentHashMap<String, Long> tautograms = new ConcurrentHashMap<>();
	public final static Map<String, Long> tautograms = Collections.synchronizedMap(new LinkedHashMap<>());

	public static void main(String[] args) throws InterruptedException {

		List<String> txtFiles = new ArrayList<>(Arrays.asList("robby.txt", "matrix.txt", "robot.txt", "robby.txt",
				"neo.txt", "robot.txt", "rob.txt", "bob.txt", "robot.txt", "robby.txt", "neo.txt", "robot.txt",
				"rob.txt", "bob.txt", "robot.txt"));
		List<String> mdFiles = new ArrayList<>(Arrays.asList("robby.txt", "matrix.txt", "robot.txt", "robby.txt",
				"neo.txt", "robot.txt", "rob.txt", "bob.txt", "robot.txt", "robby.txt", "neo.txt", "robot.txt",
				"rob.txt", "bob.txt", "robot.txt"));
		List<String> csvFiles = new ArrayList<>(Arrays.asList("robby.txt", "matrix.txt", "robot.txt", "robby.txt",
				"neo.txt", "robot.txt", "rob.txt", "bob.txt", "robot.txt", "robby.txt", "neo.txt", "robot.txt",
				"rob.txt", "bob.txt", "robot.txt"));

		List<Thread> pool = new ArrayList<>();
		pool.add(new MapThread(txtFiles));
		pool.add(new MapThread(csvFiles));
		pool.add(new MapThread(mdFiles));

		for (Thread thread : pool) {
			thread.start();
		}
		for (Thread thread : pool) {
			thread.join();
		}
		Map<String, Long> sortedMap = new LinkedHashMap<>();

		tautograms.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

		System.out.println(sortedMap);
	}
}

class MapThread extends Thread implements Runnable {
	private final List<String> filenames;

	public MapThread(List<String> filenames) {
		super();
		this.filenames = filenames;
	}

	@Override
	public void run() {
		for (String file : filenames) {
			Handler.tautograms.compute(file, (key, value) -> value == null ? 1 : ++value);
		}
	}
}