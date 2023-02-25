package main.java.com.homework.threads.lock;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class TripleCounter {
    private static final int poolSize = 3;
    private static final Counter totalSum = new Counter();
    private static final CountDownLatch latch = new CountDownLatch(poolSize);

    public static void main(String[] args) {

        List<Source> wrappers = IntStream.range(0, poolSize).mapToObj(i -> new Source(i, latch, totalSum)).toList();

        List<RunCounter> runners =
                IntStream.range(0, poolSize).mapToObj(id ->
                        new RunCounter(id, wrappers)).toList();

        long start = System.nanoTime();
        runners.forEach(runner -> runner.thread.start());
        long end = System.nanoTime();

        System.out.println((end - start) / 1000);
    }
}

class RunCounter implements Runnable {

    protected final Thread thread;
    private final List<Source> wrappers;

    public RunCounter(int id, List<Source> wrappers) {
        super();
        this.wrappers = wrappers;
        this.thread = new Thread(this, String.format("%s", id));
    }

    @Override
    public void run() {
        wrappers.forEach(RunCounter::count);
    }

    private static void count(Source wrapper) {
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

class Counter {
    private final List<Integer> numbers = new ArrayList<>();
    private final Map<Integer, Long> threads = new HashMap<>();
    private final Map<Long, List<Integer>> threadNumbers = new HashMap<>();

    public synchronized void count(int i) {
        long threadId = Thread.currentThread().getId();
        numbers.add(i);
        threads.put(i, threadId);

        List<Integer> threadList = threadNumbers.get(threadId);
        if (threadList == null) {
            threadList = new ArrayList<>();
            threadNumbers.put(threadId, threadList);
        }
        threadList.add(i);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Set<Long> getThreadIds() {
        return new HashSet<>(threads.values());
    }

    public List<Integer> getNumbersInSameThreadAs(int i) {
        long threadId = threads.get(i);
        return new ArrayList<>(threadNumbers.get(threadId));
    }
}

class Source {
    private final Lock lock;
    private final int id;
    private boolean isRead = false;
    private final CountDownLatch latch;
    private final Counter counter;


    public Source(int id, CountDownLatch latch, Counter totalSum) {
        this.latch = latch;
        this.id = id;
        this.lock = new ReentrantLock();
        this.counter = totalSum;
    }

    void count() {
        if (!isRead) {
            isRead = true;
            counter.count(read());
            System.err.printf("%s, ", counter.getNumbers());
            latch.countDown();
        }
    }

    public int read() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (String.format("%s", i % 3).equals(Thread.currentThread().getName())) {
                sum += i;
            }
        }
        return sum;
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

}

class ThreadedCounter {

    public static void countInThreads(Counter counter) {
        try {
            Field tidField = Thread.class.getDeclaredField("tid");
            tidField.setAccessible(true);
            for (int i = 1; i <= 100; i++) {
                tidField.set(Thread.currentThread(), i % 3);
                counter.count(i);
            }
        } catch (Exception e) {
        }
    }
}