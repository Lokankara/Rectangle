package com.test.raposa;
//Assessment Test#5
public class Vehicle {
    public boolean used;
    public String make;

    public static void main(String[] args) {

        System.out.println("E. Line 10 generates an exception at runtime.");

        Vehicle v = new Vehicle();
        if (v.used) {
            System.out.println(v.make);
        } else {
            System.out.println(v.make.length());
        }
    }
}