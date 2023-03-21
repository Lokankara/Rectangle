package com.test.horstmann.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private List<Bottle> bottles;

    public Service () {
        bottles = new ArrayList<>();
    }

    public void addBottle(Bottle bottle) {
        bottles.add(bottle);
    }

    public List<Bottle> getBottles() {
        return bottles;
    }

    public List<Bottle> getBottlesWithCapacityLessThan(double capacity) {
        return bottles.stream()
                .filter(bottle -> bottle.getVolume() <= capacity)
                .collect(Collectors.toList());
    }

    public List<Bottle> getBottlesWithCapacityBetween(double minCapacity, double maxCapacity) {
        return bottles.stream()
                .filter(bottle -> bottle.getVolume() > minCapacity && bottle.getVolume() < maxCapacity)
                .collect(Collectors.toList());
    }

    public List<Bottle> getBottlesWithCapacityGreaterThanOrEqualTo(double capacity) {
        return bottles.stream()
                .filter(bottle -> bottle.getVolume() >= capacity)
                .collect(Collectors.toList());
    }

    public List<Bottle> getBottlesWithName(String name) {
        return bottles.stream()
                .filter(bottle -> bottle.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Bottle> getBottlesWithMaterial(String material) {
        return bottles.stream()
                .filter(bottle -> bottle.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }
}
