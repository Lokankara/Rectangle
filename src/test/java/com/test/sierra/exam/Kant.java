package com.test.sierra.exam;

public class Kant extends Philosopher {

//	Kant() { this("Bart"); } 
//	Kant(String s) { super(s); }
//	
	Kant() {
		super("Bart");
	}

	Kant(String s) {
		super(s);
	}

// doesn`t compile	
//	Kant() { super(); } 
//	Kant(String s) { super(s); } 
//	
//	Kant() { super("Bart"); } 
//	Kant(String s) { this(); }
//	
//	Kant() { super("Bart"); } 
//	Kant(String s) { this("Homer"); }

	public static void main(String[] args) {
		new Kant("Homer");
		new Kant();
	}
}

class Philosopher {
	Philosopher(String s) {
		System.out.print(s + " ");
	}
}
