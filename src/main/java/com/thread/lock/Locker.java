package com.thread.lock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Locker {
    private static final String path = "";
    private static final String[] files = {"file1.txt", "file2.txt", "file3.txt"};
    private static final int poolSize = files.length + 5;
    private static final DoubleAdder totalSum = new DoubleAdder();
    private static final CountDownLatch latch = new CountDownLatch(files.length);

    public static void main(String[] args) {

        List<Wrapper> wrappers =
                Arrays.stream(files).map(file ->
                        new Wrapper(path + file, latch, totalSum)).toList();

        List<Runner> runners =
                IntStream.range(1, poolSize + 1).mapToObj(id ->
                        new Runner(id, wrappers)).toList();

        long start = System.nanoTime();
        runners.forEach(runner -> runner.thread.start());
        long end = System.nanoTime();

        System.out.println((end - start) / 1000);
    }
}

class Runner implements Runnable {

    protected final Thread thread;
    private final List<Wrapper> wrappers;

    public Runner(int id, List<Wrapper> wrappers) {
        super();
        this.wrappers = wrappers;
        this.thread = new Thread(this, String.format("Thread#%s", id));
    }

    @Override
    public void run() {
        wrappers.forEach(Runner::lock);
    }

    private static void lock(Wrapper wrapper) {
        if (wrapper.tryLock()) {
            try {
                System.out.printf("%s is LOCKED%n", Thread.currentThread().getName());
                wrapper.count();
            } finally {
                wrapper.unlock();
            }
        }
    }
}

class Wrapper {
    private final Lock lock;
    private final String filename;
    private boolean isRead = false;
    private final CountDownLatch latch;
    private final DoubleAdder totalSum;

    public Wrapper(String filename, CountDownLatch latch, DoubleAdder totalSum) {
        this.latch = latch;
        this.filename = filename;
        this.totalSum = totalSum;
        this.lock = new ReentrantLock();
    }

    void count() {
        if (!isRead) {
            isRead = true;
            totalSum.add(read());
            latch.countDown();
            System.out.println(latch.getCount() == 0
                    ? String.format("%s%n\u001B[31mTotal Sum is %.2f %n\u001B[m", this, totalSum.doubleValue())
                    : String.format("%s", this));
        }
    }

    public double read() {
//        String numberPattern = "(\\d+\\.?\\d*)";
        String numberPattern = "\\d[0-9]{1,19}([,.]{1,5})?";
        double sum = 0;
        Matcher matcher;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                matcher = Pattern.compile(numberPattern).matcher(line);
                if (matcher.find()) {
                    sum += (Double.parseDouble(matcher.group().replace(",", ".")));
                }
            }
        } catch (IOException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
        return sum;
    }

    @Override
    public String toString() {
        return isRead
                ? String.format("The file %s was counted by the %s", filename, Thread.currentThread().getName())
                : String.format("The file %s cannot read by %s", filename, Thread.currentThread().getName());
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }
}

