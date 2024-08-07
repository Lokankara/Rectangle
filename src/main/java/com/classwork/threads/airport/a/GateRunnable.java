package com.classwork.threads.airport.a;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GateRunnable implements Runnable {
    private final String city;
    private List<Family> familiesToCityList;
    private List<Bus> busList = new ArrayList<>();

    public GateRunnable(String city, List<Family> familiesToCity) {
        this.city = city;
        this.familiesToCityList = familiesToCity;
        new Thread(this).start();
    }

    @Override
    public void run() {
        boardingToBus(familiesToCityList);
    }

    private void boardingToBus(List<Family> familiesToCityList) {
        for (Family family : familiesToCityList) {
            if (busList.isEmpty()) {
                busList.add(new Bus(((int) (Math.random() * 3) + 6), city));
            }

            for (Bus bus : busList) {
                if (bus.isBusSuitable(family)) {
                    bus.setPlacesLeft(bus.getPlacesLeft() - family.getMembers());
                    bus.getFamilyList().add(family);
                    family.setFamilyInBus(true);
                    if (bus.getPlacesLeft() == 0) {
//                            new Thread(bus).start();
                        bus.busArrived(); // Если нужно проверить что незаполненый приезжает последним
                        busList.remove(bus);
                    }
                } else {
                    continue; // Чтобы искало пока не найдет подходящий автобус
                }
                break;
            }

            if (!family.getIsFamilyInBus()) { // если не нашло
                family.setFamilyInBus(true);
                Bus newBus = new Bus(((int) (Math.random() * 3) + 6), city);
                busList.add(newBus);
                newBus.setPlacesLeft(newBus.getPlacesLeft() - family.getMembers());
                newBus.getFamilyList().add(family);

            }
        }

        if (!busList.isEmpty()) {
            howManyBusesAreWaiting(busList);
        }
    }

    private void howManyBusesAreWaiting(List<Bus> busList) {

        List<Family> newFamiliesList = new ArrayList<>();
        if (busList.size() > 1) {
            busList.forEach(bus -> newFamiliesList.addAll(bus.getFamilyList()));

        } else {
            busList.forEach(Bus::busArrived);
        }

        if (!newFamiliesList.isEmpty()) {
            busList.clear();
            newFamiliesList.forEach(family -> family.setFamilyInBus(false));
            boardingToBus(newFamiliesList);
        }
    }
}
