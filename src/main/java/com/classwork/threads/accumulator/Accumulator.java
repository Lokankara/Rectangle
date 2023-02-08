package com.classwork.threads.accumulator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accumulator {

	private final File file;
	private final String pattern = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";

	public Accumulator(String filename) {
		super();
		this.file = new File(filename);
	}

	void accumulate(SyncAdder sum) {
		Matcher matcher;
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile(pattern).matcher(scanner.next());
				if (matcher.find()) {
					sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
				}
			}
		} catch (IOException e) {
			System.err.printf("%s", e.getMessage());
		} finally {
			System.out.printf("#%s -> %s, total sum: %s %n", Thread.currentThread().getId(), file.getName(), sum.get());
		}
	}

	public void accumulate(DoubleAdder sum, Lock lock) {
		Matcher matcher;
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile(pattern).matcher(scanner.next());
				if (matcher.find()) {
					lock.lock();
					sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
					lock.newCondition().signalAll();
				}
			}
		} catch (IOException e) {
			System.err.printf("%s", e.getMessage());
		} finally {
			lock.unlock();
			System.err.printf("#%s -> %s, total sum: %s %n", Thread.currentThread().getId(), file.getName(), sum);
		}
	}
}