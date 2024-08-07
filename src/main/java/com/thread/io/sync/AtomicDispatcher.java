package com.thread.io.sync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicDispatcher {

	public static void main(String[] args) {
		String path = "./";
		List<String> filenames = new ArrayList<>(Arrays.asList("TODO.md", "HELP.md", "README.md"));

		List<Thread> threadPool = AtomicController.getThreads(path, filenames);
		AtomicController.startThreads(threadPool);
		AtomicController.joinThreads(threadPool);
	}
}

class AtomicController {

	static List<Thread> getThreads(String path, List<String> filenames) {
		List<Thread> threadPool = new ArrayList<>();
		List<Runnable> atomicRunners = new ArrayList<>();

		for (int i = 0; i < filenames.size(); i++) {
			atomicRunners.add(new AtomicRunner(new Accumulator(String.format("%s%s", path, filenames.get(i)))));
			threadPool.add(new Thread(atomicRunners.get(i)));
		}
		return threadPool;
	}
	
	static void startThreads(List<Thread> threads) {
		long start = System.nanoTime();
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}
		long end = System.nanoTime();
		System.out.printf("Locking using atomic concurrent, read time: %d microseconds%n", (end - start) / 1_000);
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

class AtomicRunner implements Runnable {

	private LockAdder sum;
	private final Accumulator accumulator;

	public AtomicRunner(Accumulator accumulator) {
		this.sum = new LockAdder();
		this.accumulator = accumulator;
	}
	@Override
	public void run() {
		accumulator.accumulate(sum);
	}
}

final class LockAdder {

	private final Lock lock;
	private final Condition sufficientFunds;
	private static final DoubleAccumulator accumulator = new DoubleAccumulator((a, b) -> a + b, 0);

	public LockAdder() {
		this.lock = new ReentrantLock();
		this.sufficientFunds = lock.newCondition();
	}

	public void lock() {
		lock.lock();
	}

	public void unlock() {
		lock.unlock();
	}

	public void signalAll() {
		sufficientFunds.signalAll();
	}

	public double get() {
		return accumulator.doubleValue();
	}

	public static double getAll() {
		return accumulator.doubleValue();
	}

	public void add(double number) {
		accumulator.accumulate(number);
//		 System.out.printf("Thread #%s -> %.2f = %s%n", Thread.currentThread().getId(), number, accumulator);
	}
}

class Accumulator {

	private final File file;

	public Accumulator(String filename) {
		this.file = new File(filename);
	}

	void accumulate(LockAdder sum) {
		Matcher matcher;
		String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
		sum.lock();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile(patternNumber).matcher(scanner.next());
				if (matcher.find()) {
					sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
					sum.signalAll();
				}
			}
		} catch (IOException e) {
			System.err.printf("%s", e.getMessage());
		} finally {
			sum.unlock();
			System.out.printf("The total sum of numbers is %.4f, the current file was %s%n", sum.get(), file.getName());
		}
	}
}
