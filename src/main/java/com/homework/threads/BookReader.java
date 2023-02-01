package com.homework.threads;

public class BookReader {

	private static String inputFilename = "matrix.txt";
	
	public static void main(String[] args) {
		DirReader.readDir();
		FileReader.readFile(inputFilename);

	}
}
