package com.test.selikov;

public class Sand {
	public Sand() {
		System.out.print("a");
	}

	public void Sand() {
		System.out.print("b");
	}

	public void run() {
		new Sand();
		Sand();
	}

	public static void main(String... args) {
		new Sand().run();
	}
}