package ua.station;

import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Driver {
    private String name;
    private boolean active;
    Set<Car> cars;

    public Driver(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.cars = new HashSet<>();
    }

    protected static double multi(double price, double k) {
        price *= k;
        System.out.println("multi(double price, double k) " + price);
        return price;
    }

    protected static double log(double value) {
        return Math.log(value);
    }

    protected static double log10(double value) {
        return Math.log10(value);
    }

    private static boolean strictLog10(double v, double v2) {
        return StrictMath.log10(v) < StrictMath.log(v2);
    }

    protected static double div(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        return 0;
    }

    protected static double pow(double base, double k) {
        return Math.pow(base, k);
    }
}
