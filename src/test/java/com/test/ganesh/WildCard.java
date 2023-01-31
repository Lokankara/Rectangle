package com.test.ganesh;

class WildCard {
	interface BI {
	}

	interface DI extends BI {
	}

	interface DDI extends DI {
	}

	static class C<T> {
	}

	static void foo(C<? super DI> arg) {
	}

	public static void main(String[] args) {
		foo(new C<BI>()); // ONE
		foo(new C<DI>()); // TWO
//	 foo(new C<DDI>()); // THREE
		foo(new C()); // FOUR
	}
}

class P<T> {
//	static T s_mem;
}

class Q<T> {
	T mem;

	public Q(T arg) {
		mem = arg;
	}
}

class R<T> {
	T mem;

	public R() {
//		mem = new T();
	}
}

class S<T> {
	T[] arr;

	public S() {
//		arr = new T[10];
	}
}