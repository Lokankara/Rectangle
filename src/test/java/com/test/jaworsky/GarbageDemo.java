package com.test.jaworsky;

public class GarbageDemo {
	Garbage g;
	int max;

	public static void main(String[] args) {
		int n = 15;
		if (args.length > 0)
			n = (new Integer(args[0])).intValue();
		GarbageDemo app = new GarbageDemo(n);
		app.run();
	}

	public GarbageDemo(int n) {
		max = n;
	}

	void run() {
		for (int i = 1; i < max; ++i) {
			g = new Garbage(i);
		}
	}
}

class Garbage {
	String[] trash;
	int value;

	public Garbage(int n) {
		value = n;
		trash = new String[n];
		trash[0] = "This String uses up memory resources. ";
		for (int i = 1; i < n; ++i) {
			trash[i] = trash[i - 1] + trash[i - 1];
		}
	}

	protected void finalize() {
		System.out.println(value + " is being collected.");
	}
}