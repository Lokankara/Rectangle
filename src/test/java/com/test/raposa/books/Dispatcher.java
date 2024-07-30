package test.java.com.test.raposa.books;

public class Dispatcher {

	public Dispatcher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Book nonFictionBook = new NonFictionBook();
		nonFictionBook.read(10);
//		Book book = new Book();
//		Book.InnerBookReader reader = new Book().new InnerBookReader();
//		int page = reader.getPage();
////		Outer.InnerStatic innerStatic = new Outer.InnerStatic();
////		innerStatic.display();
//
//		System.out.println(page);

		System.out.println("Ch#1 Q#9");
//		System.out.println("C. The code compiles successfully " + "and two bytecode files are generated: "
//				+ "Book.class and Book$BookReader.class");

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
	}
}
