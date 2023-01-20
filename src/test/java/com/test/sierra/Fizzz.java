package com.test.sierra;

class Fizzz {
	int x = 5;

	@Override
	public String toString() {
		return "Fizzz [x=" + x + "]";
	}

	public static void main(String[] args) {
		System.out.println("#3.5");
		final Fizzz f1 = new Fizzz();
		Fizzz f2 = new Fizzz();
		Fizzz f3 = FizzzSwitch(f1, f2);
		System.out.println((f1 == f3) + " " + (f1.x == f3.x));
		System.out.printf("%s%s%s", f1, f2, f3);
	}

	static Fizzz FizzzSwitch(Fizzz x, Fizzz y) {
		final Fizzz z = x;
		z.x = 6;
		return z;
	}
}