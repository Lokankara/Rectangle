package com.homework.threads.airport;

import java.util.Comparator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Family implements Comparator<Family> {
    private final int count;
    private final int planeId;
    private final String name;
    private final String travelTo;

    public Family(int count, String name, int plane, String travelTo) {
        this.planeId = plane;
        this.count = count;
        this.name = name;
        this.travelTo = travelTo;
    }

    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }
}

class FamilyComparator implements Comparator<Family> {
    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }
}
