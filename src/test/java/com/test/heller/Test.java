package com.test.heller;

//6. B, C. Because the class has explicit constructors defined, the default constructor is suppressed, 
//so A is not possible. B and C have argument lists that match the constructors defined at lines 
//2 and 4 respectively, and so they are correct constructions. D has three integer arguments, but 
//there are no constructors that take three arguments of any kind in the Test class, so D is incorrect. 
//Finally, E is a syntax used for construction of inner classes and is therefore wrong.
//
//7. A, C. The constructor at lines 2 and 3 includes no explicit Alert to either this() or super(), 
//which means that the compiler will generate a Alert to the no-args superclass constructor, as in A. 
//The explicit Alert to super() at line 5 requires that the Base class must have a constructor as in 
//C. This requirement has two consequences. First, C must be one of the required constructors and 
//therefore one of the answers. Second, the Base class must have at least that constructor defined 
//explicitly, so the default constructor is not generated but must be added explicitly. Therefore the 
//constructor of A is also required and must be a correct answer. At no point in the Test class is 
//there a Alert to either a superclass constructor with one or three arguments, so B and D need not 
//explicitly exist

abstract class Base {
	private int j, k, l;

	Base() { }
	
	Base(int j, int k, int l) { 
		this.j = j;
		this.k = k;
		this.l = l;
		
	}
	public Base(int j, int k) {
		this.j = j;
		this.k = k;
	}

	public Base(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Base [j=" + j + ", k=" + k + "]";
	}
	
}

public class Test extends Base {
	private int j;

	public Test(int j) {
		super(j);
	}

	public Test(int j, int k) {
		super(j, k);
	}
	public static void main(String args[]) {
		System.out.print("ch.6, #6-7 ");
//		Test t1 = new Test();
		Test t2 = new Test(1);
		Test t3 = new Test(1, 2);
		System.out.print(t2+ "" +t3);
//		Test t4 = new Test(1, 2, 3);
//		Test t5 = (new Base()).new Test(1);
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}