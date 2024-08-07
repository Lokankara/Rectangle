package com.thread.airport;

import static com.thread.airport.Airport.AMOUNT;
import static com.thread.airport.Airport.PLANES;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class AirportController {
    static List<Family> passengers = new ArrayList<>();
    protected static List<PlaneRunnable> aircraft = new ArrayList<>();

    private AirportController() {
    }

    public static void producerConsumerMode() {

        List<PlaneRunnable> aircraft = AirportController.buildPlanes(PLANES, AMOUNT);
        List<PlaneRunnable> planes = new ArrayList<>();

        long start = System.nanoTime();
        TerminalRunnable terminalRunnable = new TerminalRunnable(planes, aircraft);
        Station station = new Station(planes, aircraft.size());

        terminalRunnable.thread.start();
        station.thread.start();
        terminalRunnable.join();
        station.join();

        long end = System.nanoTime();
        System.out.printf("\u001B[31mExecution time Producer-Consumer mode %s%n\u001B[m", (end - start) / 1000);

    }

    public static void runOneSingleThread() {
        List<PlaneRunnable> aircraft = buildPlanes(PLANES, AMOUNT);
        long start = System.nanoTime();
        aircraft.forEach(plane -> plane.thread.start());
        aircraft.forEach(PlaneRunnable::join);
        Station station = new Station(Gate.getGate().getArrivedPlane(), PLANES);
        station.thread.start();
        long end = System.nanoTime();

        System.out.printf("\u001B[31mExecution time Single-Thread mode %s%n\u001B[m", (end - start) / 1000);

    }


    public static void runMultiThread() {
        List<PlaneRunnable> aircraft = buildPlanes(PLANES, AMOUNT);

        long start = System.nanoTime();
        aircraft.forEach(plane -> plane.thread.start());

        aircraft.forEach(PlaneRunnable::join);

        Station.departure(Gate.getGate().getArrivedPassengers());
        Station.getBuses().forEach(Bus::join);

        long end = System.nanoTime();
        System.err.printf("Execution time Multi-Thread mode: %s%n", (end - start) / 1000);
    }

    public static void executorMultiMode() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors(),
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        List<PlaneRunnable> aircraft = buildPlanes(PLANES, AMOUNT);
        List<Callable<PlaneRunnable>> planes = new ArrayList<>();
        List<PlaneRunnable> arrivedPlanes = new ArrayList<>();

        for (PlaneRunnable plane : aircraft) {
            planes.add(new Flyer(plane));
        }
        long start = System.nanoTime();

        try {
            for (Future<PlaneRunnable> future : executor.invokeAll(planes)) {
                System.out.println(future.get());
                arrivedPlanes.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
        Station station = new Station(arrivedPlanes, PLANES);
        station.thread.start();
        long end = System.nanoTime();
        System.err.printf("Executor-threaded mode invoke time: %d millis%n", (end - start) / 1_000);
    }

    public static List<PlaneRunnable> buildPlanes(int planes, int total) {
        aircraft = new ArrayList<>();
        passengers = new ArrayList<>();
        int[] places = getPlaneSeats(planes, total);
        generatePlanes(places);
        System.out.printf("\u001B[35m%s planes contains %s families and %s seats%n\u001B[m", planes,
                aircraft.stream().mapToInt(plane -> plane.getFamilies().size()).sum(),
                passengers.stream().mapToInt(Family::getCount).sum());
        return aircraft;
    }

    static int[] getPlaneSeats(int planes, int all) {
        int[] places = new int[planes];

        int total = all;
        for (int plane = 0; plane < planes - 1; plane++) {
            places[plane] = ThreadLocalRandom.current().nextInt(all / (planes + 2), all / (planes - 1));
            total -= places[plane];
        }
        places[planes - 1] = total;
        return places;
    }

    private static void generatePlanes(int[] places) {
        int sum;
        int amount;
        int count;
        List<Family> families = new ArrayList<>();
        for (int plane = 1; plane <= places.length; plane++) {
            sum = 0;
            amount = places[plane - 1];

            while (sum < amount - 3) {
                count = AirportController.generateMemberFamily();
                sum += count;
                families.add(getFamily(count, plane));
            }

            if (sum != amount) {
                families.add(getFamily(amount - sum, plane));
            }

            aircraft.add(new PlaneRunnable(plane, families));
            passengers.addAll(families);
            families.clear();
        }
    }

    public static Family getFamily(int count, int plane) {
        return new Family(count, AirportController.generateName(97, 122, 5), plane, AirportController.generateCity());
    }

    public static Integer generateMemberFamily() {
        return ThreadLocalRandom.current().nextInt(1, 5);
    }

    public static String generateCity() {
        return Stream.of(City.values()).map(City::name).toList().get(ThreadLocalRandom.current().nextInt(0, 4));
    }

    public static String generateName(int min, int max, int length) {
        StringBuilder builder = new StringBuilder();
        builder.append((char) (ThreadLocalRandom.current().nextInt(min, max + 1) - 32));
        for (int i = 0; i < length - 1; i++) {
            builder.append((char) ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return new String(builder);
    }
}
