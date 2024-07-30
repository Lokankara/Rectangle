package com.homework.threads.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Trio {

    static class ConcurrentCounter {
        final Counter counter;
        final AtomicInteger currentCount;
        final int stopValue;
        final CountDownLatch countDownLatch;

        ConcurrentCounter(Counter counter, int startValue, int stopValue) {
            this.counter = counter;
            this.currentCount = new AtomicInteger(startValue);
            this.stopValue = stopValue;
            countDownLatch = new CountDownLatch(stopValue - startValue);
        }

        boolean isCompleted() {
            return currentCount.get() == stopValue + 1;
        }

        synchronized void tryIncrement(Predicate<Integer> condition) throws InterruptedException {
            if (condition.test(currentCount.get())) {
                counter.count(currentCount.getAndIncrement());
                countDownLatch.countDown();
                notifyAll();
            }
            wait();
        }

        void await() throws InterruptedException {
            countDownLatch.await();
        }
    }

    static class CounterWorker implements Runnable {

        final ConcurrentCounter concurrentCounter;
        final Predicate<Integer> condition;

        CounterWorker(ConcurrentCounter concurrentCounter, Predicate<Integer> condition) {
            this.concurrentCounter = concurrentCounter;
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                while (!concurrentCounter.isCompleted()) {
                    concurrentCounter.tryIncrement(condition);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void countInThreads (Counter counter){
        ConcurrentCounter concurrentCounter = new ConcurrentCounter(counter, 1, 100);

        new Thread(new CounterWorker(concurrentCounter, i -> i % 3 == 0)).start();
        new Thread(new CounterWorker(concurrentCounter, i -> i % 3 == 1)).start();
        new Thread(new CounterWorker(concurrentCounter, i -> i % 3 == 2)).start();

        try {
            concurrentCounter.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        Counter counter = new Counter();
        countInThreads(counter);
    }
}
