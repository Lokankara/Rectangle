package com.classwork.threads;

public class Handler {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = Thread.currentThread();
//		System.out.println(thread);
		thread.setName("Base");
		Other o = new Other();
		Thread a = new Thread(new Another());
		o.setPriority(10);
		o.start();
		a.start();
//		o.run();
		for (int i = 0; i < 5; i++) {
			if (i > 1) {
				o.join();
			}
			Thread.yield(); // !!!
			Thread.sleep(500);
			System.out.printf("a:%d%n", i);
		}
	}
}

class Other extends Thread {
	public void run() {
		for (int j = 0; j < 5; j++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.printf("b:%d%n", j);
		}
	}
}

class Another implements Runnable {

	@Override
	public void run() {
		for (int k = 0; k < 5; k++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.printf("c:%d%n", k);
		}

	}
}