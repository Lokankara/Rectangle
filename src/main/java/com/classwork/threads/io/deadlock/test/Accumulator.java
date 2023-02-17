package com.classwork.threads.io.deadlock.test;
//package com.homework.threads.io.lock;
//
//import java.io.File;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Accumulator {
//
//	private final File file;
//	private static long count;
//	private static final Lock lock = new ReentrantLock();	
//	private static final Condition sufficientFunds = lock.newCondition();
//
////	private final ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
////	private static final AtomicBoolean locked = new AtomicBoolean(false);
////	private final Lock readLock = reentrantLock.readLock();
////	private final Lock writeLock = reentrantLock.writeLock();
//
//	public Accumulator(String filename) {
//		this.file = new File(filename);
//	}
//
//	public void lock() {
//		lock.lock();
//	}
//
//	public void unlock() {
//		lock.unlock();
//	}
//
//	public void signalAll() {
//		sufficientFunds.signalAll();
//	}
////	public void transform() {
////		System.err.println("transform"+ get());
////	}
//
//
//	public File getFile() {
//		return file;
//	}
//
//	public long getCount() {
//		return count;
//	}
//
//	public void setCount(long count) {
//		Accumulator.count = count;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("%nThe are %d spaces%n", count);
//	}
//
//	public void transform(String next) {
//		System.out.printf("%s ", next);
//	}	
//}