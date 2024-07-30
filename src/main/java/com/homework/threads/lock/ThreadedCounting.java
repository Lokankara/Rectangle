package com.homework.threads.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadedCounting {
    public static void countInThreads(Counter counter) {

        ExecutorService[] execs = IntStream.range(0, 3).mapToObj(i -> Executors.newFixedThreadPool(1)).toArray(ExecutorService[]::new);

        try {
            for (int i = 1; i <= 100; i++) {
                int n = i;
                Runnable task = () -> counter.count(n);
                execs[n % 3].submit(task).get();
            }

            for (int i = 0; i < 3; i++) {
                execs[i].shutdown();
                execs[i].awaitTermination(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new Error("can't happen", e);
        }
    }
}