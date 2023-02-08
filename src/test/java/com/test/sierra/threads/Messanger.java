package com.test.sierra.threads;

public class Messanger implements Runnable {
	public static void main(String[] args) {
		new Thread(new Messanger("Wallace")).start();
		new Thread(new Messanger("Gromit")).start();
	}

	private String name;

	public Messanger(String name) {
		this.name = name;
	}

	public void run() {
		message(1);
		message(2);
	}

	private synchronized void message(int n) {
		System.out.print(name + "-" + n + " ");
	}
}