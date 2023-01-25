package com.test.ganesh;

import java.io.*;
//Static transient variables are retained during serialization.
//If a class is serialized and you try to serialize it again, 
//the JVM will not serialize it due to the same serialVersionUID

class USPresident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "US President [name=" + name + ", period=" + period + ", term=" + term + "]";
	}

	public USPresident(String name, String period, String term) {
		this.name = name;
		this.period = period;
		this.term = term;
	}

	private String name;
	private String period;
	private static transient String term;
}

class TransientSerialization {
	public static void main(String[] args) {
		USPresident usPresident = new USPresident("Barack Obama", "2009 to --", "56th term");
		System.out.println(usPresident);
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("USPresident.data"))) {
			oos.writeObject(usPresident);
		} catch (IOException ioe) {
// ignore
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("USPresident.data"))) {
			Object obj = ois.readObject();
			if (obj != null && obj instanceof USPresident) {
				USPresident presidentOfUS = (USPresident) obj;
				System.out.println(presidentOfUS);
			}
		} catch (IOException ioe) {
// ignore
		} catch (ClassNotFoundException e) {
// ignore
		}
	}
}
