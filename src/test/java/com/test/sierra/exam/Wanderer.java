package com.test.sierra.exam;

class Wander implements Runnable {
	public void run() {
		for (int i = 0; i < 2; i++)
			System.out.print(Thread.currentThread().getName() + " ");
	}
}

class Wanderer {
	public static void main(String[] args) {
		Wander w = new Wander();
		Thread t1 = new Thread();
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w, "fred");
		t1.start();
		t2.start();
		t3.start();
	}
}