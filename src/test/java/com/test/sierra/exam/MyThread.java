package com.test.sierra.exam;

public class MyThread implements Runnable {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			MyThread my = new MyThread();
			Thread thread = new Thread(my);
			thread.start();
		}

	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
