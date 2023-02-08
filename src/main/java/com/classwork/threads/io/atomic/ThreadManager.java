package com.classwork.threads.io.atomic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadManager {
	private static ThreadManager instance;
	private static final int MAX_READERS_SIZE = 3;
	private static final AtomicBoolean locked = new AtomicBoolean(false);

	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();

	private static final Deque<Accumulator> aviableReaders = new ArrayDeque<>();
	private static final Deque<Condition> waitingQueue = new ArrayDeque<>();

	private ThreadManager() {
		for (int i = 0; i < MAX_READERS_SIZE; i++) {
			aviableReaders.add(new Accumulator());
		}
	}

	public static ThreadManager getInstance() {
		while (instance == null) {
			if (locked.compareAndSet(false, true)) {
				instance = new ThreadManager();
			}
		}
		return instance;
	}

	public void read() {
		double length = 0;
		String threadName = Thread.currentThread().getName();
		try {
			readLock.lock();
			System.out.println(" Read begin: " + threadName);
			TimeUnit.MILLISECONDS.sleep(50);
			TimeUnit.MILLISECONDS.sleep(50);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}
}
