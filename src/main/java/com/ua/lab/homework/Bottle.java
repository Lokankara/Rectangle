//package main.java.com.ua.lab.homework;
//
//import java.util.Comparator;
//
///**
// * @author Pasha
// */
//public class Bottle implements Comparable<Bottle> {
//
//    protected static int referenceCount = 0;
//    private Double volume;
//    private String material;
//    private String drink;
//    private boolean full;
//    //order 1: 0,5; 2: 0.51-0.99; 3: 1.0
//    private int capacity;
//    private int id;
//
//    public Bottle() {
//        setId(++referenceCount);
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(double volume) {
//        this.capacity = volume < 0.5 ? 1 : volume >= 0.5 && volume < 1 ? 2 : 3;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public Double getVolume() {
//        return volume;
//    }
//
//    public void setVolume(Double volume) {
//        this.volume = volume;
//    }
//
//    public String getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public String getDrink() {
//        return drink;
//    }
//
//    public void setLiquid(String liquid) {
//        this.drink = liquid;
//    }
//
//    public boolean isFull() {
//        return full;
//    }
//
//    public void setFull(boolean full) {
//        this.full = full;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Bottle{");
//        stringBuilder.append("id=");
//        stringBuilder.append(id);
//        stringBuilder.append(", volume=");
//        stringBuilder.append(volume);
//        stringBuilder.append(", measure=");
//        stringBuilder.append(capacity);
//        stringBuilder.append(", material='");
//        stringBuilder.append(material);
//        stringBuilder.append('\'');
//        stringBuilder.append(", liquid='");
//        stringBuilder.append(drink);
//        stringBuilder.append('\'');
//        stringBuilder.append(", full=");
//        stringBuilder.append(full);
//        stringBuilder.append('}');
//        return stringBuilder.toString();
//    }
//
//    public void setId(int parseInt) {
//        this.id = parseInt;
//    }
//
//    @Override
//    public int compareTo(Bottle other) {
//        int result = this.drink.compareTo(other.drink) != 0
//                ? this.drink.compareTo(other.drink)
//                : this.material.compareTo(other.material);
//
//        return result != 0 ? result : (this.volume.compareTo(other.volume));
//    }
//
//    public static class SortByVolume implements Comparator<Bottle> {
//        @Override
//        public int compare(Bottle a, Bottle b) {
//            int result = a.getDrink().compareTo(b.getDrink()) != 0
//                    ? a.getDrink().compareTo(b.getDrink())
//                    : a.getMaterial().compareTo(b.getMaterial());
//
//            return result != 0 ? result : a.getVolume().compareTo(b.getVolume());
//        }
//    }
//
//    public static class SortByDrink implements Comparator<Bottle> {
//        @Override
//        public int compare(Bottle a, Bottle b) {
//            int result = a.getMaterial().compareTo(b.getMaterial()) != 0
//                    ? a.getMaterial().compareTo(b.getMaterial())
//                    : a.getVolume().compareTo(b.getVolume());
//            return result != 0 ? result : a.getDrink().compareTo(b.getDrink());
//        }
//    }
//
//    public static class SortByMaterial implements Comparator<Bottle> {
//
//        @Override
//        public int compare(Bottle a, Bottle b) {
//            int result = a.getDrink().compareTo(b.getDrink()) != 0
//                    ? a.getDrink().compareTo(b.getDrink())
//                    : a.getVolume().compareTo(b.getVolume());
//
//            return result != 0 ? result : a.getMaterial().compareTo(b.getMaterial());
//        }
//    }
//}
