package test.java.com.test.malaGupta;

class Phone {
	 String keyboard = "in-built";
	 boolean playMovie = false;
	 
	void Alert() {
		System.out.println("Call-Phone");
	}
}

class SmartPhone extends Phone {
	void Alert() {
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
		phone.Alert();
		smartPhone.Alert();

		Phone tablet = new Tablet();
		System.out.println(phone.keyboard + ":" + tablet.playMovie);
	}
}