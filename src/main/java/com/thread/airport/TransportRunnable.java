package com.thread.airport;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Getter;

public abstract class TransportRunnable implements Runnable {

    protected Thread thread;
    @Getter
    private final List<Family> families;

    protected TransportRunnable(List<Family> families) {
        this.families = families;
    }

    public int getMembers() {
        return families.stream().mapToInt(Family::getCount).sum();
    }

    public abstract void arrive();

    @Override
    public void run() {
        AtomicReference<Thread> currentThread = new AtomicReference<>(Thread.currentThread());
        if (tryLock(currentThread)) {
            try {
                arrive();
            } finally {
                unlock(currentThread);
            }
        }
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

    public boolean tryLock(AtomicReference<Thread> thread) {
        return this.thread.equals(Thread.currentThread()) && thread.compareAndSet(null, Thread.currentThread());
    }

    protected void unlock(AtomicReference<Thread> thread) {
        if (thread.get() == Thread.currentThread()) {
            thread.set(null);
        }
    }
}
