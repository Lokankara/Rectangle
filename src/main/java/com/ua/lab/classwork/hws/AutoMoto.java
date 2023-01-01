package com.ua.lab.classwork.hws;

public class AutoMoto {
    public static void main(String[] args) {
        Trains car1 = new Trains("Audi");
        DriverOwner driver1 = new DriverOwner("Max");
        car1.setOwner(driver1);

        driver1.fixTheTrans();

        StationAuto.fixTheTrans(driver1.getTrans());
    }
}


class Trains {
    private String brand;
    private DriverOwner owner;

    public Trains(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DriverOwner getOwner() {
        return owner;
    }

    public void setOwner(DriverOwner owner) {
        this.owner = owner;
        owner.setTrans(this);
    }
}


class DriverOwner {
    private String name;
    private Trains car;

    public DriverOwner(String name) {
        this.name = name;
    }

    public void fixTheTrans() {
        System.out.println("Driver:");
        System.out.println(name + " himself/herself repaired his/her " + car.getBrand() + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trains getTrans() {
        return car;
    }

    public void setTrans(Trains car) {
        this.car = car;
    }
}


class StationAuto {
    public static void fixTheTrans(Trains car) {
        System.out.println("AutoServiceStation:");
        System.out.printf("AutoServiceStation get %s's %s and started fixing it. \n", car.getOwner().getName(), car.getBrand());
        System.out.println("Repair completed!");
    }
}

