package com.homework.threads.lock;

import java.util.concurrent.CountDownLatch;

public class Triple {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            Triple.count(i);
        }
    }

    private static CountDownLatch latch;

    public Triple() {
        latch = new CountDownLatch(3);
    }

    public static void count(int n) {
        int remainder = n % 3;
        switch (remainder) {
            case 0:
                new Thread(() -> {
                    System.out.println("Thread 1: " + n);
                    latch.countDown();
                }).start();
                break;
            case 1:
                new Thread(() -> {
                    System.out.println("Thread 2: " + n);
                    latch.countDown();
                }).start();
                break;
            case 2:
                new Thread(() -> {
                    System.out.println("Thread 3: " + n);
                    latch.countDown();
                }).start();
                break;
        }
    }

    public void countNumbers() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            count(i);
        }
        latch.await();
    }
}