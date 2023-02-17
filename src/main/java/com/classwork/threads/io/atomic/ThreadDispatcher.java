package com.classwork.threads.io.atomic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadDispatcher {
	public static void main(String[] args) {

		final List<String> filenames = new ArrayList<>(Arrays.asList("HELP.md", "README.md", "TODO.md"));

		Runnable task1 = () -> {
			String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
			Matcher matcher;
			DoubleAdder sum = new DoubleAdder();
			Lock lock = new ReentrantLock();

			try (Scanner scanner = new Scanner(new File(filenames.get(0)))) {
				while (scanner.hasNext()) {
					matcher = Pattern.compile(patternNumber).matcher(scanner.next());
					if (matcher.find()) {
						lock.lock();
						sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
					}
				}
			} catch (IOException e) {
				System.err.println(e);
			} finally {
				lock.newCondition().signalAll();
				System.err.printf("File was read by thread #%s, the total sum of number is %s %n",
						Thread.currentThread().getId(), sum);
			}
		};
		
		long start = System.nanoTime();
		new Thread(task1).start();
		new Thread(task1).start();
		new Thread(task1).start();
		long end = System.nanoTime();
		System.out.printf("Locking using atomic concurrent, read time: %d microseconds%n", (end - start) / 1_000);
	}
}

//
//class Controller {
//
//	static void syncStarter(List<Thread> threads) {
//
//		long start = System.nanoTime();
//
//		for (int i = 0; i < threads.size(); i++) {
//			thre ads.get(i).start();
//		}
//		long end = System.nanoTime();
//
//		System.err.printf("Locking using atomic concurrent mode, read time: %d microseconds%n", (end - start) / 1_000);
//	}
//}
//
//class SyncAdder {
//	private double sum;
//
//	synchronized void add(double d) {
//		sum += d;
//	}
//
//	public synchronized double get() {
//		return sum;
//	}
//}
//
//class SyncRunner implements Runnable {
//
//	private final SyncAdder sum;
//	private final SyncAccumulator accumulator;
//
//	SyncRunner(SyncAccumulator file) {
//		this.accumulator = file;
//		this.sum = new SyncAdder();
////      new Thread(this).start();
//	}
//
//	@Override
//	public void run() {
//		accumulator.accumulate(sum);
//	}
//}
//
//class SyncAccumulator {
//	private final String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
//
//	private final File file;
//
//	SyncAccumulator(String fileName) {
//		this.file = (new File(fileName));
//	}
//
//	void accumulate(SyncAdder sum) {
//		Matcher matcher;
//		try (Scanner scanner = new Scanner(file)) {
//			while (scanner.hasNext()) {
//				matcher = Pattern.compile(patternNumber).matcher(scanner.next());
//				if (matcher.find()) {
//					sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
//				}
//			}
//		} catch (IOException | NumberFormatException e) {
//			System.err.println(e);
//		} finally {
//			System.err.printf("File was read by thread #%s, the total sum of number is %s %n",
//					Thread.currentThread().getId(), sum.get());
//		}
//	}
//}


//package com.classwork.threads.io.deadlock;
//
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import com.classwork.threads.io.atomic.AICounter;
//
//public class AtomicRunner implements Runnable{
//	
//	private final Accumulator wrapper;
//	
//	public AtomicRunner(Accumulator wrapper) {
//		super();
//		this.wrapper = wrapper;
//	}
//
//	public AtomicRunner(String filename) {
//		wrapper.set
//	}
//
//	public Accumulator getWrapper() {
//		return wrapper;
//	}
//
//	@Override
//	public void run() {
//		extracted(filename);	
//	}
//
//	private void extracted() {
//		Matcher matcher;
//		try (Scanner scanner = new Scanner(wrapper.getFile())) {
//			while (scanner.hasNext()) {
//				matcher = Pattern.compile("\\d[0-9]{1,13}([,\\.][0-9]{1,5})?").matcher(scanner.next());
//				if (matcher.find()) {
//					wrapper.getLock().lock();
//					AICounter.sum++;
////					AtomicCounter.sum.set(Double.parseDouble(matcher.group().replace(",", ".")));
////					AtomicCounter.getAndAdd(Double.parseDouble(matcher.group().replace(",", ".")));
//				}
//			}
//		} catch (IOException e) {
//			System.out.printf("%s", e.getMessage());
//		} finally {
//			wrapper.getLock().unlock();
//		}
//	}
//}


//package com.classwork.threads.io.atomic;
//
//import java.util.concurrent.atomic.AtomicReference;
//
//public class AtomicReferenceCounter {
//	
//	private final ReentrantLock lock;
//
//	static AtomicReference<Double> sum = new AtomicReference<Double>();
//
//	static double getAndAdd(double delta) {
//		while (true) {
//			Double currentValue = sum.get();
//			Double newValue = Double.valueOf(currentValue.doubleValue() + delta);
//			if (sum.compareAndSet(currentValue, newValue))
//				return currentValue.doubleValue();
//		}
//	}
//}
