package com.test.horstmann.collections;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListTest {
	public static void main(String[] args) {
		var staff = new ArrayList<Customers>();
		staff.add(new Customers("Amy Lee", 2000));
		staff.add(new Customers("Harry Hacker", 2500));
		staff.add(new Customers("Gary Cooper", 1750));
		staff.add(new Customers("Francesca Cruz", 1250));
		staff.add(new Customers("Francesca Miller", 1500));
//		System.out.println(staff);
//		staff.forEach((e) -> System.out.printf("Salary: $%s, name: %s %n", e.getSalary(), e.getName()));

		staff.sort(Comparator.comparingDouble(Customers::getSalary));
		staff.forEach((e) -> System.out.printf("Salary: $%s, name: %s %n", e.getSalary(), e.getName()));
	}
}