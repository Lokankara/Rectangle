package com.test.sierra;

public class Wind {
	int id;

	public Wind(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		new Wind(3).go();
//System.out.println(new Wind(3));
	}

	private void go() {
		Wind w1 = new Wind(1);
		Wind w2 = new Wind(2);
		System.out.println(w1.id + " " + w2.id);
	}

}
