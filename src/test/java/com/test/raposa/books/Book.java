package test.java.com.test.raposa.books;
  
//    Assessment Test #1
abstract public class Book { 
	private int pageNumber;

	public abstract void read();
	{
//		System.out.println("Reading a Book");
	}

	class InnerBookReader {

		public int getPage() {
			System.out.println(pageNumber);
			return pageNumber;
		}
	}

	public void read(int pageNumber) {
		this.pageNumber = pageNumber;		
	}
}
//The following code appears in a file named Book.java . What is the result of compiling this source file? (Select one answer.)
//    A. The code compiles successfully and one bytecode file is generated: Book.class .
//    B. The code compiles successfully and two bytecode files are generated: Book.class and BookReader.class .
//    C. The code compiles successfully and two bytecode files are generated: Book.class and Book$BookReader.class .
//    D. A compiler error occurs on line 4.
//    E. A compiler error occurs on line 6.
