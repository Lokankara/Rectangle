package com.test.sierra;

import java.io.*;

public class ReadingFor {
	private final static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";

	public static void main(String[] args) {

		String s;
		try {
			FileReader fr = new FileReader(path + "matchers.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null)
				System.out.println(s);
//			((Flushable) br).flush();
			br.close();
		} catch (IOException e) {
			System.out.println("io error" + e.getMessage());
		}
	}
}
