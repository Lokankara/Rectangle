package com.homework.threads.airport;

import com.homework.threads.PlaneRunnable;
import java.util.concurrent.Callable;

public class Airport {
    public static final int PLANES = 5;
    public static final int AMOUNT = 100;

    public static void main(String[] args) {

        AirportController.producerConsumerMode();
//        Controller.runMultiThread();
//        Controller.runOneSingleThread();
//        Controller.executorMultiMode();
    }
}

class Flyer implements Callable<PlaneRunnable> {
    private final PlaneRunnable plane;

    public Flyer(PlaneRunnable plane) {
        this.plane = plane;
    }

    public PlaneRunnable call() {
        return this.plane;
    }
}
