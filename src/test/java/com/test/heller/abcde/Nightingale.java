package com.test.heller.abcde;

abstract class Bird {
	protected static int referenceCount = 0;

	public Bird() {
		referenceCount++;
	}

	protected void fly() {
		/* Flap wings, etc. */ }

	int getRefCount() {
		return referenceCount;
	}
}

class Parrot extends com.test.heller.abcde.Bird {
	Parrot() {
		referenceCount++;
	}
//	 public void fly() {
//	  }
//	  public int getRefCount() {
//	 return referenceCount;
//	  }
 }
class Nightingale extends com.test.heller.abcde.Bird {
	Nightingale() {
		referenceCount++;
	}

	public static void main(String args[]) {
		System.out.print("Before: " + referenceCount);
		Nightingale florence = new Nightingale();
		System.out.println(" After: " + referenceCount);
		florence.fly();
	}
}
