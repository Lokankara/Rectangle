package com.classwork.threads.airport.b;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private int passengersCount; // 6 or 7 or 8
    private String driveTo;// 4 cities – “Kalush”, “Kosiv”, “Galych”, “Kolomiya”
    private List<Family> families;
    private int numberOfSeats;

    public Bus(int passengersCount, String driveTo, List<Family> families,int numberOfSeats) {
        this.passengersCount = passengersCount;
        this.driveTo = driveTo;
        this.families = families;
        this.numberOfSeats = numberOfSeats;
    }

    public void addFamily(Family family){

        if(this.driveTo != family.getTravelTo() ){

            System.err.println("You cannot add family( " + family + "), because they don't fit this bus.");
        }else{
            if(this.numberOfSeats - family.getCount() < 0){

                System.err.println("You cannot add family( " + family + "), because not enough seats");
            }else {

                this.families.add(family);
            }
        }
    }

    public int getNumberOfSeats() {return numberOfSeats;}

    public List<Family> getFamilies() {return new ArrayList<>(families);}

    public int getPassengersCount() {return passengersCount;}

    public String getDriveTo() {return driveTo;}

    @Override
    public String toString() {
        return "Bus{" +
                "passengersCount=" + passengersCount +
                ", driveTo='" + driveTo + '\'' +
                ", families=" + families +
                '}';
    }
}