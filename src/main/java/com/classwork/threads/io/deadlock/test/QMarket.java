package com.classwork.threads.io.deadlock.test;

public class QMarket {
	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		p.t.start();
		c.t.start();
		System.out.println("CTRL + C");
	}
}


class Producer implements Runnable {
	Q q;
	Thread t;

	public Producer(Q q) {
		this.q = q;
		this.t = new Thread(this, "Producer");
	}

	@Override
	public void run() {
		int i = 0;
		while (q.n <100) {
			q.put(i++);
		}
	}

}

class Consumer implements Runnable {

	Q q;
	Thread t;

	public Consumer(Q q) {
		this.q = q;
		this.t = new Thread(this, "Consumer");
	}

	@Override
	public void run() {
		while (q.n <100) {
			q.get();
		}
	}
}
