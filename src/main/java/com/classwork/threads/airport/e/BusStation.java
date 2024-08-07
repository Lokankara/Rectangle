package com.classwork.threads.airport.e;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class BusStation {

    private Bus bus;

    private int numberStation;
    private int countPassengersInStation;
    private int x;
    private int y;

    public BusStation(int numberStation, int x, int countPassengersInStation) {
        this.numberStation = numberStation;
        this.x = x;
        this.countPassengersInStation = countPassengersInStation;
    }

    public Bus passengersInStation(int name, int route) {
        log.info("Passenger " + name + " arrived at stop " + getNumberStation() + "; Route " + route);

        boolean flag = true;

        try {
            while (flag) {
                synchronized (this) {
                    this.wait();

                    if (bus.getRoute() == route && bus.getFreePlacesBus() > 0) {
                        bus.addPassenger();

                        this.countPassengersInStation--;

                        flag = false;

                        log.info("The passenger " + name + " got on the bus " + bus.getName() + " Got on the bus stop " + this.getNumberStation());
                    }

                    if (!flag) {
                        return bus;
                    }
                }
            }

        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public void busInStation(Bus bus) {
        synchronized (this) {
            this.bus = bus;

            bus.setStation(this);

            if (bus.getCountPassenger() != 0) {
                bus.notifyAllPassengerInBus();
                bus.waitBus();
            }

            bus.setFlag2(false);

            this.notifyAll();
        }
    }
}
