package com.classwork.threads.io.collections.hws;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fedya {
	public static void main(String[] args) {
		Dispatcher.execute();
//		Dispatcher.testPool();
	}
}

class Dispatcher {
	public static void execute() {
		String[] files = { "f1", "f2", "f3" };
		Map<String, Integer> result = Controller.countWordsWithSameBoundariesInFiles(files);
		System.out.println(result);
	}

	public static void testPool() {
		A a = new A();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(() -> {
			System.out.println(Thread.currentThread().getName() + " sleeping started");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			a.m(getString());
			System.out.println(Thread.currentThread().getName() + " finished");
		});
		service.execute(() -> {
			System.out.println(Thread.currentThread().getName() + " started");
			a.m(getString());
			System.out.println(Thread.currentThread().getName() + " finished");
		});
		service.execute(() -> {
			System.out.println(Thread.currentThread().getName() + " started");
			a.m(getString());
			System.out.println(Thread.currentThread().getName() + " finished");
		});
		service.shutdown();
	}

	static String getString() {
		System.out.println(Thread.currentThread().getName() + " getting string");
		return "string";
	}

}

class Controller {
	public static Map<String, Integer> countWordsWithSameBoundariesInFiles(String[] files) {
		Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
		ExecutorService es = Executors.newFixedThreadPool(files.length);
		for (int i = 0; i != files.length; ++i) {
			es.execute(new CounterThread(map, files[i]));
		}
		es.shutdown();
		while (!es.isTerminated()) {
			System.err.println("Wait until all threads are finished");
		}
		return map;
	}
}

class CounterThread extends Thread {
	private Map<String, Integer> map;
	private String fileName;

	public CounterThread(Map<String, Integer> map, String fileName) {
		this.map = map;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			Pattern p = Pattern.compile("\\b([a-zA-z])[a-zA-Z]*\\1\\b");
			Matcher m;
			String line;
			while ((line = br.readLine()) != null) {
				m = p.matcher(line);
				while (m.find()) {
					map.compute(m.group(), (word, count) -> count == null ? 1 : ++count);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

class A {
	synchronized void m(String s) {
		System.out.println(Thread.currentThread().getName() + " in sync method start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(Thread.currentThread().getName() + " in sync method finish");

	}
}
