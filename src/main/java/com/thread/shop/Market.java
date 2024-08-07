package com.thread.shop;

import java.util.Objects;

public class Market {
    private int breadCount;

    public Market() {
        this.breadCount = 0;
    }

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.err.printf("#%d %s %d %n", breadCount, Thread.currentThread().getName(), Thread.currentThread().getId());

        notifyAll();
    }

    public synchronized void putBread() {
        while (breadCount > 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.printf("%d %s %d %n", breadCount, Thread.currentThread().getName(), Thread.currentThread().getId());
        notifyAll();
    }

    @Override
    public String toString() {
        return "Market{breadCount=%d}".formatted(breadCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Market market = (Market) o;
        return breadCount == market.breadCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breadCount);
    }
}