package com.test.selikov;

public class AreYouBob {
	public static void main(String[] unused) {
		String bob = new String("bob");
		String notBob = bob;
		System.out.print((bob == notBob) + " " + (bob.equals(notBob)));
		
		int x = 10, y = 5;
		boolean w = true, z = false;
		x = w ? y++ : y--;
		w = !z;
		System.out.print((x+y)+" "+(w ? 5 : 10));
	}
}