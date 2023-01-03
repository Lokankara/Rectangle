package com.homework.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

	static String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\file.csv";
	static String delimeter = " ";

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File(path));
		scanner.useDelimiter(delimeter);
		List<Bottle> bottles = new ArrayList();
		int i = 0;
		Bottle bottle = new Bottle();

		while (scanner.hasNext()) {
			String data = scanner.next();
			
			if (i%3 == 0) {
				bottles.add(bottle);
				bottle = new Bottle(); 
			}

			if (i%3 == 1) {
				bottle.setLiquid(data); 
			}
			if (i%3 == 2) {
				bottle.setVolume(Double.parseDouble(data));
//				bottle.setMaterial(data); 
			}
			++i;
//			if (data.equals("\n")) {
//				System.out.printf("Enter %s %s %n", i % 4, data);
//			}
//			int d = scanner.nextInt();
//			if (i % 4 == 1) {
//				System.out.printf("%s %s %n", i % 4, data);
//				i++;
//			}
//				System.out.printf("%s %s%n", i % 4, data);
//				 bottle.setLiquid(data);
//			} else if (i % 4 == 2) {
////				;
//				System.out.printf("%s volume %s%n", i % 4, data);
//			} else if (i % 4 == 3) {
//				bottle.setMaterial(data);
//				System.out.printf("%s %s%n", i % 4, data);
//			}
		}
		scanner.close();
		System.out.printf("%s%n", bottles);
	}	
}
