package com.test.ganesh;

public class TestBase {

}

class Base<T> {
}

class Derived<T> {
}

class Test {
	public static void main(String[] args) {
		Base<Number> b = new Base<Number>();
//	 Base<Number> b = new Derived<Number>();
//	 Base<Number> b = new Derived<Integer>();
//	 Derived<Number> b = new Derived<Integer>();
//	 Base<Integer> b = new Derived<Integer>();
		Derived<Integer> d = new Derived<Integer>();
		 Base<? extends Number> bn = new Base<Number>();
//		 Base<? extends Number> dnb = new Derived<Number>();
//		 Base<? extends Number> dbn = new Derived<Integer>();
		Derived<? extends Number> db = new Derived<Integer>();
//		 Base<?> bb = new Derived<Integer>();
		Derived<?> ddb = new Derived<Integer>();
	}
}
