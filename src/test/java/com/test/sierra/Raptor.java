package com.test.sierra;

public class Raptor extends Bird {
	static {
		System.out.println("static - R1 ");
	}

	public Raptor() {
		System.out.println("constructor - R2 ");
	}

	static {
		System.out.println("static - R4 ");
	}
	{
		System.out.println("scope - R3 ");
	}
}
