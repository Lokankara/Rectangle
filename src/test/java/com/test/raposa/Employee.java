package com.test.raposa;

public class Employee {

	public int employeeId;
	public String firstName, lastName;
	public java.util.GregorianCalendar hireDate;

	public int hashCode() {
		return employeeId;
	}

	public boolean equals(Employee e) {
		return this.employeeId == e.employeeId;
	}

	public static void main(String[] args) {
		Employee one = new Employee();
		one.employeeId = 101;

		Employee two = new Employee();
		two.employeeId = 101;

		if (one.equals(two)) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
		
		 String s1 = "Canada";
		 String s2 = new String(s1);
		 if(s1 == s2) {
		 System.out.println("s1 == s2");
		 }
		 if(s1.equals(s2)) {
		System.out.println("s1.equals(s2)");
		} 
	}
}