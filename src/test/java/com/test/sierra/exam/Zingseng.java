package com.test.sierra.exam;

public class Zingseng extends Thread {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Zingseng());
		t.start();
		Thread.sleep(1000);
//		t.yield();
//		t.join();
		t.sleep(1000);
		for (int i = 0; i < 10; i++) // Loop #1
			System.out.println(Thread.currentThread().getName() + "#1 ");
	}

	public void run() {
		for (int i = 0; i < 10; i++) // Loop #2
			System.out.println(Thread.currentThread().getName() + "#2 ");
	}
}