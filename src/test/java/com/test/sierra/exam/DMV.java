package com.test.sierra.exam;

public class DMV implements Runnable {
	public static void main(String[] args) {
		DMV d = new DMV();
		new Thread(d).start();
		Thread t = new Thread(d);
		t.start();
	}

	public void run() {
		for (int j = 0; j < 4; j++) {
			do1();
			do2();
		}
	}

	void do1() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print("e ");
		}
	}

	synchronized void do2() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print("e ");
		}
	}
}