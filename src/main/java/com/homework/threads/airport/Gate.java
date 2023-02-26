package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

class Gate {
    private static Gate gate;
    private static final List<Plane> planes = new ArrayList<>();
    private static final Queue<Family> arrivedPassengers = new PriorityBlockingQueue<>(5, new FamilyComparator());

    private Gate() {
    }

    public static Gate getGate() {
        return Objects.requireNonNullElseGet(gate, () -> gate = new Gate());
    }

    public void arrive(Plane plane) {
        planes.add(plane);
        arrivedPassengers.addAll(plane.getFamilies());
        System.out.println(plane);
    }

    public Queue<Family> getArrivedPassengers() {
        return arrivedPassengers;
    }

    public List<Plane> getArrivedPlane() {
        return planes;
    }

    @Override
    public String toString() {
        return "\u001B[32m%s passengers arrived at the Gates%n\u001B[m%s".formatted(arrivedPassengers.stream().mapToInt(Family::getCount).sum(), planes);
    }
}
