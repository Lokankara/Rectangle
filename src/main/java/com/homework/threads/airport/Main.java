package com.homework.threads.airport;

import com.homework.threads.PlaneRunnable;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static final int PLANES = 5;
    public static final int AMOUNT = 100;

    public static void main(String[] args) {

        List<PlaneRunnable> aircraft = AirportController.buildPlanes(PLANES, AMOUNT);
        List<GateRunner> runners =
                IntStream.range(1, PLANES + 1).mapToObj(id ->
                        new GateRunner(id, aircraft)).toList();
        for (GateRunner runner : runners) {
            runner.thread.start();
        }

//        for (Plane plane : aircraft) {
//            plane.thread.start();
//        }
//        Controller.producerConsumerMode();
//        Controller.runOneSingleThread();
//        Controller.runMultiThread();
//        Controller.executeMultiMode();
    }
}
