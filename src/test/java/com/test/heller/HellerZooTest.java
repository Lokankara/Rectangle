package com.test.heller;

public class HellerZooTest {
    public static void main(String[] a) {
        Dog rover, fido;
        Animal animal;
        Cat sunflower;
        Washer wa;
        Washer w;
        Swamp pogo;

        sunflower = new Cat();
        wa = sunflower;
//		pogo = (Swamp) wa;

        rover = new Dog();
        animal = rover;
        fido = (Dog) animal;

        Raccoon rocky;
        rocky = new Raccoon();
        w = rocky;
//		pogo = (Swamp) w;
    }
}