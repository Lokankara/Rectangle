package com.homework.threads.io.sync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.IOException;

public class SyncDispatcher {
	
	public static void main(String[] args) {
		String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";
		List<String> filenames = new ArrayList<>(Arrays.asList("TODO.md", "HELP.md", "README.md"));

		List<Thread> threads = AtomicController.getThreads(path, filenames);
		AtomicController.startThreads(threads);
		AtomicController.joinThreads(threads);
	}
}

class SyncController {

	static List<Thread> getThreads(String path, List<String> filenames) {
		List<Runnable> runners = new ArrayList<>();
		List<Thread> threadPool = new ArrayList<>();

		for (int i = 0; i < filenames.size(); i++) {
			runners.add(new SyncRunner(String.format("%s%s", path, filenames.get(i))));
			threadPool.add(new Thread(runners.get(i)));
		}
		return threadPool;
	}

	static void startThreads(List<Thread> threadPool) {
		long start = System.nanoTime();
		for (int i = 0; i < threadPool.size(); i++) {
			threadPool.get(i).start();
		}
		long end = System.nanoTime();

		System.out.printf("Locking using synchronized keyword, read time: %d microseconds%n", (end - start) / 1_000);
	}

	static void joinThreads(List<Thread> threads) {
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println(e);
			}
		}
		System.out.printf("The total sum of numbers is %.4f in all files%n", LockAdder.getAll());
	}
}

class SyncRunner implements Runnable {

	private File file;
	private final SyncAdder sum;

	public SyncRunner(String filename) {
		super();
		this.sum = new SyncAdder();
		this.file = new File(filename);
	}
	@Override
	public void run() {
		accumulate(sum);
	}

	void accumulate(SyncAdder sum) {
		Matcher matcher;
		double next;
		String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile(patternNumber).matcher(scanner.next());
				if (matcher.find()) {
					next = Double.parseDouble(matcher.group().replace(",", "."));
					sum.add(next);
				}
			}
		} catch (IOException e) {
			System.err.printf("%s", e.getMessage());
		} finally {
			System.out.printf("The total sum of numbers is %.4f, the current file was %s%n", sum.get(), file.getName());
		}
	}
}

final class SyncAdder {

	private static double sum;

	public synchronized double get() {
		return sum;
	}

	public static double getSum() {
		return sum;
	}

	public synchronized void add(double number) {
		sum += number;
//		System.out.printf("Thread #%s -> %.2f = %.2f%n", Thread.currentThread().getId(), number, sum);
	}
}
