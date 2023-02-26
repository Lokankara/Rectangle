package com.classwork.threads.airport.b;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Family> families = Controller.createFamily(40);
        List<Plane> planes = Controller.boardingPlanes(families, 40);
        Map<String, List<Bus>> buses = Controller.boardingBuses(planes, true);

        View.viewBusesTo(buses, "Galych");
        View.viewBusesTo(buses, "Kalush");
        View.viewBusesTo(buses, "Kosiv");
        View.viewBusesTo(buses, "Kolomiya");
    }
} 