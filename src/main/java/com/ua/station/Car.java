package main.java.com.ua.station;

import java.awt.*;
import java.util.Objects;
import java.util.UUID;

public class Car {

    private Long carId;
    private Driver driver;
    private Fitting tire;
    private Color color;
    boolean isFixed;
    private double price;
    private double enginePrice;
    private double weight;
    private double speed;


    public Car(Driver driver) {
        this.driver = driver;
    }

    public Car(Driver driver, Fitting tire, Color color) {
        this.carId = UUID.randomUUID().getMostSignificantBits() & 0x7fffff;
        this.driver = driver;
        this.tire = tire;
        this.color = color;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Fitting getTire() {
        return tire;
    }

    public void setTire(Fitting tire) {
        this.tire = tire;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public double price() {
        return price;
    }

    public void price(double price) {
        this.price = price;
    }

    public double enginePrice() {
        return enginePrice;
    }

    public void enginePrice(double enginePrice) {
        this.enginePrice = enginePrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isFixed == car.isFixed && Double.compare(car.price, price) == 0 && Double.compare(car.weight, weight) == 0 && Double.compare(car.speed, speed) == 0 && Objects.equals(carId, car.carId) && Objects.equals(driver, car.driver) && tire == car.tire && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, driver, tire, color, isFixed, price, weight, speed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", driver=" + driver +
                ", tire=" + tire +
                ", color=" + color +
                ", isFixed=" + isFixed +
                ", price=" + price +
                ", enginePrice=" + enginePrice +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
