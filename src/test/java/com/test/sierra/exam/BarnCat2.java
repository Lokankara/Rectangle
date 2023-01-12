package com.test.sierra.exam;

class Feline {
}

public class BarnCat2 extends Feline {
	public static void main(String[] args) {
		Feline ff = new Feline();
		BarnCat2 b = new BarnCat2();
//		if(b instanceof ff) System.out.print("1 ");
//		if(b.instanceof(ff)) System.out.print("2 ");
		if(b instanceof Feline) System.out.print("3 ");
//		if(b instanceOf Feline) System.out.print("4 ");
//		if(b.instanceof(Feline)) System.out.print("5 ")	
	}
}
