package main.java.com.homework.threads.airport;

import java.util.concurrent.Callable;

class Caller implements Callable<Plane> {
    private final Plane plane;

    public Caller(Plane plane) {
        this.plane = plane;
    }

    public Plane call() {
        return this.plane;
    }
}

class Flight implements Runnable {

    private final Plane plane;

    public Flight(Plane plane) {
        super();
        this.plane = plane;
    }

    @Override
    public void run() {
//        this.plane.getGate().arrive();
    }
}