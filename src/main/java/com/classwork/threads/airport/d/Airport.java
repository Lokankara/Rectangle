package com.classwork.threads.airport.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport {

    public static List<Family> createPassengersList() { //optional service method
        List<Family> passengersList = new ArrayList<>();
        Random r = new Random();
        String name;
        for (Town dest : Town.values()) {
            for (int i = 0; i < 4; i++) {
                name = "" + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a');
                passengersList.add(new Family(name, dest.name(), i + 1));
                name = "" + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a');
                passengersList.add(new Family(name, dest.name(), i + 1));
                if (i == 2 || i == 3) {
                    name = "" + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a');
                    passengersList.add(new Family(name, dest.name(), i));
                }
            }
        }
        return passengersList;
    }

    public static void lastTransfer() {
        System.out.println("Last transfers:");
        for (Town destination : Town.values()) {
            if (destination.getPersonInQueueCount() != 0) {
                System.out.println(destination.name() + " - Person count: " + destination.getPersonInQueueCount()
                        + ", Family count: " + destination.getQueue().size());
            } else {
                System.out.println("there are no passengers for the last transfer to " + destination.name());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Plane> arrivedPlanes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrivedPlanes.add(new Plane(createPassengersList()));
        }

        List<Station> threads = new ArrayList<>();
        for (Plane plane : arrivedPlanes) {
            threads.add(new Station(plane));
        }

        for (Station thread : threads) {
            thread.join();
            System.out.println(thread.getName() + ": " + thread.getTransferMap() + ", total of persons - "
                    + thread.getTransferedPersonsCount());
        }

        lastTransfer();
    }
}