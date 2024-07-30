package com.test.heller;

public class Nightingale extends Bird {

    Nightingale() {
        referenceCount++;
    }

    public static void main(String args[]) {
        System.out.print("Before: " + referenceCount);
        Nightingale florence = new Nightingale();
        System.out.println(" After: " + referenceCount);
        florence.fly();
    }
}

