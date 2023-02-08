package com.test.sierra.exam;

public class Drip extends Thread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Drip());
		t.start();
		t.join();
		for (int i = 0; i < 10; i++) // Loop #1
			System.out.print(Thread.currentThread().getName() + " ");
	}

	public void run() {
		for (int i = 0; i < 10; i++) // Loop #2
			System.out.print(Thread.currentThread().getName() + " ");
	}
}