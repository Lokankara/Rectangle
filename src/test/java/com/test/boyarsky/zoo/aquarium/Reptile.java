package test.java.com.test.boyarsky.zoo.aquarium;

class Reptile {
	public void layEggs() { // - final
		System.out.println("Reptile laying eggs");
	}

	public static void main(String[] args) {
		Reptile reptile = new Lizard();
		reptile.layEggs();
	}

	public String getName() {
		return "Reptile";
	}
}

class Lizard extends Reptile {
	public void layEggs() {
		System.out.println("Lizard laying eggs");
	}
}

class Alligator extends Reptile {
	public String getName() {
		return "Alligator";
	}
}

class Crocodile extends Reptile {
	public String getName() {
		return "Crocodile";
	}
}