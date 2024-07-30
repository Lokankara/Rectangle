package com.homework.threads.bakery;

public class BakeryMain {

    public static void main(String[] args) {
        int n = 5;

        Bakery b = new Bakery(n);
        //From example code:
        class Count {
            public volatile int count = 0;
        }
        final Count counter = new Count();

        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                b.lock();
                try {
                    counter.count++;
                } finally {
                    b.unlock();
                }
            }
            System.out.println("thread:" + ThreadID.get() + ", c-value = " + counter.count);
        };

        System.out.println("Bakery Lock algorithm with " + n + " threads...");

        for (int i = 0; i < n; i++) {
            new Thread(r).start();
        }

        System.out.println("Started " + n + " threads...");
    }
}