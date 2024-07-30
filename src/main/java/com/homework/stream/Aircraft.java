//package com.homework.stream;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.stream.Collectors;
//
//public class Aircraft {
//    public static void main(String[] args) throws InterruptedException {
//        // Create the shared blocking queue
//        BlockingQueue<Family> queue = new ArrayBlockingQueue<>(100);
//
//        // Create and start the producer thread for each plane
//        List<Producer> producers = new ArrayList<>();
//        for (int i = 1; i <= 3; i++) {
//            producers.add(new Producer(queue, i));
//        }
//        for (Producer producer : producers) {
//            producer.thread.start();
//        }
//
//        // Create and start the consumer thread for each bus
//        List<Consumer> consumers = new ArrayList<>();
//        for (int i = 1; i <= 4; i++) {
//            consumers.add(new Consumer(queue, i));
//        }
//        for (Consumer consumer : consumers) {
//            consumer.thread.start();
//        }
//
//        // Wait for all the producers to finish
//        for (Producer producer : producers) {
//            producer.thread.join();
//        }
//
//        // Stop the consumers when there are no more families to process
//        for (Consumer consumer : consumers) {
//            consumer.stopWhenEmpty();
//        }
//
//        // Wait for all the consumers to finish
//        for (Consumer consumer : consumers) {
//            consumer.join();
//        }
//    }
//}
//
//class Producer implements Runnable {
//    BlockingQueue<Plane> planes;
//    BlockingQueue<Family> families;
//    Thread thread;
//
//    public Producer(BlockingQueue<Plane> planes, BlockingQueue<Family> families) {
//        this.planes = planes;
//        this.families = families;
//        this.thread = new Thread(this);
//    }
//
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            Plane plane = new Plane(i);
//            for (int j = 0; j < 100; j++) {
//                String name = String.format("%02d", j);
//                String travelTo = new String[]{"Kalush", "Kosiv", "Galych", "Kolomiya"}[(int) (Math.random() * 4)];
//                int count = (int) (Math.random() * 4) + 1;
//                Family family = new Family(name, travelTo, count);
//                plane.families.add(family);
//                families.add(family);
//            }
//            try {
//                planes.put(plane);
//                System.out.println("Producer produced a plane.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    BlockingQueue<Plane> planes;
//    BlockingQueue<Bus> buses;
//    List<Family> buffer;
//
//    public Consumer(BlockingQueue<Plane> planes, BlockingQueue<Bus> buses) {
//        this.planes = planes;
//        this.buses = buses;
//        this.buffer = new ArrayList<>();
//    }
//
//    public void run() {
//        while (true) {
//            try {
//                Plane plane = planes.take();
//                for (Family family : plane.families) {
//                    buffer.add(family);
//                }
//                while (!buffer.isEmpty()) {
//                    Family family = buffer.remove(0);
//                    Minibus bus = buses.take();
//                    bus.addFamily(family);
//                    if (bus.families.size() == bus.passengersCount) {
//                        bus.transport();
//                    } else {
//                        buses.put(bus);
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class MinibusCollection {
//    private final int[] capacities;
//    private final String[] destinations;
//    private final List<Minibus> minibuses;
//
//    public MinibusCollection(int[] capacities, String[] destinations) {
//        this.capacities = capacities;
//        this.destinations = destinations;
//        this.minibuses = Arrays.stream(destinations)
//                .flatMap(destination -> Arrays.stream(capacities).mapToObj(capacity -> new Minibus(capacity, destination)))
//                .collect(Collectors.toList());
//    }
//
//    public List<Minibus> getMinibuses() {
//        return minibuses;
//    }
//
//    public List<Minibus> getMinibusesForDestination(String destination) {
//        return minibuses.stream()
//                .filter(minibus -> minibus.getDestination().equals(destination))
//                .collect(Collectors.toList());
//    }
//
//    public String[] getDestinations() {
//        return destinations;
//    }
//}
//
//class Minibus {
//    private final int capacity;
//    private final String destination;
//    final List<Family> families;
//    private int passengersCount;
//
//    public Minibus(int capacity, String destination) {
//        this.capacity = capacity;
//        this.destination = destination;
//        this.families = new ArrayList<>();
//        this.passengersCount = 0;
//    }
//
//    public boolean canAddFamily(Family family) {
//        return passengersCount + family.getCount() <= capacity;
//    }
//
//    public void addFamily(Family family) {
//        families.add(family);
//        passengersCount += family.getCount();
//    }
//
//    public boolean isFull() {
//        return passengersCount == capacity;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//
//    public List<Family> getFamilies() {
//        return families;
//    }
//}
//
//final class Plane {
//    final List<Family> families;
//
//    Plane(List<Family> families) {
//        this.families = families;
//    }
//
//
//    public List<Family> families() {
//        return families;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null || obj.getClass() != this.getClass()) return false;
//        var that = (Plane) obj;
//        return Objects.equals(this.families, that.families);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(families);
//    }
//
//    @Override
//    public String toString() {
//        return "Plane[" +
//                "families=" + families + ']';
//    }
//
//}
//
//class Family {
//    String name;
//    String travelTo;
//    int count;
//
//    public Family(String name, String travelTo, int count) {
//        this.name = name;
//        this.travelTo = travelTo;
//        this.count = count;
//    }
//}
//
//class TransportSystem {
//    private final MinibusCollection minibuses;
//
//    public TransportSystem(MinibusCollection minibuses) {
//        this.minibuses = minibuses;
//    }
//
//    public void assignFamilies(List<Plane> planes) {
//        List<Family> allFamilies = planes.stream()
//                .flatMap(plane -> plane.families().stream())
//                .collect(Collectors.toList());
//
//        List<Family> remainingFamilies = new ArrayList<>(allFamilies);
//        List<Minibus> assignedMinibuses = new ArrayList<>();
//
//        for (String destination : minibuses.getDestinations()) {
//            List<Minibus> destinationMinibuses = minibuses.getMinibusesForDestination(destination);
//
//            for (Minibus minibus : destinationMinibuses) {
//                while (!minibus.isFull() && !remainingFamilies.isEmpty()) {
//                    List<Family> feasibleFamilies = remainingFamilies.stream()
//                            .filter(minibus::canAddFamily)
//                            .collect(Collectors.toList());
//
//                    if (feasibleFamilies.isEmpty()) {
//                        break;
//                    }
//
//                    Family chosenFamily = feasibleFamilies.get(0);
//                    minibus.addFamily(chosenFamily);
//                    remainingFamilies.remove(chosenFamily);
//                }
//
//                assignedMinibuses.add(minibus);
//            }
//        }
//
//        for (Minibus minibus : assignedMinibuses) {
//            System.out.println(minibus);
//        }
//    }
//}