package com.exam.airport;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Plane {
    private final List<Family> families;
    private final int id;
    private final Lock lock;


    public Plane(int id, List<Family> passengers) {
        this.id = id;
        families = passengers;
        this.lock = new ReentrantLock();

    }

    public List<Family> getFamilies() {
        return families;
    }

    public int getMembers() {

        return families.stream().mapToInt(Family::getCount).sum();
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    @Override
    public String toString() {
        return "Plane{families:%s, id:%d, passengers:%s }"
                .formatted(families, id, getMembers());
    }
}
