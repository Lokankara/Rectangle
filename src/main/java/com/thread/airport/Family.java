package com.thread.airport;

import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Family implements Comparator<Family> {
    private final int count;
    private final int planeId;
    private final String name;
    private final String travelTo;
    private final Lock lock;

    public Family(int count, String name, int plane, String travelTo) {
        this.planeId = plane;
        this.count = count;
        this.name = name;
        this.travelTo = travelTo;
        this.lock = new ReentrantLock();
    }

    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }
}

class FamilyComparator implements Comparator<Family> {
    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }
}
