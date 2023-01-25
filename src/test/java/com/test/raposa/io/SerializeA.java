package com.test.raposa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeA {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		A ref = new A(12);
		FileOutputStream fos = new FileOutputStream("a.ser");
		new ObjectOutputStream(fos).writeObject(ref);
		FileInputStream fis = new FileInputStream("a.ser");
		A ref2 = (A) new ObjectInputStream(fis).readObject();
		System.out.print(ref2);
		fos.close();
	}
}

class A implements Serializable {
	public int a;

	public A(int a) {
		this.a = a;
		System.out.print("A");
	}

	@Override
	public String toString() {
		return String.format("%d", a);
	}
	
}