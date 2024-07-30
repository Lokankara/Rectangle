package test.java.com.test.sierra;

public class Dark {
	int x = 3;

	public static void main(String[] args) {
		System.out.println("#3.13");
		
		new Dark().go1();
	}

	void go1() {
		int x = 3;
		go2(++x);
	}

	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}
}