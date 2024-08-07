package com.thread.airport;

import java.util.stream.IntStream;

public class AppMain {

    public static final int PLANES = 5;
    public static final int AMOUNT = 100;

    public static void main(String[] args) {
        IntStream.range(1, PLANES + 1)
                .mapToObj(id -> new GateRunner(id, AirportController.buildPlanes(PLANES, AMOUNT)))
                .toList()
                .forEach(runner -> runner.thread.get().start());

//        for (Plane plane : aircraft) {
//            plane.thread.start();
//        }
//        Controller.producerConsumerMode();
//        Controller.runOneSingleThread();
//        Controller.runMultiThread();
//        Controller.executeMultiMode();
    }
}
