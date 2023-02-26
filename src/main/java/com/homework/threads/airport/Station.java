package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Stream;

class Station implements Runnable {
    private final int size;

    protected Thread thread;
    private final List<Plane> planes;
    private final static List<Bus> buses = new ArrayList<>();
    private Queue<Family> arrivedFamilies;
    private static final List<String> cities = Stream.of(City.values()).map(City::name).toList();
    private static final int[] seats = new int[cities.size()];
    private static final List<List<Family>> towns =
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()
            ));

    private static final List<Queue<Family>> tour =
            new ArrayList<>(Arrays.asList(
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator())
            ));

    public Station(List<Plane> planes, int size) {
        this.size = size;
        this.planes = planes;
        this.thread = new Thread(this);
        arrivedFamilies = new PriorityBlockingQueue<>(cities.size(), new FamilyComparator());
    }

    public static void arrive(Bus bus) {
        System.out.println(bus);
        int town = cities.indexOf(bus.getDriveTo());
        tour.get(town).addAll(bus.getFamilies());
    }


    public static List<Bus> getBuses() {
        return buses;
    }

    @Override
    public void run() {
        arrivedFamilies = land();
        departure(arrivedFamilies);
    }

    public static void departure(Queue<Family> boardingPassengers) {
        int town;
        List<Family> families;
        Bus bus;
        Family family = boardingPassengers.poll();
        while (family != null) {
            town = cities.indexOf(family.getTravelTo());
            seats[town] += family.getCount();
            families = towns.get(town);
            families.add(family);
            if (seats[town] > 5 && seats[town] < 9) {
                bus = new Bus(cities.get(town), families, seats[town]);
                families.clear();
                seats[town] = 0;
                buses.add(bus);
                bus.thread.start();
            }
            family = boardingPassengers.poll();
            if (family == null && seats[town] != 0) {
                bus = new Bus(cities.get(town), families, 6);
                buses.add(bus);
                bus.thread.start();
            }
        }
    }

    private Queue<Family> land() {
        int i = size - 1;
        while (i >= 0) {
            Plane remove;

            synchronized (planes) {
                while (planes.isEmpty()) {
                    try {
                        planes.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println(e.getMessage());
                    }
                }
            }
            synchronized (planes) {
                if (this.planes.size() - size == i) {
                    Collections.reverse(planes);
                }

                if (planes.size() > i) {
                    remove = planes.remove(i);
                    arrivedFamilies.addAll(remove.getFamilies());
                    i--;
                } else {
                    continue;
                }

                if (this.planes.size() == size - 1) {
                    this.planes.notifyAll();
                }
            }
        }
        return arrivedFamilies;
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
