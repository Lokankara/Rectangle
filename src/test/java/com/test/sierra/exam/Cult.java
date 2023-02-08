package com.test.sierra.exam;

public class Cult extends Thread {
	static int count = 0;
	String[] names = { "t1", "t2", "t3" };

	public void run() {
		for (int i = 0; i < 7; i++) {
			if (i == 5 && count < 3) {
				Thread t = new Cult(names[count++]);
				t.start();
				it(t);
				that();
			}
			System.out.println(Thread.currentThread().getName() + " ");
		}
	}

	private void that() {
		try {
			Thread.currentThread().join();
		} catch (Exception e) {
		}
	}

	private void it(Thread t) {
		try {
			t.join();
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		new Cult("t0").start();
	}

	Cult(String s) {
		super(s);
	}
}