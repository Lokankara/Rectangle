package test.java.com.test.boyarsky;
public class Squares{
	public static long square(int x) {
		long y = x*(long) x;
		x=-1;
		return y;
	}
	public static void main(String ... $n) {
		int value = 9;
		long result = square(value);
		System.out.println(value);
		System.out.println(result);
	}
}