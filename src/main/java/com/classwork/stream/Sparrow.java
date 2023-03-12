package com.classwork.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class Sparrow {


    public static void main(String[] args) {
        List<String> fileNames = List.of("file1.txt", "file2.txt", "file3.txt");

        long start = System.currentTimeMillis();

        WordsAccumulator wordsAccumulator = Controller.countFromFiles(fileNames);

        long totalWordsLength = wordsAccumulator.getTotalWordsLength();
        long totalWordsCount = wordsAccumulator.getTotalWordsCount();

        System.out.println("Total words length: " + totalWordsLength);
        System.out.println("Total words: " + totalWordsCount);
        System.out.printf("Average words length: %s", (double) totalWordsLength / totalWordsCount);

        System.out.printf("\nTime passed: %s ms", System.currentTimeMillis() - start);
    }
}

class Controller {
    public static WordsAccumulator countFromFiles(List<String> fileList) {
        if (fileList.isEmpty()) {
            throw new IllegalArgumentException("At least one file name must be provided!");
        }
        WordsAccumulator wordsAccumulator = new WordsAccumulator();

        var threadsList = fileList.stream()
                .map(fileName -> new Thread(new CountWordsUtil(fileName, wordsAccumulator)))
                .toList();

        threadsList.forEach(Thread::start);
        threadsList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return wordsAccumulator;
    }
}

class CountWordsUtil implements Runnable {
    private final String fileName;
    private final WordsAccumulator wordsAccumulator;

    public CountWordsUtil(String fileName, WordsAccumulator wordsAccumulator) {
        this.fileName = fileName;
        this.wordsAccumulator = wordsAccumulator;
    }

    @Override
    public void run() {
        try (Stream<String> lines = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
            lines
                    .parallel()
                    .filter(str -> !str.isBlank())
                    .map(str -> str.split("[\\s,.!(){};=]+"))
                    .flatMap(Arrays::stream)
                    .forEach(word -> {
                        wordsAccumulator.addTotalWordsLength(word.length());
                        wordsAccumulator.incrementTotalWordsCount();
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class WordsAccumulator {
    private final LongAdder totalWordsLength;
    private final LongAdder totalWordsCount;

    public WordsAccumulator() {
        this.totalWordsLength = new LongAdder();
        this.totalWordsCount = new LongAdder();
    }

    public void addTotalWordsLength(long length) {
        totalWordsLength.add(length);
    }

    public void incrementTotalWordsCount() {
        totalWordsCount.increment();
    }

    public long getTotalWordsLength() {
        return totalWordsLength.sum();
    }

    public long getTotalWordsCount() {
        return totalWordsCount.sum();
    }
}
