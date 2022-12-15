package com.test.heller;

class Q6 {
	public static void main(String[] args) {
		System.out.print("ch1: #6 page30: ");
		Holder h = new Holder();
		h.held = 100;
		h.bump(h);
		System.out.print(h.held);
	}
}

class Holder {
	public int held;

	public void bump(Holder theHolder) {
		theHolder.held++;
	}
}