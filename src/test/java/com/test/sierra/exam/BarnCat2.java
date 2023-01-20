package com.test.sierra.exam;

class Robot {
}

interface Animal {
}

class Feline implements Animal {
}

public class BarnCat2 extends Feline {
	public static void main(String[] args) {
		Feline ff = new Feline();
		BarnCat2 b = new BarnCat2();
		Animal af = new Feline();
		Robot r = new Robot();
		if (af instanceof Animal)
			System.out.print("1 ");
		if (af instanceof BarnCat2)
			System.out.print("2 ");
		if (b instanceof Animal)
			System.out.print("3 ");
		if (ff instanceof BarnCat2)
			System.out.print("4 ");
		if (r instanceof Animal)
			System.out.print("5 ");

//		if (b instanceof ff)System.out.print("1 ");
//		if(b.instanceof(ff)) System.out.print("2 ");
//		if (b instanceof Feline)
//			System.out.print("3 ");
//		if(b instanceOf Feline) System.out.print("4 ");
//		if(b.instanceof(Feline)) System.out.print("5 ")	
	}
}
