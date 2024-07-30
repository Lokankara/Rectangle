package test.java.com.test.sierra;

class Dog {
	public void bark() {
		System.out.print("woof ");
	}
}

class Hound extends Dog {
	public void sniff() {
		System.out.print("sniff ");
	}

	public void bark() {
		System.out.print("howl ");
	}
}

class DogShow {
	public static void main(String[] args) {
		System.out.println("ch2 #8: Compilation fails with an error at line 15");
		
		new DogShow().go();
	}

	void go() {
		new Hound().bark();
		((Dog) new Hound()).bark();
		((Hound) new Hound()).sniff();
	}
}