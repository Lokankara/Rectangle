package com.homework;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
class Bottle implements Comparable<Bottle> {

    protected static int referenceCount = 0;
    private Double volume;
    private String material;
    private String liquid;
    private boolean full;
    //order 1: 0,5; 2: 0.51-0.99; 3: 1.0
    private int capacity;
    private int id;

    public Bottle() {
        setId(++referenceCount);
    }

    public void setCapacity(double volume) {
        this.capacity = volume < 0.5 ? 1 : volume >= 0.5 && volume < 1 ? 2 : 3;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bottle{");
        stringBuilder.append("id=");
        stringBuilder.append(id);
        stringBuilder.append(", volume=");
        stringBuilder.append(volume);
        stringBuilder.append(", measure=");
        stringBuilder.append(capacity);
        stringBuilder.append(", material='");
        stringBuilder.append(material);
        stringBuilder.append('\'');
        stringBuilder.append(", liquid='");
        stringBuilder.append(liquid);
        stringBuilder.append('\'');
        stringBuilder.append(", full=");
        stringBuilder.append(full);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Bottle other) {
        int result = this.liquid.compareTo(other.liquid) != 0
                ? this.liquid.compareTo(other.liquid)
                : this.material.compareTo(other.material);

        return result != 0 ? result : (this.volume.compareTo(other.volume));
    }

    public static class SortByVolume implements Comparator<Bottle> {
        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getLiquid().compareTo(b.getLiquid()) != 0
                    ? a.getLiquid().compareTo(b.getLiquid())
                    : a.getMaterial().compareTo(b.getMaterial());

            return result != 0 ? result : a.getVolume().compareTo(b.getVolume());
        }
    }

    public static class SortByDrink implements Comparator<Bottle> {
        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getMaterial().compareTo(b.getMaterial()) != 0
                    ? a.getMaterial().compareTo(b.getMaterial())
                    : a.getVolume().compareTo(b.getVolume());
            return result != 0 ? result : a.getLiquid().compareTo(b.getLiquid());
        }
    }

    public static class SortByMaterial implements Comparator<Bottle> {

        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getLiquid().compareTo(b.getLiquid()) != 0
                    ? a.getLiquid().compareTo(b.getLiquid())
                    : a.getVolume().compareTo(b.getVolume());

            return result != 0 ? result : a.getMaterial().compareTo(b.getMaterial());
        }
    }
}
