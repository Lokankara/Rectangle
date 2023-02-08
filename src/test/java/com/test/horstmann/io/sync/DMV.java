package com.test.horstmann.io.sync;

public class DMV implements Runnable {
	public static void main(String[] args) {
		DMV d = new DMV();
		long s = (System.currentTimeMillis()/1000);
		new Thread(d).start();
		Thread t1 = new Thread(d);
		t1.run();
		System.out.println(System.currentTimeMillis()/1000-s);
	}

	public void run() {
		for (int j = 0; j < 4; j++) {
			do1();
			do2();
		}
	}

	void do1() {
		try {
			System.out.printf("#%s %d %n", Thread.currentThread().getId(), System.currentTimeMillis()/1000);
			Thread.sleep(500);
			System.err.printf("#%s %d %n", Thread.currentThread().getId(), System.currentTimeMillis()/1000);
		} catch (Exception e) {
			System.out.print("e ");
		}
	}

	synchronized void do2() {
		try {
			System.out.printf("#%s %d %n", Thread.currentThread().getId(), System.currentTimeMillis()/1000);
			Thread.sleep(500);
			System.err.printf("#%s %d %n", Thread.currentThread().getId(), System.currentTimeMillis()/1000);
		} catch (Exception e) {
			System.out.print("e ");
		}
	}
}
