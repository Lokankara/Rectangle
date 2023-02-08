package com.classwork.threads.io.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceCounter {
	
	private final ReentrantLock lock;

	static AtomicReference<Double> sum = new AtomicReference<Double>();

	static double getAndAdd(double delta) {
		while (true) {
			Double currentValue = sum.get();
			Double newValue = Double.valueOf(currentValue.doubleValue() + delta);
			if (sum.compareAndSet(currentValue, newValue))
				return currentValue.doubleValue();
		}
	}
}
