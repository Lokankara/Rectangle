package ua.station;

import java.awt.Color;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}
