package com.homework.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;
import static com.homework.stream.Controller.*;

public class ThreadStream {

	public static void main(String[] args) {
		Controller.init();
		Controller.start();		
	}
}
class Controller {

	public static CountDownLatch countDownLatch;
	public static final List<String> files = new ArrayList<>();
	public static final DoubleAccumulator totalAverage = new DoubleAccumulator(Double::sum, 0);

	public static void init() {
		
		IntStream.range(4000, 4101).forEach(
				n -> files.add("https://www.gutenberg.org/cache/epub/%d/pg%d.txt".formatted(n, n)));

		countDownLatch = new CountDownLatch(files.size());
	}

	public static void start() {
		files.stream()
			.parallel()
			.map(Reader::new)
			.forEach(Thread::new);
	}
}

class Reader implements Runnable {

	private final Thread thread;
	private final String filename;
	private final LongAdder wordCount = new LongAdder();
	private final LongAdder wordLength = new LongAdder();

	public Reader(String file) {
		this.filename = file;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		long start = System.nanoTime();
		getStreamFromUrl().forEach(line -> Pattern.compile("\\b\\w+\\b")
				.matcher(line).results()
				.parallel().forEach(match -> {
					wordLength.add(match.group().length());
					wordCount.increment();
		}));
		
		long end = System.nanoTime();
		
		if(wordCount.doubleValue() != 0) {
			double average = wordLength.doubleValue() / wordCount.doubleValue();
			totalAverage.accumulate(average);
			countDownLatch.countDown();			
			System.out.printf("\u001B[32m%s%n\u001B[0mAverage word length: %.2f%nTotal average length: %.2f%nExecution time: %s milliseconds%n", 
					filename, average, 
					totalAverage.doubleValue() / (files.size() - countDownLatch.getCount()), 
					(end - start) / 1000_000);		
		}
	}

	private Stream<String> getStreamFromUrl() {
		
		InputStream stream = null;
		try {
			URL url = new URL(filename);
			try {
				stream = new GZIPInputStream((url.openStream()));
			} catch (Exception e) {
				stream = url.openStream();
			}
			return new BufferedReader(new InputStreamReader(stream)).lines();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return Stream.empty();
		}
	}
}