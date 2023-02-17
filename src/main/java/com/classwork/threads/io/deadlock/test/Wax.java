package com.classwork.threads.io.deadlock.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Wax {
	public static void main(String[] args) throws InterruptedException {

		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}

class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car car) {
		super();
		this.car = car;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax on");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException ");
		}
		System.out.println(" End of Wax on task");
	}
}

class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		super();
		this.car = car;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax OFF");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException ");
		}
		System.out.println(" End of Wax off task");
	}
}

class Car {
	private boolean waxon = false;

	public synchronized void waxed() {
		waxon = true;
		notifyAll();
	}

	public synchronized void buffed() {
		waxon = false;
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxon == false) {
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxon == true) {
			wait();
		}
	}
}