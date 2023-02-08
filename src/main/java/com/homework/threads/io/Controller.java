package com.homework.threads.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller {

	public static final String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";
	private static final int maxFiles = 3;
	private static final Comparator<Wrapper> comparator = Comparator.comparingInt(Wrapper::getCounter);
	
	static final TreeSet<Wrapper> multiTreeSet = new TreeSet<>(comparator);
	static final TreeSet<Wrapper> oneTreeSet = new TreeSet<>(comparator);
	static final TreeSet<Wrapper> runTreeSet = new TreeSet<>(comparator);

	private Controller() {
	}
	public static long runMultiThreads(List<String> filenames) {

		List<Wrapper> wrappers = new ArrayList<>();

		long start = 0;
		long end = 0;
		
		start = System.nanoTime();
		for (int i = 0; i < maxFiles; i++) {
			wrappers.add(new Wrapper(new File(String.format("%s%s", path, filenames.get(i)))));
			new Thread(new Runner(wrappers.get(i))).run();
		}
		end = System.nanoTime();

		runTreeSet.addAll(wrappers);

		return (end - start);
	}

	public static long readMultiThreads(List<String> filenames) {

		List<Future<Wrapper>> futures = new ArrayList<>();
		List<Callable<Wrapper>> wrappers = new ArrayList<>();
		long start = 0;
		long end = 0;
		start = System.nanoTime();
		
//		 ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (int i = 0; i < maxFiles; i++) {
			wrappers.add(new Caller(new Wrapper(new File(String.format("%s%s", path, filenames.get(i))))));
		}

		try {
			futures = service.invokeAll(wrappers);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			Thread.currentThread().interrupt();
		} finally {
			service.shutdown();
		}
		end = System.nanoTime();

		if (!futures.isEmpty()) {
			for (Future<Wrapper> future : futures) {
				try {
					multiTreeSet.add(future.get());
				} catch (InterruptedException | ExecutionException e) {
					System.err.println(e.getMessage());
					Thread.currentThread().interrupt();
//					throw new RuntimeException();
				}
			}
		}
		return (end - start);
	}

	static long readSingleThread(List<String> filenames) {

		List<Wrapper> wrappers = new ArrayList<>();

		long start = System.nanoTime();

		for (int i = 0; i < maxFiles; i++) {
			wrappers.add(new Caller(new Wrapper(new File(String.format("%s%s", path, filenames.get(i))))).call());
		}

		long end = System.nanoTime();

		oneTreeSet.addAll(wrappers);

		return (end - start);
	}
}