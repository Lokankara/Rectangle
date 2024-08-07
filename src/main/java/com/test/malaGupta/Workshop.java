package com.test.malaGupta;

class Laptop {
    String memory = "1GB";
}

public class Workshop {

    protected static void repair(Laptop laptop) {
        laptop.memory = "2GB";
    }
}
