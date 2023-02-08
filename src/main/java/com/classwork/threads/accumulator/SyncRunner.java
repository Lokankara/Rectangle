package com.classwork.threads.accumulator;

public class SyncRunner implements Runnable {

	private final SyncAdder sum;
	private final Accumulator accumulator;

	public SyncRunner(String filename) {
		super();
		this.accumulator = new Accumulator(filename);
		this.sum = new SyncAdder();
	}

	@Override
	public void run() {
		accumulator.accumulate(sum);
	}
}

class SyncAdder {

	private double sum;

	public synchronized double get() {
		return sum;
	}

	public synchronized void add(double number) {
		sum += number;
//		System.out.printf("Thread #%s -> %.2f = %.2f%n", Thread.currentThread().getId(), number, sum);
	}
}