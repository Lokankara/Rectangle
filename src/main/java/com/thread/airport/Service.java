package com.thread.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Service {

    static List<Family> passengers = new ArrayList<>();
    protected static List<Plane> aircraft = new ArrayList<>();

    private Service() {
    }

    public static List<Plane> buildPlanes(int planes, int total) {
        aircraft = new ArrayList<>();
        passengers = new ArrayList<>();
        int[] places = getPlaneSeats(planes, total);
        generatePlanes(places);
        System.out.printf("\u001B[35m%s planes contains %s families and %s seats%n\u001B[m", planes,
                aircraft.stream().mapToInt(plane -> plane.getFamilies().size()).sum(),
                passengers.stream().mapToInt(Family::getCount).sum());
        return aircraft;
    }

    static int[] getPlaneSeats(int planes, int all) {
        int[] places = new int[planes];

        int total = all;
        for (int plane = 0; plane < planes - 1; plane++) {
            places[plane] = ThreadLocalRandom.current().nextInt(all / (planes + 2), all / (planes - 1));
            total -= places[plane];
        }
        places[planes - 1] = total;
        return places;
    }

    private static void generatePlanes(int[] places) {
        int sum;
        int amount;
        int count;
        List<Family> families = new ArrayList<>();
        for (int plane = 1; plane <= places.length; plane++) {
            sum = 0;
            amount = places[plane - 1];

            while (sum < amount - 3) {
                count = AirportController.generateMemberFamily();
                sum += count;
                families.add(AirportController.getFamily(count, plane));
            }

            if (sum != amount) {
                families.add(AirportController.getFamily(amount - sum, plane));
            }

            aircraft.add(new Plane(plane, families));
            passengers.addAll(families);
            families.clear();
        }
    }

    private static Family getFamily(int count, int plane) {
        return new Family(count, AirportController.generateName(97, 122, 5), plane, AirportController.generateCity());
    }
}
