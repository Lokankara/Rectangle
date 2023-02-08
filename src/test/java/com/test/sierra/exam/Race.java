package com.test.sierra.exam;

public class Race {
	public static void main(String[] args) {
		Horsez h = new Horsez();
		Thread t1 = new Thread(h, "Andi");
		Thread t2 = new Thread(h, "Eyra");
		new Race().go(t2);
		new Race().go(t1);
//		t1.start();
//		t2.start();
	}

	void go(Thread t) {
		t.start();
	}
}

class Horsez implements Runnable {
//	String name;
//	
//	public Horsez() {
//		super();
//	}
//
//	public Horsez(String name) {
//		this.name = name;
//	}

	public void run() {
		System.out.print(Thread.currentThread().getName() + " ");
	}
}