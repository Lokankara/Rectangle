package com.classwork.threads.accumulator;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AtomicRunner implements Runnable {

	private final Lock lock;
	private final DoubleAdder sum;
	private final Accumulator accumulator;

	public AtomicRunner(String filename) {
		super();
		this.lock = new ReentrantLock();
		this.sum = new DoubleAdder();
		this.accumulator = new Accumulator(filename);
	}
	
	@Override
	public void run() {
		accumulator.accumulate(sum, lock);
	}
}
