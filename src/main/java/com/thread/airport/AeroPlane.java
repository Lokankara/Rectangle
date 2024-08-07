package com.thread.airport;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AeroPlane {
    private List<Family> families; // exactly 100 family members
    private int id;  // exactly 1, 2, 3
    private final int passageLimit;
    private int numberOfSeatsOccupied;

    public AeroPlane(List<Family> families, int id, int passageLimit, int numberOfSeatsOccupied) {

        this.families = families;
        this.id = id;
        this.passageLimit = passageLimit;
        this.numberOfSeatsOccupied = numberOfSeatsOccupied;
    }

    public AeroPlane(List<Family> families, int id, int passageLimit) {
        this.families = families;
        this.id = id;
        this.passageLimit = passageLimit;
        this.numberOfSeatsOccupied = this.numberOfSeatsOccupied();
    }

    public void addFamily(Family family) {
        if (this.numberOfSeatsOccupied - family.getCount() < 0) {
            System.err.println("You cannot add family( " + family + "), because not enough seats");
        } else {

            this.families.add(family);
        }
    }

    public int numberOfSeatsOccupied() {
        return this.families.stream().
                mapToInt(Family::getCount).
                sum();
    }
}
