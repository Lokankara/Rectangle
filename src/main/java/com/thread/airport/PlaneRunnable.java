package com.thread.airport;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class PlaneRunnable extends TransportRunnable {
    @Getter
    private final int id;
    private final Gate gate;

    public PlaneRunnable(int id, List<Family> families) {
        super(new ArrayList<>(families));
        this.id = id;
        this.thread = new Thread(this, "Plane#" + id);
        this.gate = Gate.getGate();
    }

    @Override
    public String toString() {
        return "\u001B[36m%s-seat aircraft#%s who arrive at the gate\u001B[m".formatted(getMembers(), id);
    }

    @Override
    public void arrive() {
        gate.arrive(this);
    }
}
