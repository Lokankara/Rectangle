package com.test.boyarsky.zoo;

class Marsupial {
	public boolean isBiped() {
		return false;
	}

	public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: " + isBiped());
	}
}