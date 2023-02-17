package com.classwork.threads.io.deadlock.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.classwork.threads.io.atomic.AtomicFileReader;

public class ReentrantSync {

	static Result result = new Result();
	private final ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
	private static final AtomicBoolean locked = new AtomicBoolean(false);
	private final Lock lock = new ReentrantLock();
	private final Lock readLock = reentrantLock.readLock();
	private final Lock writeLock = reentrantLock.writeLock();

	public static void main(String[] args) {
		AtomicFileReader reader = new AtomicFileReader(new File("TODO.md"));
		reader.run();
		System.out.println(reader.toString());
		System.out.println("Main thread started (" + Thread.currentThread().getId() + ")");

		List<FileWrapper> listFileNames = new ArrayList<>();
		listFileNames.add(new FileWrapper("f1"));
		listFileNames.add(new FileWrapper("f2"));
		listFileNames.add(new FileWrapper("f3"));

		Controller.treadsStarter(listFileNames);

		System.out.println(result);
		System.out.println("Main thread finished (" + Thread.currentThread().getId() + ")");
	}
}

class Controller {
	static void treadsStarter(List<FileWrapper> fileWrapperList) {

		List<Thread> threads = new ArrayList<>();
		for (FileWrapper file : fileWrapperList) {
			Thread temp = new Thread(new NumberFinder(file));
			threads.add(temp);
			temp.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Result {
	double result;

	synchronized void add(double d) {
		result += d;
	}

	@Override
	public String toString() {
		return "Result = " + this.result;
	}
}

class NumberFinder implements Runnable {
	private final FileWrapper file;

	public FileWrapper getFile() {
		return this.file;
	}

	NumberFinder(FileWrapper file) {
		this.file = file;
	}

	@Override
	public void run() {
		file.sumOfNumbers();
	}
}

class FileWrapper {

	private final String fileName;

	public String getFileName() {
		return this.fileName;
	}

	FileWrapper(String fileName) {
		this.fileName = fileName;
	}

	void sumOfNumbers() {
		long id = Thread.currentThread().getId();
		System.out.println("Start thread (Id " + id + ")");
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				ReentrantSync.result.add(line.split(" ").length);
			}
			System.out.println("Thread number: " + id + " finished.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}