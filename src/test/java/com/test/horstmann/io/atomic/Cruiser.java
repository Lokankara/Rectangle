package com.test.horstmann.io.atomic;

class Cruiser {
	private int a = 0;

	public void foo() {
		
		Runnable r = new LittleCruiser();
		new Thread(r).start();
		new Thread(r).start();
	}

	public static void main(String args[]) {
		Cruiser c = new Cruiser();
		c.foo();
	}

	public class LittleCruiser implements Runnable {
		public void run() {
			int counter = 0;
			for (int i = 0; i < 4; i++) {
				counter = a;
//				System.out.printf("i:%d ", i);
				System.out.printf("c:%d ", counter);
				System.err.printf("a:%d ", a);
				a = counter + 2;
			}
		}
	}
}