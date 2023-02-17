package com.classwork.threads.io.collections;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Dispatcher {

	public static void main(final String[] args) throws Exception {

		final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
		final String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";
		List<String> filenames = new ArrayList<>(Arrays.asList("matrix.txt", "robot.txt", "robby.txt"));

		Transformer accumulator = new Transformer();
		Map<String, Integer> counters = new HashMap<>();
		final Queue<String> dataQueue = new ConcurrentLinkedQueue<>();

		new CountThread(dataQueue, path + filenames.get(0)).start();
		new CountThread(dataQueue, path + filenames.get(1)).start();
		new CountThread(dataQueue, path + filenames.get(2)).start();

		ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);

		for (int i = 0; i < THREAD_COUNT; i++) {
			es.execute(new Runner(accumulator, counters, dataQueue));
		}
		es.shutdown();
		es.awaitTermination(1, TimeUnit.MINUTES);

		System.out.println(counters);
	}
}
