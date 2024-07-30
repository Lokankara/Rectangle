package com.homework.threads;

import com.homework.threads.airport.Family;
import com.homework.threads.airport.Gate;
import com.homework.threads.airport.TransportRunnable;
import java.util.ArrayList;
import java.util.List;


public class PlaneRunnable extends TransportRunnable {
    private final int id;
    private final Gate gate;

    public PlaneRunnable(int id, List<Family> families) {
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

    public boolean tryLock() {
    }

    public void arrive() {
    }

    public void unlock() {
    }
}
