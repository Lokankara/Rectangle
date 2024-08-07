package com.thread.airport;

import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GateWrapperRunner implements Runnable {

	protected final Thread thread;
	private final List<Wrapper> wrappers;

	public GateWrapperRunner(int id, List<Wrapper> wrappers) {
		super();
		this.wrappers = wrappers;
		this.thread = new Thread(this, String.format("Thread#%s", id));
	}

	@Override
	public void run() {
		wrappers.forEach(GateWrapperRunner::accumulate);
	}

	private static void accumulate(Wrapper wrapper) {
		if (wrapper.tryLock()) {
			try {
				System.out.printf("%s is LOCKED%n", Thread.currentThread().getName());
				wrapper.count();
			} finally {
				wrapper.unlock();
			}
		}
	}
}

class Wrapper {
	private final Lock lock;
	private final String filename;
	private boolean isRead = false;
	private final CountDownLatch latch;
	private final DoubleAdder totalSum;

	public Wrapper(String filename, CountDownLatch latch, DoubleAdder totalSum) {
		this.latch = latch;
		this.filename = filename;
		this.totalSum = totalSum;
		this.lock = new ReentrantLock();
	}

	void count() {
		if (!isRead) {
			isRead = true;
			totalSum.add(read());
			latch.countDown();
			System.out.printf("%s", latch.getCount() == 0
					? "\u001B[31mTotal Sum is %.2f %n\u001B[m"
							.formatted(totalSum.doubleValue()) 
					: "");
		}
	}

	public double read() {

		double sum = 0;
		try (BufferedReader reader = 
				new BufferedReader(
						new FileReader(filename))) {
			
			String line;
			Matcher matcher;
			String numberPattern = "\\d[0-9]{1,15}([,.]{1,5})?";
//            String numberPattern = "(\\d+\\.?\\d*)";

			while ((line = reader.readLine()) != null) {
				matcher = Pattern.compile(numberPattern).matcher(line);
				if (matcher.find()) {
					sum += (Double.parseDouble(matcher.group().replace(",", ".")));
				}
			}
		} catch (IOException e) {
			Thread.currentThread().interrupt();
			System.err.println(e.getMessage());
		}
		return sum;
	}

	public void unlock() {
		this.lock.unlock();
	}

	public boolean tryLock() {
		return lock.tryLock();
	}
}

