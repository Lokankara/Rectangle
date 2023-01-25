package com.test.sierra.serialization;

import java.io.*;

class Keyboard implements Serializable {
}

public class Computer implements Serializable {

	static final long serialVersionUID = -18982551340645L;
	private Keyboard k = new Keyboard();

	public static void main(String[] args) {
		Computer c = new Computer();
		c.storeIt(c);
	}

	void storeIt(Computer c) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myFile.txt"));
			os.writeObject(c);
			os.close();
			System.out.println("done");
		} catch (Exception x) {
			System.out.println(x);
		}
	}
}