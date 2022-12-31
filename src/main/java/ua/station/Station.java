package ua.station;

import java.awt.*;

import static ua.station.Controller.*;

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


        bmw.price(10000);

        bmw.enginePrice(1500);

        double twice = multi(bmw.price(), 1.5);
        System.out.println(twice);

        bmw.price(twice);
        System.out.println(bmw);

        double pow = pow(2, 64);
        System.out.println(pow);

        double div = div(bmw.price(), bmw.enginePrice());
        System.out.println(div);

        double log = log(16);
        System.out.println(log);

        double log10 = log10(16);
        System.out.println(log10);

    }

}