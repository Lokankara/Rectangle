package test.java.com.test.green;

public class Args {
	static String[] MyArg;

	public static void main(String argv[]) {
		MyArg = argv;
		amethod();
	}

	public static void amethod() {
		System.out.println(MyArg[1]);
	}
}
