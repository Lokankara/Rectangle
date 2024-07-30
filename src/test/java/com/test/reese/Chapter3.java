package test.java.com.test.reese;

public class Chapter3 {
	private static int i = 35;

	public int c;

	public static void main(String argv[]) {
		int i = 45;

		Chapter3 ch = new Chapter3();
		System.out.println("#3 ch.c = " + ch.c);

		checkMethod();

		express();
	}

	public static void someMethod() {
		System.out.println("#1 private static int i = " + i);
	}

	public static void express() {

		String s1 = "Java";
		String s2 = "java";

		boolean expression;
		expression = s1.equals(s2);
		expression = s1.equalsIgnoreCase(s2);
		expression = s1.matches(s2);
		expression = s1 == s2;
		
		String s = expression ? ("Equal") : ("Not equal");
		System.out.printf("#6 express Java %s%n", s);

	}

	public static void checkMethod() {
//		char d = "d";
//		float f = 3.1415;
		int i = 34;
//		byte b = 257;
		boolean isPresent = true;
		System.out.println("#2 " + i +" "+ isPresent);
	}
}