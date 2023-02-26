package com.classwork.threads.airport.e;

import java.util.Random;

public class BusStop {

    public static void main(String[] args) throws InterruptedException {
        if (Constants.START_MODE <= 1) {
            init();
            startPassenger();
            startBus();

        } else {
            MainFrame.main();
        }
    }

    public static void init() throws InterruptedException {
        createPassenger();
        createStation();
        createBus();
    }

    public static void createPassenger() {
        for (int i = 0; i < Constants.PASSENGERS_COUNT_MAX; i++) {
            Random random = new Random();

            int zoneStart = random.nextInt(Constants.STATIONS_COUNT_MAX);
            int zoneStop = random.nextInt(Constants.STATIONS_COUNT_MAX);

            if (zoneStart == zoneStop) {
                i--;

            } else {
                Constants.livePassengers.incrementAndGet();

                int route;

                if ((zoneStart - zoneStop) < 0) {
                    route = 0;

                } else {
                    route = 1;
                }

                Constants.PASSENGER_COUNT_LIST.add(
                        new Passenger(
                                i,
                                zoneStart,
                                zoneStop,
                                route
                        )
                );
            }
        }
    }

    public static void createStation() {
        int interval = Constants.magicNumber / Constants.STATIONS_COUNT_MAX;

        for (int i = 0; i < Constants.STATIONS_COUNT_MAX; i++) {
            int countPassengersInStationsFirstLine = 0;
            int countPassengersInStationsLastLine = 0;

            for (int j = 0; j < Constants.PASSENGER_COUNT_LIST.size(); j++) {
                if (Constants.PASSENGER_COUNT_LIST.get(j).getZoneStart() == i && Constants.PASSENGER_COUNT_LIST.get(j).getRoute() == 0) {
                    countPassengersInStationsFirstLine++;
                }

                if (Constants.PASSENGER_COUNT_LIST.get(j).getZoneStart() == i && Constants.PASSENGER_COUNT_LIST.get(j).getRoute() == 1) {
                    countPassengersInStationsLastLine++;
                }
            }

            if (i == 0) {
                Constants.STATIONS_COUNT_LIST_FIRST_LINE.add(
                        new BusStation(
                                i,
                                interval,
                                countPassengersInStationsFirstLine
                        )
                );

                Constants.STATIONS_COUNT_LIST_LAST_LINE.add(
                        new BusStation(
                                i,
                                interval,
                                countPassengersInStationsLastLine
                        )
                );

            } else {
                Constants.STATIONS_COUNT_LIST_FIRST_LINE.add(
                        new BusStation(
                                i,
                                Constants.STATIONS_COUNT_LIST_FIRST_LINE.get(i - 1).getX() + interval,
                                countPassengersInStationsFirstLine
                        )
                );

                Constants.STATIONS_COUNT_LIST_LAST_LINE.add(
                        new BusStation(
                                i,
                                Constants.STATIONS_COUNT_LIST_LAST_LINE.get(i - 1).getX() + interval,
                                countPassengersInStationsLastLine
                        )
                );
            }
        }
    }

    public static void createBus() {
        for (int i = 0; i < Constants.BUS_COUNT_MAX; i++) {
            Constants.BUS_COUNT_LIST.add(
                    new Bus(
                        i,
                        Constants.BUS_CAPACITY,
                        0,
                        Constants.BUS_SPEED,
                        true,
                        Util.getRandomBoolean()
                    )
            );
        }
    }

    public static void startPassenger() {
        Thread[] threadsPassenger = new Thread[Constants.PASSENGER_COUNT_LIST.size()];

        for (int i = 0; i < threadsPassenger.length; i++) {
            threadsPassenger[i] = new Thread(Constants.PASSENGER_COUNT_LIST.get(i));
            threadsPassenger[i].start();
        }
    }

    public static void startBus() {
        Thread[] threadsBus = new Thread[Constants.BUS_COUNT_LIST.size()];

        for (int i = 0; i < threadsBus.length; i++) {
            Constants.liveBus.incrementAndGet();

            threadsBus[i] = new Thread(Constants.BUS_COUNT_LIST.get(i));

            try {
                Thread.sleep(Constants.BUS_MOVEMENT_INTERVAL);
                threadsBus[i].start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
