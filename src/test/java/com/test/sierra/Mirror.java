package test.java.com.test.sierra;

public class Mirror {
	int size = 7;

	public static void main(String[] args) {
		System.out.println("#3.6");
		Mirror m1 = new Mirror();
		
		Mirror m2 = m1;
		int i1 = 10;
		int i2 = i1;
		go(m2, i2);
		System.out.println(m1.size + " " + i1);
	}

	static void go(Mirror m, int i) {
		m.size = 8;
		i = 12;
	}
}