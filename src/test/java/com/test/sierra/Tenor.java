package test.java.com.test.sierra;

public class Tenor extends Singer {
	public static String sing() {
		return "fa";
	}

	public static void main(String[] args) {
		System.out.println("ch2 #10: fa la");
		Tenor t = new Tenor();
		Singer s = new Tenor();
		System.out.println(t.sing() + " " + s.sing());
	}
}

class Singer {
	public static String sing() {
		return "la";
	}
}