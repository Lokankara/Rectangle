package test.java.com.test.raposa.books;

class NonFictionBook extends Book {
	public void read(int page) {
		System.out.println("Reading a NonFictionBook on page #" + page);
	}

	@Override
	public void read() {
		System.out.println("Reading a NonFictionBook");
	}
}
