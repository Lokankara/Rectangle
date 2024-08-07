package com.thread.airport;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Family> families = Controller.createFamily(40);
        List<AeroPlane> aeroPlanes = Controller.boardingPlanes(families, 40);
        Map<String, List<Bus>> buses = Controller.boardingBuses(aeroPlanes, true);
        View.viewBusesTo(buses, "Galych");
        View.viewBusesTo(buses, "Kalush");
        View.viewBusesTo(buses, "Kosiv");
        View.viewBusesTo(buses, "Kolomiya");
    }
}
