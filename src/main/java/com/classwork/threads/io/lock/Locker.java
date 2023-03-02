package com.classwork.threads.io.lock;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locker {

    public static void main(String[] args) {
        int numsCount = Service.countFromFiles(new LockAccumulator(), "file1.txt", "file2.txt", "file3.txt");
        System.out.println("Result using LockCounter : " + numsCount);
    }
}

class Service{

    public static int countFromFiles(Accumulator accumulator, String... fileNames) {
        if (fileNames.length == 0) {
            throw new IllegalArgumentException("At least one file name must be provided!");
        }
        var threadsList = Arrays.stream(fileNames).map(fileName -> 
        new Thread(new NumbersCounterUtil(fileName, accumulator))).toList();

        threadsList.forEach(Thread::start);
        threadsList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return accumulator.get();
    }
}

class LockAccumulator implements Accumulator {
    private int accumulator = 0;
    private final Lock lock = new ReentrantLock();

    @Override
    public void add(int num) {
        try {
            boolean isMessagePrinted = false;
            while (!lock.tryLock()) {
                if (!isMessagePrinted) {
                    System.out.println(Thread.currentThread().getName() + "$LOCKED");
                    isMessagePrinted = true;
                }
            }
            accumulator += num;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int get() {
        try {
            lock.lock();
            return accumulator;
        } finally {
            lock.unlock();
        }
    }

}

class NumbersCounterUtil implements Runnable {
    private final String fileName;
    private final Accumulator accumulator;

    public NumbersCounterUtil(String fileName, Accumulator accumulator) {
        this.fileName = fileName;
        this.accumulator = accumulator;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {

            scanner.useDelimiter("\\D+");
            String currStr;
            while (scanner.hasNext()) {
                currStr = scanner.next();

                var digitsSum = currStr
                        .chars()
                        .map(Character::getNumericValue)
                        .sum();

                accumulator.add(digitsSum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

interface Accumulator {
    void add(int num);
    int get();
}
