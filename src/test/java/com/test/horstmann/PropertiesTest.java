package com.test.horstmann;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		var settings = new Properties();

		// the store method to save map list of props to a file
		settings.setProperty("width", "600.0");
		settings.setProperty("filename", "matrix.html");

		var out = new FileOutputStream("props.properties");
		settings.store(out, "Program Properties");
		// To load the properties from a file, use
		
		var in = new FileInputStream("props.properties");
		settings.load(in);
		String userDir = System.getProperty("c://Users//PPoliak");
	
		var defaultSettings = new Properties();
		defaultSettings.setProperty("width", "600");
		defaultSettings.setProperty("height", "400");
		defaultSettings.setProperty("filename", "");
		var setting = new Properties(defaultSettings);
		
	}

}
