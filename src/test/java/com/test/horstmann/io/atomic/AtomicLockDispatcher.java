package com.test.horstmann.io.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicLockDispatcher {

	public static void main(String args[]) {

		ReentrantLock lock = new ReentrantLock();

		new Thread(new LockRunner(lock, "А")).start();
		new Thread(new LockRunner(lock, "B")).start();

	}
}

class LockRunner implements Runnable {
	AtomicInteger count = new AtomicInteger();
	ReentrantLock lock;
	String name;

	public LockRunner(ReentrantLock lock, String name) {
		super();
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("Run %s%n", name);
		try {
			System.out.printf("Locked counter %s%n", name);
			lock.lock();
			count.addAndGet(1);
			System.out.printf("Counter %s%n", count);
			System.out.printf("Waiting 100 millis %n");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println(e);
		} finally {
			System.out.printf("Unlocked counter %s%n", name);
			lock.unlock();
		}
	}
}
