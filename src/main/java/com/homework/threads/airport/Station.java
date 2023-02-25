package main.java.com.homework.threads.airport;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Stream;

@Slf4j
class Station implements Runnable {
    private int size;
    private static Station station;

    protected Thread thread = new Thread(this);
    private List<Family> families = new ArrayList<>();

    private final Map<String, List<Bus>> buses = new HashMap<>();
    private Queue<Family> arrivedFamilies = new PriorityBlockingQueue<>(cities.size(), new FamilyComparator());
    private static final List<String> cities = Stream.of(City.values()).map(City::name).toList();
    private static final List<Queue<Family>> tour =
            new ArrayList<>(Arrays.asList(
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator())
            ));

    private Station() {
    }

    public static Station getStation() {
        return Objects.requireNonNullElseGet(station, () -> station = new Station());
    }

    public Station(List<Family> families, int size) {
        this.size = size;
        this.families = families;
    }

    public static void arrive(Bus bus) {
        log.info(bus.toString());
        int town = cities.indexOf(bus.getDriveTo());
        tour.get(town).addAll(bus.getFamilies());
    }

    @Override
    public void run() {
        arrivedFamilies = land();
//        departure(arrivedFamilies);
    }

    public static int departure(List<Family> boardingPassengers, int seat) {
        synchronized (boardingPassengers) {
            Bus bus;
            int place = 0;
            List<Family> sheetRoute = new ArrayList<>();
            while (!boardingPassengers.isEmpty()) {
                Family family = boardingPassengers.remove(0);
                int town = cities.indexOf(family.getTravelTo());
                sheetRoute.add(family);
                place += family.getCount();
                bus = new Bus(cities.get(town), sheetRoute, place);
                System.err.printf("before: members=%s, seats=%s, %s%n", boardingPassengers.size(), seat, bus);
                seat -= place;
                sheetRoute.clear();
            }
        }
        return seat;

//        while (family != null) {
//            town = cities.indexOf(family.getTravelTo());
//            seats[town] += family.getCount();
//            families = towns.get(town);
//            families.add(family);
//            if (seats[town] > 5 && seats[town] < 9) {
//                bus = new Bus(cities.get(town), families, seats[town]);
//                families.clear();
//                seats[town] = 0;
//                buses.add(bus);
////                bus.thread.start();
//            }
//            family = boardingPassengers.poll();
//            if (family == null && seats[town] != 0) {
//                bus = new Bus(cities.get(town), families, 6);
//                buses.add(bus);
////                bus.thread.start();
//            }
//        }
    }

    private Queue<Family> land() {
        int i = size - 1;
        while (i >= 0) {
            Family remove;

            synchronized (families) {
                while (families.isEmpty()) {
                    try {
                        families.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Interrupted while waiting for", e);
                    }
                }
            }
            synchronized (families) {
                if (this.families.size() - size == i) {
                    Collections.reverse(families);
                }

                if (families.size() > i) {
                    remove = families.remove(i);
                    arrivedFamilies.add(remove);
                    i--;
                } else {
                    continue;
                }

                if (this.families.size() == size - 1) {
                    this.families.notifyAll();
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
            log.error(e.getMessage(), e);
        }
    }
}
