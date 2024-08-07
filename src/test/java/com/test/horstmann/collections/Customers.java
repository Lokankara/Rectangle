package com.test.horstmann.collections;

public class Customers {
	private static int nextId = 1;

	private String name;
	private double salary;
	private int id;

	public Customers(String n, double s) {
		name = n;
		salary = s;
		id = 0;
	}

	public Customers(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	public static int getNextId() {
		return nextId;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}
	
}