package ua.station;

import java.awt.Color;

public class AutoServiceStation implements Service<Car> {
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
