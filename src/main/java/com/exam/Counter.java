package com.exam;

import java.util.concurrent.CountDownLatch;

class Counter implements Runnable {
	public static int COUNTER = 0;
	private CountDownLatch latch;

	public Counter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		for (int i = 0; i < latch.getCount(); i++) {
			COUNTER++;
			latch.countDown();
			System.out.println(COUNTER);
		}
	}
}
