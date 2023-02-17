package com.classwork.threads.io.deadlock.test;

class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("InterruptedException");
			}
		}
		System.out.println("Consumer got " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {

		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("InterruptedException");
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Producer put " + n);
		notify();
	}
	
	
}