package test.java.com.test.heller;

import java.lang.Math;
public class SuperDuper {
	private void aMethod() {
	}
}

class Sub extends SuperDuper {
	protected void aMethod() {

//		Math myMath = new Math();
		System.out.println("cosine of 0.123 = " +
		Math.cos(0.123));
	}
	
}