package com.test.sierra;

public abstract interface Flobnicate {
	public void twiddle(String s);
}

abstract class FrobA implements Flobnicate {
	public abstract void twiddle(String s);
}

abstract class FrobB implements Flobnicate {
}

abstract class FrobC implements Flobnicate {
	public void twiddle(Integer i) {
	}
}

abstract class FrobD implements Flobnicate {
	public void twiddle(String i) {
	}
}

abstract class FrobE implements Flobnicate {
	public void twiddle(Integer s) {
	}
}
