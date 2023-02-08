package com.test.sierra.exam;

public class Juggler extends Thread {
	public static void main(String[] args) {
		Thread t = new Thread(new Juggler());
		Thread t2 = new Thread(new Juggler());
		try {
			t.start();
			t2.start();
		} catch (Exception e) {
			System.out.print("e ");
		}
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.print("e2 ");
			}
		}
		System.out.print(Thread.currentThread().getName() + " ");
	}
}