package com.thread.airport;

import com.thread.BusRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bus {

    private int passengersCount;
    private String driveTo;
    private List<Family> families;
    private int numberOfSeats;

    public Bus(int passengersCount, String driveTo, List<Family> families, int numberOfSeats) {
        this.passengersCount = passengersCount;
        this.driveTo = driveTo;
        this.families = families;
        this.numberOfSeats = numberOfSeats;
    }

    public void addFamily(Family family) {

        if (!Objects.equals(this.driveTo, family.getTravelTo())) {

            System.err.println("You cannot add family( " + family + "), because they don't fit this bus.");
        } else {
            if (this.numberOfSeats - family.getCount() < 0) {

                System.err.println("You cannot add family( " + family + "), because not enough seats");
            } else {

                this.families.add(family);
            }
        }
    }

    public List<Family> getFamilies() {
        return new ArrayList<>(families);
    }

    public static void join(BusRunnable busRunnable) {
    }
}
