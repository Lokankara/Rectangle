package com.test.boyarsky;

public class RopeSwing {
	private static Rope rope1 = new Rope();
	private static Rope rope2 = new Rope();
	{
		System.out.println(rope1.length);
	}

	public static void main(String[] args) {

		System.out.println("#11 There is exactly one compiler error in the code: public void climb()");
		Rope rope = new Rope();
		rope.play();
		Rope rope2 = null;
		rope2.play();

		System.out.println("#12");

		rope1.length = 2;
		rope2.length = 8;
		System.out.println(rope1.length);
	}
}