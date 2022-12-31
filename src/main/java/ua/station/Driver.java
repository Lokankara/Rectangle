//package ua.station;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//public class Driver {
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
//    public void setName(String name) {
//        this.name = name;
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
//                ", cars=" + cars +
//                '}';
//    }
//}
