package com.classwork.threads.airport.a;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Plane implements Runnable {
    private final int flightNumber;
    private List<Family> families;

    public Plane(int flightNumber, List<Family> families) {
        this.families = families;
        this.flightNumber = flightNumber;
        new Thread(this).start();
    }

    @Override
    public String toString() {
        return "Plane{" + "families=" + this.families + ", flightNumber=" + this.flightNumber + '}';
    }

    @Override
    public void run() {
        infoAboutPeopleAboard();
    }

    public void infoAboutPeopleAboard() {
        System.out.println(String.format("%d families arrived from aircraft number %d!\n"
                        + "List of visiting families:%s\n", this.families.size(),
                this.flightNumber, this.families));
    }
}

@Setter
class Bus implements Runnable {
    private final String driveTo;
    private final int passengersCount;
    private int placesLeft;
    private List<Family> familyList = new ArrayList<>();

    public Bus(int passengersCount, String driveTo) {
        this.passengersCount = passengersCount;
        this.placesLeft = passengersCount;
        this.driveTo = driveTo;
    }

    public String getDriveTo() {
        return driveTo;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }


    @Override
    public String toString() {
        return "Bus{" + "passengers=" + this.passengersCount + " placeLeft=" + this.placesLeft + ", driveTo='"
                + this.driveTo + '\'' + this.familyList + '}';
    }

    @Override
    public void run() {
        System.out.println(this.passengersCount + " local bus brought "
                + this.familyList.stream().mapToInt(Family::getMembers).sum() + " people to " + this.driveTo
                + this.familyList);
    }

    public void busArrived() {
        System.out.println(this.passengersCount + " local bus brought "
                + this.familyList.stream().mapToInt(Family::getMembers).sum() + " people to " + this.driveTo
                + this.familyList);
    }

    public boolean isBusSuitable(Family family) {
        return this.placesLeft - family.getMembers() > -1;
    }
}
