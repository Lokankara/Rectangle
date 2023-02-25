package main.java.com.homework.threads.airport;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class Gate {
    private static Gate gate;
    private static final List<Plane> planes = new ArrayList<>();
    private static final List<Family> arrivedPassengers = new ArrayList<>();
    private static final List<String> cities = Stream.of(City.values()).map(City::name).toList();
    private final int[] seats = new int[cities.size()];

    private static final List<List<Family>> towns =
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()
            ));

    private Gate() {
    }

    public static Gate getGate() {
        return Objects.requireNonNullElseGet(gate, () -> gate = new Gate());
    }

    public void arrive(Plane plane) {

        int town;
        planes.add(plane);
        for (Family family : plane.getFamilies()) {
            town = cities.indexOf(family.getTravelTo());

            towns.get(town).add(family);
            seats[town] += family.getCount();
            if (seats[town] > 8) {
                seats[town] = Station.departure(towns.get(town), seats[town]);
//                System.err.println(seats[town] + " " + towns.get(town));
            }
        }
        log.info(towns.stream().mapToInt(List::size).sum() + " families");

//        arrivedPassengers.addAll(plane.getFamilies());
//        log.info(plane.toString());
    }

    public List<Family> getArrivedPassengers() {
        return arrivedPassengers;
    }

    public List<Plane> getArrivedPlane() {
        return planes;
    }

    public void arrive() {
        log.info("\u001B[32m%s who arrive at the gate#%s%n\u001B[m".formatted(planes, Thread.currentThread().getId()));
    }

    public void arrive(List<Plane> planes) {
        log.info("\u001B[32m%s\u001B[0m%n".formatted(planes.toString()));
    }

    @Override
    public String toString() {
        return "\u001B[32m%s passengers arrived at the Gates%n\u001B[m%s".formatted(
                arrivedPassengers.stream().mapToInt(Family::getCount).sum(),
                planes.stream().map(plane -> plane.getFamilies().toString()).collect(Collectors.joining("\n")));
    }
}