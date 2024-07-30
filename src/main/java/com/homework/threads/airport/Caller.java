package com.homework.threads.airport;

import com.homework.threads.PlaneRunnable;
import java.util.concurrent.Callable;

class Caller implements Callable<PlaneRunnable> {
    private final PlaneRunnable plane;

    public Caller(PlaneRunnable plane) {
        this.plane = plane;
    }

    public PlaneRunnable call() {
        return this.plane;
    }
}

class Flight implements Runnable {

    private final PlaneRunnable plane;

    public Flight(PlaneRunnable plane) {
        super();
        this.plane = plane;
    }

    @Override
    public void run() {
//        this.plane.getGate().arrive();
    }
}