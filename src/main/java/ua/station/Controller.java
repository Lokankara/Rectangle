//package main.java.ua.station;
//
//import main.java.com.ua.station.Car;
//
//import java.awt.*;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//public class Controller {
//
//
//    protected static double multi(double price, double k) {
//        price *= k;
//        System.out.println("multi(double price, double k) " + price);
//        return price;
//    }
//
//    protected static double log(double value) {
//        double log = Math.log(value);
//        return log;
//    }
//
//    protected static double log10(double value) {
//        double log = Math.log10(value);
//        return log;
//    }
//
//    private static boolean strictLog10(double v, double v2) {
//        return StrictMath.log10(v) < StrictMath.log(v2);
//    }
//
//    protected static double div(double a, double b) {
//        if (b != 0) {
//            double dived = a / b;
//            return dived;
//        }
//        return 0;
//    }
//
//    protected static double pow(double base, double k) {
//        return Math.pow(base, k);
//    }
//}
//
//enum Fitting {
//    WINTER, DEMI, SUMMER
//}
//
//interface Service<T> {
//
//    T repair(T t);
//
//    T wash(T t);
//
//    T paint(T t, Color color);
//
//    T tireFitting(T t, Fitting tire);
//}
//
//class AutoServiceStation implements Service<Car> {
//    public AutoServiceStation() {
//    }
//
//    @Override
//    public Car repair(Car car) {
//
//        return setTimer("repair", car, 700);
//    }
//
//    @Override
//    public Car wash(Car car) {
//
//        return setTimer("wash", car, 500);
//    }
//
//    @Override
//    public Car paint(Car car, Color color) {
//
//        Car washedCar = wash(car);
//        washedCar.setColor(color);
//
//        return setTimer("paint", washedCar, 600);
//
//    }
//
//    @Override
//    public Car tireFitting(Car car, Fitting tire) {
//
////        car.setTire();
//
//        return setTimer("fit", car, 800);
//    }
//
//    private static Car setTimer(String command, Car car, int time) {
//
//        Driver carDriver = car.getDriver();
//        try {
//            carDriver.setActive(true);
//            System.out.printf("%sing in progress %n", command);
//            Thread.sleep(time);
//            car.setFixed(true);
//        } catch (InterruptedException e) {
//            car.setFixed(false);
//        } finally {
//            carDriver.setActive(false);
//            car.setDriver(carDriver);
//        }
//        return car;
//    }
//}
//
//class Driver {
//    private String name;
//    private boolean active;
//    Set<Car> cars;
//
//    public Driver(String name, boolean active) {
//        this.name = name;
//        this.active = active;
//        this.cars = new HashSet<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Driver driver = (Driver) o;
//        return active == driver.active && Objects.equals(name, driver.name) && Objects.equals(cars, driver.cars);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, active, cars);
//    }
//
//    @Override
//    public String toString() {
//        return "Driver{" +
//                "name='" + name + '\'' +
//                ", active=" + active +
//                '}';
//    }
//}
