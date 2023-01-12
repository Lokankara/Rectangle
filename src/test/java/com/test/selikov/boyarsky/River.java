package com.test.selikov.boyarsky;

public class River {

	public static void main(String[] args) {
	new Rivers().flow();
	}

}


class Rivers {

	public Rivers() {
		 int Amount = 0b11;
//		 int amount = 9L;
		 int amount = 0xE;
//		 int amount = 1_2.0;
//		 double amount = 1_0_.0;
		 int amountb = 0b101;
		 double amountD = 9_2.1_2;
		double amountd = 1_2.0_0;
	}

	float temp = 50.0f;
	int Depth = 1;
	public void flow(){
		int depth = 2;
		depth++;
		temp--;
		System.out.println(temp);
		System.out.println(depth);
		
		
	}
}