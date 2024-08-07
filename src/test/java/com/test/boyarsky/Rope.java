package com.test.boyarsky;

public class Rope{
	
	 public static int length = 0;
	
	public static void swing() {
		System.out.print("swing ");
	}
	public void climb() {
		System.out.print("climb ");
	}
	
	public static void play() {
		swing();
//		climb();
	}
	
}