package test.java.com.test.raposa;
//Assessment Test#3
public class Hello {
    String greeting = "hi";

    public static void main(String[] args) {
    	Integer j = 5;
		switch (j) {
		case 1:
			System.out.print(1);
			break;
		case 3:
			System.out.print(3);
		case 5:
			System.out.print(5);
		case 7:
			System.out.println(7);
			break;
		default:
			System.out.print("default");
		}
		Boolean m = true;
		int n = 14;

		System.out.print("ch1 #09: ");
		do {
			System.out.print(n);
			n = n >> 1;
			System.out.println(" >> " + n);

			if (n < 4) {
				m = new Boolean(false);
			}
		} while (m);
		System.out.println(n);
		
    	
        Hello h = new Hello();
        h.greeting = null;
        System.gc();
        return;
    }
}