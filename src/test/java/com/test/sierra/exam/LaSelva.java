package com.test.sierra.exam;

public class LaSelva extends Beach {
	LaSelva() {
		s = "LaSelva";
	}

	public static void main(String[] args) {
		new LaSelva().go();
	}

	void go() {
		Beach[] ba = { new Beach(), new LaSelva(), (Beach) new LaSelva() };
		for (Beach b : ba)
			System.out.print(b.getBeach().s + " ");
	}

	LaSelva getBeach() {
		return this;
	}
}

class Beach {
	String s;

	Beach() {
		s = "Beach";
	}

	Beach getBeach() {
		return this;
	}
}