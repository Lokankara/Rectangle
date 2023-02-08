package com.classwork.threads.basic;

import static com.classwork.threads.basic.MarksCounterDispatcher.path;

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

class Controller {

	private final static int maxFiles = 3;
	private final static  Comparator<Wrapper> comparator = Comparator.comparingInt(Wrapper::getCounter);
	final static TreeSet<Wrapper> multiTreeSet = new TreeSet<>(comparator);
	final static TreeSet<Wrapper> oneTreeSet = new TreeSet<>(comparator);

	public static long readMultiThreads(List<String> filenames) {

		List<Callable<Wrapper>> calls = new ArrayList<>();


		long end = 0;
		long start = System.nanoTime();

		for (int i = 0; i < maxFiles; i++) {
			calls.add(new Caller(new Wrapper(new File(String.format("%s%s", path, filenames.get(i))))));
		}
		
		try {		
//			ExecutorService service = Executors.newCachedThreadPool();
			ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			List<Future<Wrapper>> futures = service.invokeAll(calls);
			service.shutdown();
			end = System.nanoTime();

			if (futures.size() != 0) {
				for (Future<Wrapper> future : futures) {
					multiTreeSet.add(future.get());
				}
			}
		} catch(InterruptedException | ExecutionException e) {
			System.err.println(e.getMessage());
		}
		return (end - start);
	}

	static long readOneThread(List<String> filenames) {

		List<Wrapper> wrappers = new ArrayList<>();

		long start = System.nanoTime();

		for (int i = 0; i < maxFiles; i++) {
			wrappers.add(new Caller(new Wrapper(new File(String.format("%s%s", path, filenames.get(i))))).call());
		}

		long end = System.nanoTime();

		if (wrappers.size() != 0) {
			for (Wrapper wrapper : wrappers) {
				oneTreeSet.add(wrapper);
			}
		}
		return (end - start);
	}
}