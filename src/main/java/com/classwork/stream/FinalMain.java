package com.classwork.stream;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

public class FinalMain {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		calculateAverageWordLength("/");
		long finishTime = System.currentTimeMillis();
		System.out.println("\n time - " + (finishTime - startTime));
	}

	public static void calculateAverageWordLength(String directory) {
		File[] files = new File(directory).listFiles();
		CountDownLatch countDownLatch = new CountDownLatch(Objects.requireNonNull(files).length);
		Arrays.stream(files).forEach(
				file -> new Thread(() -> new AverageLengthCounter(countDownLatch).countAverageWordLengthInFile(file))
						.start());
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		AverageLengthCounter.getResult();
	}
}

class AverageLengthCounter {
	private static final Counter resCounter = new Counter();

	private CountDownLatch countDownLatch;

	public AverageLengthCounter(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void countAverageWordLengthInFile(File file) {
		Counter averageWordLengthInFile = new Counter();
		try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
			br.lines().parallel().map(line -> line.chars().filter(c -> c > 96 && c < 123 || c == 32 || c > 64 && c < 91)
					.collect(new Counter(), Counter::addToCount, (a, b) -> {
					})).forEach(averageWordLengthInFile::merge);

			printInfo(file.getName(), averageWordLengthInFile);

			resCounter.merge(averageWordLengthInFile);
			countDownLatch.countDown();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void printInfo(String fileName, Counter counter) {
		System.out.println("\nfile - " + fileName + "\n" + counter + "\naverage word length - "
				+ (double) counter.getSymbolsCount() / counter.getWordsCount());
	}

	public static void getResult() {
		System.out.println(
				"\naverage word length - " + (double) resCounter.getSymbolsCount() / resCounter.getWordsCount());
	}

}

class Counter implements Supplier<Counter> {
	private int symbolsCount;
	private int wordsCount;
	boolean isNewWord = true;

	public Counter() {
		this.symbolsCount = 0;
		this.wordsCount = 0;
	}

	public int getSymbolsCount() {
		return this.symbolsCount;
	}

	public int getWordsCount() {
		return this.wordsCount;
	}

	public void addToCount(int count) {
		if (count != 32) {
			if (isNewWord) {
				this.wordsCount++;
				this.isNewWord = false;
			}
			this.symbolsCount++;
		} else {
			this.isNewWord = true;
		}
	}

	public synchronized void merge(Counter counter) {
		this.symbolsCount += counter.symbolsCount;
		this.wordsCount += counter.wordsCount;
	}

	@Override
	public String toString() {
		return "symbols = " + symbolsCount + "\nwords = " + wordsCount;
	}

	@Override
	public Counter get() {
		return this;
	}
}