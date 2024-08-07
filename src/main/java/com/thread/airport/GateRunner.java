package com.thread.airport;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class GateRunner implements Runnable {

    protected final AtomicReference<Thread> thread = new AtomicReference<>();
    private final List<PlaneRunnable> planes;

    public GateRunner(int id, List<PlaneRunnable> planes) {
        super();
        this.planes = planes;
        this.thread.set(new Thread(this, String.format("Thread#%s", id)));
    }

    @Override
    public void run() {
        planes.forEach(this::lock);
    }

    protected void lock(PlaneRunnable plane) {
        if (plane.tryLock(thread)) {
            try {
                System.out.printf("%s is LOCKED%n", Thread.currentThread().getName());
                plane.arrive();
                System.out.printf("%s has arrived.%n", thread.get().getName());
            } finally {
                plane.unlock(thread);
            }
        }
    }
}
