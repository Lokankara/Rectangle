package main.java.com.ua.station;

import java.awt.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Controller {

    
    protected static double multi(double price, double k) {
        price *= k;
        System.out.println("multi(double price, double k) " + price);
        return price;
    }

    protected static double log(double value) {
        double log = Math.log(value);
        return log;
    }

    protected static double log10(double value) {
        double log = Math.log10(value);
        return log;
    }

    private static boolean strictLog10(double v, double v2) {
        return StrictMath.log10(v) < StrictMath.log(v2);
    }

    protected static double div(double a, double b) {
        if (b != 0) {
            double dived = a / b;
            return dived;
        }
        return 0;
    }

    protected static double pow(double base, double k) {
        return Math.pow(base, k);
    }
}

class AutoServiceStation implements Service<Car> {
    public AutoServiceStation() {
    }

    @Override
    public Car repair(Car car) {

        return setTimer("repair", car, 700);
    }

    @Override
    public Car wash(Car car) {

        return setTimer("wash", car, 500);
    }

    @Override
    public Car paint(Car car, Color color) {

        Car washedCar = wash(car);
        washedCar.setColor(color);

        return setTimer("paint", washedCar, 600);

    }

    @Override
    public Car tireFitting(Car car, Fitting tire) {

        car.setTire(tire);

        return setTimer("fitt", car, 800);
    }

    private static Car setTimer(String command, Car car, int time) {
        Driver carDriver = car.getDriver();
        try {
            carDriver.setActive(true);
            System.out.printf("%sing in progress %n", command);
            Thread.sleep(time);
            car.setFixed(true);
        } catch (InterruptedException e) {
            car.setFixed(false);
        } finally {
            carDriver.setActive(false);
            car.setDriver(carDriver);
        }
        return car;
    }
}