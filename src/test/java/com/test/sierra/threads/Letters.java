package com.test.sierra.threads;

public class Letters extends Thread {
	private String name;

	public Letters(String name) {
		this.name = name;
	}

	public void write() {
		System.out.print(name);
		System.out.print(name);
	}

	public static void main(String[] args) {
		new Letters("X").start();
		new Letters("Y").start();	
	}
	
//	 public void run() { write(); }
//	  public synchronized void run() { write(); }
//	  public static synchronized void run() { write(); }
	  public void run() { synchronized(this) { write(); } }
//	  public void run() { synchronized(Letters.class) { write(); } }
//	 public void run() { synchronized(System.out) { write(); } }
//	  public void run() { synchronized(System.out.class) { write(); } }
}