package com.homework.io.serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Vehicle implements Comparable<Vehicle> {
    public Vehicle() {
    }

    private int speed;
    private int year;
    private Engine engine;

    @Override
    public int compareTo(Vehicle v) {
        return Integer.compare(this.getYear(), v.getYear());
    }
}
