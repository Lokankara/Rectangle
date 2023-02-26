package com.homework.threads.io.lock;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dispatcher {
	public static void main(String[] args) throws InterruptedException {
		String filename = "TODO.md";
		String filename1 = "HELP.md";
		
		Thread thread = new Thread(new Run(filename));
		Thread t1 = new Thread(new Run(filename1));
		t1.start();
		thread.start();
		System.err.println(LockCounter.sum);

	}
}

class Resource {

	File file;

	public Resource(String filename) {
		this.file = new File(filename);
	}

	public void reader(LockCounter counter) {

		counter.getLock().lock();
		try (Scanner scanner = new Scanner(file)) {

			counter.addSum(scanner.findAll(" ").count());
			counter.getSufficientFunds().signalAll();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			counter.getLock().unlock();
		}
	}
}

class LockCounter {

	static long sum;
	private final Lock lock = new ReentrantLock();
	private final Condition sufficientFunds = lock.newCondition();

	public LockCounter() {

	}

	public void addSum(long sum) {
		this.sum += sum;
	}

	public Lock getLock() {
		return lock;
	}

	public Condition getSufficientFunds() {
		return sufficientFunds;
	}
}

class Run implements Runnable {

	LockCounter counter;
	Resource resource;

	public Run(String filename) {
		this.counter = new LockCounter();
		this.resource = new Resource(filename);
	}

	@Override
	public void run() {
		resource.reader(counter);
	}
}
