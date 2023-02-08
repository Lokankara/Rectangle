package com.test.sierra.threads;

class PingPong extends Thread {
	public void run() {
		System.out.println("ping");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread pingPong = new PingPong();
		pingPong.start();
		pingPong.join();
		System.out.println("pong");
	}
}