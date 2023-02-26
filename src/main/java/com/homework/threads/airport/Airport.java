package com.homework.threads.airport;

import java.util.concurrent.*;

public class Airport {
    public static final int PLANES = 5;
    public static final int AMOUNT = 100;

    public static void main(String[] args) {

        Controller.producerConsumerMode();
//        Controller.runMultiThread();
//        Controller.runOneSingleThread();
//        Controller.executorMultiMode();
    }
}

class Flyer implements Callable<Plane> {
    private final Plane plane;

    public Flyer(Plane plane) {
        this.plane = plane;
    }

    public Plane call() {
        return this.plane;
    }
}

enum City {
    Kalush, Kosiv, Galych, Kolomiya
}