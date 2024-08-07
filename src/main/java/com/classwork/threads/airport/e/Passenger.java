package com.classwork.threads.airport.e;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
public class Passenger implements Runnable {

    private int name;
    private int zoneStart;
    private int zoneStop;
    private int route;


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
}
