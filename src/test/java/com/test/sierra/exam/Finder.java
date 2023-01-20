package com.test.sierra.exam;

import java.io.File;
import java.io.IOException;

public class Finder {
	public static void main(String[] args) throws IOException {
		String[] files = new String[100];
		File dir = new File("\\..\\users");
		files = dir.list();
		for (String file: files)
		System.out.println(file);
	}
}