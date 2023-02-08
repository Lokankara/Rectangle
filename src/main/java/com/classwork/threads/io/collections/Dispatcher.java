package com.classwork.threads.io.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.homework.threads.io.collections.Controller;

public class Dispatcher {
	private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

	public static void main(final String[] args) throws Exception {
		Accumulator counter = new Accumulator();

		Map<String, Long> counters = new HashMap<>();
		final Queue<String> dataQueue = new ConcurrentLinkedQueue<>();
		
		List<String> filenames = new ArrayList<>(Arrays.asList("matrix.txt", "robot.txt", "robby.txt"));

		new CountThread(dataQueue, filenames.get(0)).start();
		new CountThread(dataQueue, filenames.get(1)).start();
		new CountThread(dataQueue, filenames.get(2)).start();
		
		ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
		for (int i = 0; i < THREAD_COUNT; i++) {
			service.execute(new Runner(counter, counters, dataQueue));
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println(Controller.sortMap(counters));
	}
}