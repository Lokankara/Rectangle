package com.test.horstmann;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListTest {
	public static void main(String[] args) {
		var staff = new ArrayList<Employee>();
		staff.add(new Employee("Amy Lee", 2000));
		staff.add(new Employee("Harry Hacker", 2500));
		staff.add(new Employee("Gary Cooper", 1750));
		staff.add(new Employee("Francesca Cruz", 1250));
		staff.add(new Employee("Francesca Miller", 1500));
//		System.out.println(staff);
//		staff.forEach((e) -> System.out.printf("Salary: $%s, name: %s %n", e.getSalary(), e.getName()));

		staff.sort(Comparator.comparingDouble(Employee::getSalary));
		staff.forEach((e) -> System.out.printf("Salary: $%s, name: %s %n", e.getSalary(), e.getName()));
	}
}