package test.java.com.test.malaGupta;
class Laptop{
	String memory= "1GB";
}

class Workshop{
	public static void main(String args[]) {
		Laptop life = new Laptop();
		repair(life);
		String memory = life.memory;
		System.out.printf("#ME-Q42: %s", memory);
	}

	private static void repair(Laptop laptop) {
		laptop.memory = "2GB";
	}
}
