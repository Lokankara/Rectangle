package com.homework.threads;

import com.homework.threads.airport.Family;
import com.homework.threads.airport.Station;
import com.homework.threads.airport.TransportRunnable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class BusRunnable extends TransportRunnable {
    private final int places;
    @Getter
    private final String driveTo;

    public BusRunnable(String city, List<Family> families, int places) {
        super(new ArrayList<>(families));
        this.driveTo = city;
        this.places = places;
        this.thread = new Thread(this, city);
    }

    protected BusRunnable(List<Family> families, int places, String driveTo) {
        super(families);
        this.places = places;
        this.driveTo = driveTo;
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
