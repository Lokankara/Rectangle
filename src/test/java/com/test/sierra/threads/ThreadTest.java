package com.test.sierra.threads;

class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				System.out.print("t1 ");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				System.out.print("t2 ");
			}
		};
		t1.start();
		t1.sleep(100);
		t2.start();
		t2.sleep(100);
		
		System.out.println("main ");
		Thread thread1 = new Thread(new ExtendThread(), "thread1 ");
		Thread thread2 = new Thread(thread1, "thread2 ");
		thread1.start();
		thread2.start();
//		thread1.start();
	}
}

class ExtendThread extends Thread {
	public void run() {
		System.out.print(Thread.currentThread().getName());
	}
}