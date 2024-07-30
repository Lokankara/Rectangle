package com.homework.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TextAnalyzer implements Runnable {
    private final Path[] filePaths;
    private final AtomicLong totalWordCount;
    private final AtomicLong totalWordLength;
    private final Thread thread;

    public TextAnalyzer(Path[] filePaths, AtomicLong totalWordCount, AtomicLong totalWordLength) {
        this.filePaths = filePaths;
        this.totalWordCount = totalWordCount;
        this.totalWordLength = totalWordLength;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        Arrays.stream(filePaths)
                .parallel()
                .forEach(this::processFile);
    }

    private void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }


    private void processFile(Path filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalWordCount.addAndGet(countWords(line));
                totalWordLength.addAndGet(sumWordLengths(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long countWords(String line) {
        return Stream.of(line.split("\\s+"))
                .parallel()
                .count();
    }

    private long sumWordLengths(String line) {
        return Stream.of(line.split("\\s+"))
                .parallel()
                .mapToLong(String::length)
                .sum();
    }

    public static void main(String[] args) {

        Path[] filePaths = {
                Paths.get("file1.txt"),
                Paths.get("file2.txt"),
                Paths.get("file3.txt")
        };

        AtomicLong totalWordCount = new AtomicLong();
        AtomicLong totalWordLength = new AtomicLong();

        List<TextAnalyzer> analyzers = IntStream.range(0, filePaths.length)
                .mapToObj(i -> new TextAnalyzer(filePaths, totalWordCount, totalWordLength)).toList();

        analyzers.forEach(analyzer -> analyzer.thread.start());

        analyzers.forEach(TextAnalyzer::join);

        double averageWordLength = (double) totalWordLength.get() / totalWordCount.get();

        System.out.printf("Average word length: %.2f%n", averageWordLength);
    }
}