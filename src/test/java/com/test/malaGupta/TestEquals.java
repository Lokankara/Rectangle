package com.test.malaGupta;

class Book {
 String ISBN;
 Book(String val) {
 ISBN = val;
 }
}
class TestEquals {
 public static void main(String... args) {
	 System.out.print("ME-Q#46");
 Book b1 = new Book("1234-4657");
 Book b2 = new Book("1234-4657");
 System.out.print(b1.equals(b2) +":");
 System.out.print(b1 == b2);
 }
}