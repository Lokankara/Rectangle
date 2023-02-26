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

		a(t1);
		b(t1);
		c(t1);
		d(t1);

	}

	private static void d(Thread t1) {
		t1.setPriority(8);
		t1.start();
		new Mosey().run();
	}

	private static void c(Thread t1) {
		t1.setPriority(1);
		t1.start();
		new Mosey().run();
	}

	private static void b(Thread t1) {
		t1.setPriority(9);
		new Mosey().run();
		t1.start();
	}

	private static void a(Thread t1) {
		t1.setPriority(1);
		new Mosey().run();
		t1.start();
	}
}