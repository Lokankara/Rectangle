package com.homework.threads.airport;

import java.util.Comparator;
import java.util.Objects;

class Family implements Comparator<Family> {
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

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getTravelTo() {
        return travelTo;
    }

    @Override
    public String toString() {
        return "%s %s family %s".formatted(count, name, travelTo);
    }

    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return count == family.count && planeId == family.planeId && Objects.equals(name, family.name) && Objects.equals(travelTo, family.travelTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, planeId, name, travelTo);
    }
}

class FamilyComparator implements Comparator<Family> {
    @Override
    public int compare(Family a, Family b) {
        return Integer.compare(b.getCount(), a.getCount());
    }
}
