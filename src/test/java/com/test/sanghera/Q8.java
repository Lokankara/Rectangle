package com.test.sanghera;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q8 {
	public static void main(String[] args) throws IOException {
		File inputFile = new File("ship.txt");
		File outputFile = new File("scjpcopy.txt");
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
		String line;
		while ((line = in.readLine()) != null) {
			out.write(line);
			out.newLine();
		}
		in.close();
		out.close();
	}
}
