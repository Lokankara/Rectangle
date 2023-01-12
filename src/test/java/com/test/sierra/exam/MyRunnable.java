package com.test.sierra.exam;

public class MyRunnable implements Runnable {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();
		for (int i = 0; i < 10; i++) {
			new Thread(runnable, "Thread #" + i).start();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
