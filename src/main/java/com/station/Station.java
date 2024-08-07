package com.station;

import java.awt.Color;

public class Station {
    private static final AutoServiceStation service = new AutoServiceStation();

    public static void main(String[] args) {

        Driver bob = new Driver("Bob", true);

        Car car = new Car(bob);

        Car bmw = new Car(bob, Fitting.WINTER, Color.DARK_GRAY);

        Car bodyRepair = service.repair(car);

        Car tireFitting = service.tireFitting(bmw, Fitting.SUMMER);

        Car paintedCar = service.paint(bmw, Color.WHITE);

        System.out.println(paintedCar);
        System.out.println(bodyRepair);
        System.out.println(tireFitting);
        System.out.println(car);


        bmw.setPrice(10000);

        bmw.setEnginePrice(1500);

        double twice = Controller.multi(bmw.getPrice(), 1.5);
        System.out.println(twice);

        bmw.setPrice(twice);
        System.out.println(bmw);

        double pow = Controller.pow(2, 64);
        System.out.println(pow);

        double div = Controller.div(bmw.getPrice(), bmw.getEnginePrice());
        System.out.println(div);

        double log = Controller.log(16);
        System.out.println(log);

        double log10 = Controller.log10(16);
        System.out.println(log10);

    }

}