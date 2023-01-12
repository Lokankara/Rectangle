package com.test.sierra.exam;

public class Fabric extends Thread {
	public static void main(String[] args) {
		System.out.println("This static method cannot hide the instance method from Thread");
		Thread t = new Thread(new Fabric());
		Thread t2 = new Thread(new Fabric());
		t.start();
		t2.start();
	}

	public void run() {
		for (int i = 0; i < 2; i++)
			System.out.print(Thread.currentThread().getName() + " ");
	}
}