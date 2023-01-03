package com.test.sierra;

class SuperCool {
	static String os = "";

	void doStuff() {
		os += "super ";
	}
}

public class Cool extends SuperCool {
	public static void main(String[] args) {
		new Cool().go();
	}

	void go() {
		SuperCool s = new Cool();
		Cool c = (Cool) s;
		c.doStuff();
		s.doStuff();
		super.doStuff();
		this.doStuff();
	}

	void doStuff() {
		os += "cool ";
	}
}
