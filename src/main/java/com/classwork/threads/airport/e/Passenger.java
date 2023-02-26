package com.classwork.threads.airport.e;

import org.apache.log4j.Logger;

public class Passenger implements Runnable {

    private static final Logger log = Logger.getLogger(Passenger.class);

    private int name;
    private int zoneStart;
    private int zoneStop;
    private int route;

    public Passenger() {
    }

    public Passenger(int name, int zoneStart, int zoneStop, int route) {
        log.info("Passenger " + name + " goes to stop " + zoneStart + " wants to get to stop " + zoneStop);

        this.name = name;
        this.zoneStart = zoneStart;
        this.zoneStop = zoneStop;
        this.route = route;
    }

    @Override
    public void run() {
        if (getRoute() == 0) {
            Constants.STATIONS_COUNT_LIST_FIRST_LINE
                    .get(getZoneStart())
                    .passengersInStation(getName(), route)
                    .passengersInBus(getName(), getZoneStop());

        } else {
            Constants.STATIONS_COUNT_LIST_LAST_LINE
                    .get(getZoneStart())
                    .passengersInStation(getName(), route)
                    .passengersInBus(getName(), getZoneStop());
        }
    }

    public int getName() {
        return name;
    }

    public int getZoneStart() {
        return zoneStart;
    }

    public int getZoneStop() {
        return zoneStop;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }
}