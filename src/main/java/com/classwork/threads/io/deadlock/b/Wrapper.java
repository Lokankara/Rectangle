package com.classwork.threads.io.deadlock.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Wrapper {

	private File file;
	private boolean wasCalledCounter = false;
	private int count = 0;

	public Wrapper(String filename) {
		this.file = new File(filename);
	}

	public int countSpace() {

		String line;

		synchronized (this) {

			while (wasCalledCounter) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			try (Scanner scannerFile = new Scanner(file);) {
				while (scannerFile.hasNext()) {

					line = scannerFile.nextLine();
					count += line.length() - line.replaceAll(" ", "").length();
				}

				wasCalledCounter = true;
				System.out.printf("Counting name %s, white spaces %s%n", file.getName(), count);

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			notifyAll();
			return this.count;
		}
	}

	public void transform() {

		synchronized (this) {
			while (!wasCalledCounter) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}

			try {

				System.out.println("Refactor name : " + file.getName());

				String text = new String();
				Scanner scannerFile = new Scanner(this.file);
				Scanner scannerLine;
				String tempString;

				while (scannerFile.hasNext()) {

					scannerLine = new Scanner(scannerFile.nextLine());

					while (scannerLine.hasNext()) {
//						System.out.println("transform " + Thread.currentThread().getName() + " " + this.file.getName());

						tempString = scannerLine.next();

						if (this.count % 2 == 0) {
							text += (tempString.substring(0, 1).toUpperCase()
									+ tempString.substring(1, tempString.length()));
						} else {
							text += (tempString.substring(0, tempString.length() - 1)
									+ tempString.substring(tempString.length() - 1, tempString.length()).toUpperCase());
						}

						text += " ";
					}

					wasCalledCounter = false;
					text += "\n";
				}

				FileWriter fileWriter = new FileWriter(this.file);
				fileWriter.write(text);
				fileWriter.flush();
				System.out.println("fileWriter " + Thread.currentThread().getName() + " " + this.file.getName());
				fileWriter.close();
				scannerFile.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}

			notifyAll();
		}
	}

	public File getFile() {
		return file;
	}

	public int getCount() {
		return count;
	}

	public void addToCounterSpace(int counterSpace) {
		synchronized (this) {
			this.count += counterSpace;
		}
	}
}