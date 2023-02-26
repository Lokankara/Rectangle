package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.List;

class Plane extends Transport {
    private final int id;
    private final Gate gate;

    public Plane(int id, List<Family> families) {
        super(new ArrayList<>(families));
        this.id = id;
        this.thread = new Thread(this, "Plane");
        this.gate = Gate.getGate();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\u001B[36m%s-seat aircraft#%s who arrive at the gate\u001B[m".formatted(getMembers(), id);
    }

    @Override
    public void run() {
        gate.arrive(this);
    }
}

class Bus extends Transport {
    private final int places;
    private final String driveTo;

    public Bus(String city, List<Family> families, int places) {
        super(new ArrayList<>(families));
        this.driveTo = city;
        this.places = places;
        this.thread = new Thread(this, city);
    }

    public String getDriveTo() {
        return driveTo;
    }

    @Override
    public void run() {
        Station.arrive(this);
    }

    @Override
    public String toString() {
        return "The %s-bus with %s goes to %s".formatted(places, getFamilies(), driveTo);
    }
}

abstract class Transport implements Runnable {

    protected Thread thread;
    private final List<Family> families;

    protected Transport(List<Family> families) {
        this.families = families;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public int getMembers() {
        return families.stream().mapToInt(Family::getCount).sum();
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
