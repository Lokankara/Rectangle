package com.classwork.threads.io.atomic;
//package com.classwork.threads.sync.b;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.atomic.DoubleAccumulator;
//import java.util.concurrent.atomic.DoubleAdder;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.function.DoubleBinaryOperator;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ThreadDispatcher {
//	public static void main(String[] args) {
//
//		final List<String> filenames = new ArrayList<>(Arrays.asList("HELP.md", "README.md", "TODO.md"));
//
//		Runnable task1 = () -> {
//			String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
//			Matcher matcher;
//			DoubleAdder sum = new DoubleAdder();
//			Lock lock = new ReentrantLock();
//
//			try (Scanner scanner = new Scanner(new File(filenames.get(0)))) {
//				while (scanner.hasNext()) {
//					matcher = Pattern.compile(patternNumber).matcher(scanner.next());
//					if (matcher.find()) {
//						lock.lock();
//						sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
//					}
//				}
//			} catch (IOException e) {
//				System.err.println(e);
//			} finally {
//				lock.newCondition().signalAll();
//				System.err.printf("File was read by thread #%s, the total sum of number is %s %n",
//						Thread.currentThread().getId(), sum);
//			}
//		};
//		
//		long start = System.nanoTime();
//		new Thread(task1).start();
//		new Thread(task1).start();
//		new Thread(task1).start();
//		long end = System.nanoTime();
//		System.out.printf("Locking using atomic concurrent, read time: %d microseconds%n", (end - start) / 1_000);
//	}
//}
