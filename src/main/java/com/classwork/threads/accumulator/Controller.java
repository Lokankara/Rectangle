package com.classwork.threads.accumulator;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public static final String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";

	public static long syncStart(List<String> filenames) {
		List<Runnable> runners = new ArrayList<>();
		List<Thread> threadPool = new ArrayList<>();

		for (int i = 0; i < filenames.size(); i++) {
			runners.add(new SyncRunner(String.format("%s%s", path, filenames.get(i))));
			threadPool.add(new Thread(runners.get(i)));
		}

		long start = System.nanoTime();
		for (int i = 0; i < threadPool.size(); i++) {
			threadPool.get(i).start();
		}

		long end = System.nanoTime();
		return (end - start);
	}

	public static long atomicStart(List<String> filenames) {
		List<Runnable> runners = new ArrayList<>();
		List<Thread> threadPool = new ArrayList<>();

		for (int i = 0; i < filenames.size(); i++) {
			runners.add(new AtomicRunner(String.format("%s%s", path, filenames.get(i))));
			threadPool.add(new Thread(runners.get(i)));
		}

		long start = System.nanoTime();
		for (int i = 0; i < threadPool.size(); i++) {
			threadPool.get(i).start();
		}

		long end = System.nanoTime();
		return (end - start);
	}
}
