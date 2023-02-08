package com.test.horstmann.io.atomic;

import java.util.ArrayList;
import java.util.List;

public class SchildtSuspendResume {

	public static void main(String[] args) throws InterruptedException {
		List<NewThread> pool = new ArrayList<>();

		NewThread factory = new NewThread();
		factory.createAndStart();
		
		pool.add(new NewThread("Alice"));
		pool.add(new NewThread("Bob"));
		pool.add(new NewThread("Carl"));
		pool.add(new NewThread("Dan"));
		pool.add(new NewThread("Elly"));
		pool.add(new NewThread("Frank"));

		pause(pool);
		join(pool);
		currentName(pool);

		System.err.printf("Main thread finished");
	}

	private static void pause(List<NewThread> pool) throws InterruptedException {
		for (int i = 0; i < pool.size(); i++) {
			Thread.sleep(700);
			pool.get(i).mysuspend();
			System.err.printf("Stopped thread %s %s%n", pool.get(i).thread.getName(), pool.get(i).thread.getState());
			pool.get(i).myresume();
			System.out.printf("Resumed thread %s %s%n", pool.get(i).thread.getName(), pool.get(i).thread.getState());
		}
	}

	private static void currentName(List<NewThread> pool) {
		for (int i = 0; i < pool.size(); i++) {
			System.out.printf("Started #%d: %b %s %s %s%n", i, pool.get(i).thread.isAlive(),
					pool.get(i).thread.getName(), pool.get(i).thread.getState(), Thread.currentThread().getPriority());
		}
	}

	private static void join(List<NewThread> pool) throws InterruptedException {
		for (int i = 0; i < pool.size(); i++) {
			System.out.printf("Running #%d: %b %s %s %s%n", i, pool.get(i).thread.isAlive(),
					pool.get(i).thread.getName(), pool.get(i).thread.getState(), Thread.currentThread().getPriority());
			pool.get(i).thread.join();
		}
	}
}

class NewThread implements Runnable {
	int size = 5;
	long start, end;
	boolean suspendFlag;

	String name;
	Thread thread;

	public NewThread(String name) {
		super();
		this.name = name;
		this.thread = new Thread(this, name);
		System.out.println("New thread " + thread);
		suspendFlag = false;
		thread.start();

//		int p = (int) ((Math.random()) * 10);
//		if (p > 0 && p < 10)
//			this.thread.setPriority(p);
	}
	public NewThread() {
		super();
		this.name = "Default";
		this.thread = new Thread(this, name);
	}

	public static NewThread createAndStart() {
			NewThread t = new NewThread("Factory");
			t.thread.start();
			return t;
	}
	
	@Override
	public void run() {
		start = System.nanoTime();
		String name = Thread.currentThread().getName();
		System.out.println("Start by " + name);
		try {
			for (int i = 0; i < size; i++) {
				System.out.printf("Synchronized %d %s %s %s %n", i, name, Thread.currentThread().getPriority(),
						Thread.currentThread().getState());
				Thread.sleep(200);
				synchronized (this) {
					while (suspendFlag)
						wait();
				}
			}
		} catch (InterruptedException e) {
			System.err.println(name + " Interrupted");
		}
		end = System.nanoTime();
		System.err.printf("%s finished at %d%n", name, (end - start) / 1_000_000);
	}

	synchronized void mysuspend() {
		suspendFlag = true;
	}

	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
}
