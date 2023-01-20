package com.test.sierra.exam;

class Engine {
	public class Piston {
		int count = 0;

		void go() {
			System.out.print(" pump " + ++count);
		}
	}

	public Piston getPiston() {
		return new Piston();
	}
}

public class Auto {
	public static void main(String[] args) {
		Engine e = new Engine();
		Engine.Piston p = e.getPiston();
//			e.Piston p = e.getPiston();
		p.go();
		p.go();
	}
}