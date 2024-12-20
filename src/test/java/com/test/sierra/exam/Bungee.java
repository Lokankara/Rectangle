package com.test.sierra.exam;

import java.io.*;

interface Risky {
	String doStuff() throws Exception;

	Risky doCrazy();

	void doInsane();
}

public class Bungee implements Risky {
	public String doStuff() throws IOException {
		throw new IOException();
	}

	public Bungee doCrazy() {
		return new Bungee();
	}

	public void doInsane() throws NullPointerException {
		throw new NullPointerException();
	}
}
