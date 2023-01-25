package com.test.horstmann.collections;

public class StaticTest {
	public static void main(String[] args) {

		System.out.println("#4.3(static), #4.4(parameter)");
		
		Customers[] staff = new Customers[3];
		staff[0] = new Customers("Tom", 40000);
		staff[1] = new Customers("Dick", 60000);
		staff[2] = new Customers("Harry", 65000);
		for (Customers e : staff) {
			e.setId();
			System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
		}

		int n = Customers.getNextId();
		System.out.println("Next available id=" + n);

		Customers e = new Customers("Harry", 50000);
		System.out.println(e.getName() + " " + e.getSalary());

		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent=" + percent);
		tripleValue(percent);
		System.out.println("After: percent=" + percent);

		System.out.println("\nTesting tripleSalary:");
		Customers harry = new Customers("Harry", 50000);
		System.out.println("Before: salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary=" + harry.getSalary());

		System.out.println("\nTesting swap:");
		Customers a = new Customers("Alice", 70000);
		Customers b = new Customers("Bob", 60000);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}

	public static void tripleValue(double x) // doesn't work
	{
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}

	public static void tripleSalary(Customers x) // works
	{
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}

	public static void swap(Customers x, Customers y) {
		Customers temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
}
