package com.homework.threads.airport;

import com.homework.threads.PlaneRunnable;
import java.util.List;

class GateRunner implements Runnable {

    protected final Thread thread;
    private final List<PlaneRunnable> planes;

    public GateRunner(int id, List<PlaneRunnable> planes) {
        super();
        this.planes = planes;
        this.thread = new Thread(this, String.format("Thread#%s", id));
    }

    @Override
    public void run() {
        planes.forEach(GateRunner::lock);
    }

    protected static void lock(PlaneRunnable plane) {
        if (plane.tryLock()) {
            try {
                System.out.println("%s is LOCKED%n".formatted(Thread.currentThread().getName()));
                plane.arrive();
            } finally {
                plane.unlock();
            }
        }
    }
}