package com.classwork.threads.io.lock;

import java.util.concurrent.atomic.AtomicBoolean;

class Manager {
    private Resource resource;
    private final AtomicBoolean lock = new AtomicBoolean(false);

    synchronized void transform() {
        while (!lock.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("InterruptedException");
            }
        }
        resource.transform();
        lock.set(false);
        notifyAll();
        
        System.out.printf("The %s of all the words found in file %s have been capitalized by %s-thread #%s%n",
                resource.getCounter() % 2 == 0 ? "first letters" : "last letters",
                resource.getFile().getName(),
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
    }

    synchronized void count(Resource resource) {
        while (lock.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("InterruptedException");
            }
        }
        this.resource = resource;
        resource.count();
        lock.set(true);
        notifyAll();

        System.out.printf("%s spaces found in file %s by %s-thread #%s%n",
                resource.getCounter(),
                resource.getFile().getName(),
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
    }
}