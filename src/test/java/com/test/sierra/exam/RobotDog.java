package com.test.sierra.exam;

import java.util.Arrays;

public class RobotDog {

	public static void main(String[] args) {
		
		 Integer i1 = 2001; // set 1 
		 Integer i2 = 2001; 
		 System.out.println((i1 == i2) + " " + i1.equals(i2)); // output 1 
		 Integer i3 = 21; // set 2 
		 Integer i4 = new Integer(21); 
		 System.out.println((i3 == i4) + " " + i3.equals(i4)); // output 2 
		 Integer i5 = 21; // set 3 
		 Integer i6 = 21; 
		 System.out.println((i5 == i6) + " " + i5.equals(i6)); // output 3

		
		String s = "dogs. with words.";
		String[] output = s.split("\\d");
		output = s.split("\\s");
		output = s.split("\\.");
		Arrays.asList(output).forEach(o -> System.out.printf("%s%n", o));
//		for (String o : output)
//			System.out.printf("%s%n", o);
	}

	int size;

	void bark() {
		/* do barking */ }

	int getSize() {
		return size;
	}

	{
		size = 16;
	}

	int getNetworkPrinterID() {
		/* do lookup */
		return 37;
	}

	void printRobotDogStuff(int printerID) {
		/* print RobotDog stuff */ }
}
