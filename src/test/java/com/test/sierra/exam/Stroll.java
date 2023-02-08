package com.test.sierra.exam;

class Mosey implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d-%d ", Thread.currentThread().getId(), i);
		}
	}
}

public class Stroll {
	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new Mosey());
		t1.setPriority(8);
		t1.start();
		new Mosey().run();


	}
}