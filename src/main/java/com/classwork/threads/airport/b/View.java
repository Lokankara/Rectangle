package com.classwork.threads.airport.b;

import java.util.List;
import java.util.Map;

public class View {

    public static void viewBus(Bus bus){

        System.out.print("Bus" +
                "\nNumber of passenger : " + bus.getPassengersCount() +
                "\nDrive to : " + bus.getDriveTo() +
                "\nNumberOfSeats : " + bus.getNumberOfSeats() +
                "\nFamilies who are traveling on the bus : " + bus.getFamilies() + "\n");
    }

    public static void viewBusesTo(Map<String, List<Bus>> map, String travelTo){

        System.out.println("\nBuses that go to " + travelTo);
        if(map.get(travelTo) != null){

            map.get(travelTo).forEach(View::viewBus);
        }else {
            System.out.println("No family goes to " + travelTo);
        }
    }
} 