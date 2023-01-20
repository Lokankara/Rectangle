package com.test.selikov;

import java.util.Arrays;

public class EchoFirst {
	public static void main(String[] args) {
		Arrays.sort(args);
//		int result = Arrays.binarySearch(args, args[0]);
		System.out.println(Arrays.toString(args));
		String one = args[0];
		 Arrays.sort(args);
		 int result = Arrays.binarySearch(args, one);
		 System.out.println(result);
	
	}
	
}