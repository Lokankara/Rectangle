package com.test.ganesh;

public class ParseString1 {

	public ParseString1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] s) {
		String quote = "Never lend books-nobody ever returns them!";
		String[] words = quote.split(" ", 2);
		// split strings based on the delimiter " " (space)
		for (String word : words) {
			System.out.println(word);
		}
		
//		A. “\+\d{2}-\d{10}”
//		B. “\b\+\d{2}-\d{10}\b”
//		C. “+\d{2}-\d{10}”
//		D. “\b+\d{2}-\d{10}\b”
//		+YY-XXXXXXXXXX
//
//		6. What kind of strings will the regex "\d*[02468]" match?
//				A. Any number containing at least one of the 0, 2, 4, 6, or 8 digits.
//				B. Any number starting from one of the 0, 2, 4, 6, or 8 digits.
//				C. Any number containing all the specified (0, 2, 4, 6, 8) digits at the end of the number.
//				D. Any number ending with one of the specified (0, 2, 4, 6, 8) digits.
		
	}
}
