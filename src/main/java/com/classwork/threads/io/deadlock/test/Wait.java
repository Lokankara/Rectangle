package com.classwork.threads.io.deadlock.test;

public class Wait {

	public static void main(String[] args) {
		Product product = new Product();
		Maker producer = new Maker(product);
		Getter consumer = new Getter(product);
	}
}

class Product {

	int data;
	boolean valueSet = false;

	public synchronized int getData() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		valueSet = false;
		notify();
		return data;
	}

	public synchronized void setData(int data) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("set : " + data);
		this.data = data;
		valueSet = true;
		notify();
	}
}

class Maker implements Runnable {

	Product product;

	public Maker(Product product) {
		this.product = product;
		Thread thread = new Thread(this, "Producer");
		thread.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			product.setData(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Getter implements Runnable {

	Product product;

	public Getter(Product product) {
		this.product = product;
		Thread thread = new Thread(this, "Consumer");
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("get : " + product.getData());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
