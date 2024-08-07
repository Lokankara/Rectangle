package com.test.heller.zoo;

import com.test.heller.Animal;

public class Zebra extends Animal {

    Zebra(float weight) {
        super(weight);
    }

    public Zebra() {
        super(200f);
    }


    public static void main(String[] args) {
        Animal a = new Animal(222.2f);
        Zebra z = new Zebra();
        System.out.printf("#37, page 491%n %s%n%s%n", z, a);
    }
}