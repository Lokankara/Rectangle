package com.test.raposa.io;

import java.io.*;

public class Employee implements Serializable {
	private String name;
	private float salary;
	private int id;

	public Employee(String name, float salary, int id) {
		this.name = name;
		this.salary = salary;
		this.id = id;
	}

	public static void main(String[] args) throws IOException {
		Employee e = new Employee("Jim", 10F, 44);
		FileOutputStream fs = new FileOutputStream("e.ser");
		new ObjectOutputStream(fs).writeObject(e);
	}
}