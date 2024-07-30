package com.test.malaGupta;

class Phone {
	 String keyboard = "in-built";
	 boolean playMovie = false;
	 
	void call() {
		System.out.println("Call-Phone");
	}
}

class SmartPhone extends Phone {
	void call() {
		System.out.println("Call-SmartPhone");
	}
}

	class Tablet extends Phone {
	 boolean playMovie = false;
	}

class TestPhone {
	public static void main(String[] args) {
		System.out.println("ME Q# ?-63");
		Phone phone = new Phone();
		Phone smartPhone = new SmartPhone();
		phone.call();
		smartPhone.call();

		Phone tablet = new Tablet();
		System.out.println(phone.keyboard + ":" + tablet.playMovie);
	}
}