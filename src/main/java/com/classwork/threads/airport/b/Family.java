package com.classwork.threads.airport.b;

public class Family {

    private String name; // twoLetters “aa”, “ab”, …, “zz” – for example, up to 40 names
    private String travelTo; // 4 cities – “Kalush”, “Kosiv”, “Galych”, “Kolomiya”
    private int count;

    public Family(String name, String travelTo, int count) {
        this.name = name;
        this.travelTo = travelTo;
        this.count = count;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getTravelTo() {return travelTo;}
    public void setTravelTo(String travelTo) {this.travelTo = travelTo;}

    public int getCount() {return count;}

    @Override
    public String toString() {
        return "Family{" +
                "name='" + name + '\'' +
                ", travelTo='" + travelTo + '\'' +
                ", count=" + count +
                '}';
    }
}