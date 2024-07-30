package test.java.com.test.heller;

class Wrapper {
	public int x;
}
public class Tester {
	private static void bump(int n, Wrapper w) {
		n++;
		w.x++;
 }
 public static void main(String[] args) {
	 int n = 10;
	 Wrapper w = new Wrapper();
	 w.x = 10;
	 bump(n, w);
	 System.out.println(String.format("#47, page 491%n%s%n%s", n, w.x));
 }
}