package com.test.sierra.exam;

public class Weighty extends Heavy {
	void doStuff(int x) {
	}

//	 String doStuff(int x) { return "hi"; }
//	 public int doStuff(int x) { return 7; }
	private int doStuff(char c) throws Error {
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

class Big {
	void doStuff(int x) {
	}
}

class Heavy extends Big {
	void doStuff(byte b) {
	}
//	 protected void doStuff(int x) throws Exception { }
}