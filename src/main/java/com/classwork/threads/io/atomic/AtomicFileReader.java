package com.classwork.threads.io.atomic;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtomicFileReader {

	private final File file;
	private final DoubleAdder doubleAdder;

	public AtomicFileReader(File file) {
		super();
		this.file = file;
		this.doubleAdder = new DoubleAdder();
	}

	public void run() {
		Matcher matcher;
		try (Scanner scanner = new Scanner(this.file)) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile("\\d[0-9]{1,13}([,\\.][0-9]{1,5})?").matcher(scanner.next());
				if (matcher.find()) {
					doubleAdder.add(Double.parseDouble(matcher.group().replace(",", ".")));
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			System.out.println(this);
		}
	}

	@Override
	public String toString() {
		return String.format("File %s, total sum: %s", file, doubleAdder);
	}
}
