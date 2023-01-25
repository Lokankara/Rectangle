package com.test.heller;

import java.io.*;

public class Xxx {

	public static void main(String[] args) {
		try {
			File f = new File("xxx.ser");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Object());
			oos.close();
			fos.close();
		} catch (Exception x) {
		}
	}
}