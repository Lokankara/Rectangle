package com.classwork.threads.io.atomic;

import java.io.File;

public class AtomicDispatcher {
	
	public static void main(String args[]) throws InterruptedException {
	
		Thread t1 = new Thread(new AtomicRunner(new Accumulator(new File("TODO.md"))));
		Thread t2 = new Thread(new AtomicRunner(new Accumulator(new File("README.md"))));
		Thread t3 = new Thread(new AtomicRunner(new Accumulator(new File("HELP.md"))));
		t1.start();
		t2.start();
		t3.start();

		t3.join();
		t1.join();
		t2.join();
		
		System.err.println(AICounter.sum);
		
	}
}
