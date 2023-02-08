package com.classwork.packs.b;
import com.classwork.packs.a.A;
public class B extends A {
	public static void main(String[] args) {
	}

	void action(A obj1, B obj2, C obj3) {
pf = 10; // (1)
//obj1.pf = 10; // (2)
obj2.pf = 10; // (3)
obj3.pf = 10; // (4)
}
}
class C extends B {
void action(A obj1, B obj2, C obj3) {
pf = 10; // (5)
//obj1.pf = 10; // (6)
//obj2.pf = 10; // (7)
obj3.pf = 10; // (8)
}
}
class D {
private int pf;

void action(A obj1, B obj2, C obj3) {
setPf(10); // (9)
//obj1.pf = 10; // (10)
//obj2.pf = 10; // (11)
//obj3.pf = 10; // (12)
}

public int getPf() {
	return pf;
}

public void setPf(int pf) {
	this.pf = pf;
}
}
