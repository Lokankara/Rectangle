package com.homework.threads.airport;

import java.util.List;

public abstract class TransportRunnable implements Runnable {

    protected Thread thread;
    private final List<Family> families;

    protected TransportRunnable(List<Family> families) {
        this.families = families;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public int getMembers() {
        return families.stream().mapToInt(Family::getCount).sum();
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
