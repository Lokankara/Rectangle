package com.classwork.threads.io;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutorTest {
	public static final String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";

	public static void main(String[] args) throws InterruptedException {

		int size = Runtime.getRuntime().availableProcessors();

		String inputFilename = "TODO.md";

		Future<Integer> fi;
		Future<Double> fd;
		Future<Wrap> wrapper;
		long start = System.nanoTime();

		ExecutorService service = Executors.newFixedThreadPool(size);
		fi = service.submit(new Sum(10));
		fd = service.submit(new Hypo(3, 4));
		wrapper = service.submit(new Adder(new Wrap(new File(path + inputFilename))));

		try {
			System.out.println(fi.get());
			System.out.println(fd.get());
			System.out.println(wrapper.get());

		} catch (ExecutionException e) {
			System.err.println(e);
		} finally {
			service.shutdown();

			long end = System.nanoTime();
			System.err.println("shutdown service");
			System.out.println(end - start);
		}
	};
}

class Adder implements Callable<Wrap> {

	private Wrap wrap;

	public Adder(Wrap wrap) {
		super();
		this.wrap = wrap;
	}

	@Override
	public Wrap call() throws Exception {
		return this.wrap.readFile();
	}
}

class Wrap implements Comparable<Wrap> {
	private final String marks = "[`'\"\\+*«»“”„,;:?!….\\-‒—―|~#%@&]";
	private File file;
	private Integer counter;

	public Wrap(File file) {
		this.file = file;
	}

	public Wrap readFile() {
		int count = 0;
		try (Scanner scanner = new Scanner(this.file)) {
			while (scanner.hasNext()) {
				if (Pattern.compile(marks).matcher(scanner.next()).find()) {
					count++;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		counter = (count);
		return this;
	}

	public File getFile() {
		return file;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	@Override
	public int compareTo(Wrap wrap) {
		return Integer.compare(wrap.counter, this.counter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(counter, file);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wrap other = (Wrap) obj;
		return Objects.equals(counter, other.counter) && Objects.equals(file, other.file);
	}

	@Override
	public String toString() {
		return "Wrap [file=" + file.getName() + ", counter=" + counter + "]";
	}
}

class Sum implements Callable<Integer> {
	int max;

	public Sum(int max) {
		super();
		this.max = max;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum = i;
		}
		return sum;
	}
}

class Hypo implements Callable<Double> {
	double a, b;

	public Hypo(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public Double call() throws Exception {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
}