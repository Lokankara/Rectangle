package com.test.horstmann.io.sync;

class Jog implements Runnable {
	public void run() {
		for (int i = 0; i < 8; i++) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				System.out.print("exc ");
			}
			System.out.print(i + " ");
		}
	}
}

public class Marathon {
	public static void main(String[] args) throws Exception {
		Jog j1 = new Jog();
		Thread t1 = new Thread(j1);
		t1.start();
		t1.sleep(500);
		System.out.print("pre ");
		t1.interrupt();
		t1.sleep(500);
		System.out.print("post ");
	}
}
