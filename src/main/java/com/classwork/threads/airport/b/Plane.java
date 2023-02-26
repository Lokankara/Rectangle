package com.classwork.threads.airport.b;

import java.util.List;

public class Plane {
    private List<Family> families; // exactly 100 family members
    private int id;  // exactly 1, 2, 3
    private final int passageLimit;
    private int numberOfSeatsOccupied;

    public Plane(List<Family> families, int id, int passageLimit, int numberOfSeatsOccupied) {

        this.families = families;
        this.id = id;
        this.passageLimit = passageLimit;
        this.numberOfSeatsOccupied = numberOfSeatsOccupied;
    }

    public Plane(List<Family> families, int id, int passageLimit) {
        this.families = families;
        this.id = id;
        this.passageLimit = passageLimit;
        this.numberOfSeatsOccupied = this.numberOfSeatsOccupied();
    }

    public void addFamily(Family family){

        if(this.numberOfSeatsOccupied - family.getCount() < 0){

            System.err.println("You cannot add family( " + family + "), because not enough seats");
        }else{

            this.families.add(family);
        }
    }

    public List<Family> getFamilies() {return families;}
    public void setFamilies(List<Family> families) {this.families = families;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getPassageLimit() {return passageLimit;}

    public int getNumberOfSeatsOccupied() {return numberOfSeatsOccupied;}

    public int numberOfSeatsOccupied(){
        return this.families.stream().
                mapToInt(Family::getCount).
                sum();
    }

    @Override
    public String toString() {
        return "Plane{" +
                "families=" + families +
                ", id=" + id +
                ", passageLimit=" + passageLimit +
                '}';
    }
} 