package main.java.com.homework.threads.airport;

import java.util.ArrayList;
import java.util.List;

class Plane extends Transport {
    private final int id;


    public Plane(int id, List<Family> families) {
        super(new ArrayList<>(families));
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\u001B[36m%s-seat aircraft#%s who arrive at the gate\u001B[m"
                .formatted(getMembers(), id);
    }
//
//    @Override
//    public void run() {
//        gate.arrive(this);
//    }
}

class Bus extends Transport {
    private final int places;
    private final String driveTo;

    public Bus(String city, List<Family> families, int places) {
        super(new ArrayList<>(families));
        this.driveTo = city;
        this.places = places;
    }

    public String getDriveTo() {
        return driveTo;
    }

//    @Override
//    public void run() {
//        Station.arrive(this);
//    }

    @Override
    public String toString() {
        return "The %s-bus with %s goes to %s".formatted(places, getFamilies(), driveTo);
    }
}

abstract class Transport {

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
}