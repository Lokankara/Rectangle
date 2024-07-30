package com.ua.lab.classwork.hws;

public class Vehicles {

    public static void main(String[] args) {

        System.out.println();
        OwnerDriver driver = new OwnerDriver("Mike", "N123456", "st. Shevchenko, 49a",
            new Model[] {
                new Model("Opel", "gray", "1,4 l", "mechanic", 1, true),
                new Model("Ford", "cherry", "1,3 l", "auto", 3, false)
            });

        System.out.println(driver);

        // System.out.println("Все автомобили водителя " + driver.name + ": ");
        View.display(driver);

        for (int i = 0; i < driver.cars.length; i++) {
            View.display(driver.cars[i]);
        }

        Model auto = new Model("dark blue", "1,5 l", "mechanic");

        Model car;
        
        for (int i = 0; i < driver.cars.length; i++) {
            if (driver.cars[i].repair) {
                System.out.println(driver.name + " красит " + driver.cars[i].name +
                    " и доливает масло самостоятельно:");
                car = driver.cars[i].repair(auto);
            } else {
                System.out.println(driver.name + " заменяет двигатель " + driver.cars[i].name +
                    " и коробку передач в мастерской:");
                car = AutoServiceController.repair(driver.cars[i], auto);
            }
            View.display(car);
        }
    }
}


class OwnerDriver {
	String name;
  String drivingLicence;
  String address;
  Model[] cars;

  public OwnerDriver(String name, String drivingLicence, String address, Model[] cars) {
      this.name = name;
      this.drivingLicence = drivingLicence;
      this.address = address;
      this.cars = cars;
  }

  @Override
  public String toString() {
      return "Driver{" +
          "name='" + name + '\'' +
          ", drivingLicence='" + drivingLicence + '\'' +
          ", address='" + address + '\'' +
          '}';
  }
}

class AutoServiceController {
  static Model repair(Model car, Model c) {
      car.engine = c.engine;
      car.transmission = c.transmission;
      return car;
  }
}


class View {
  static void display(Model car) {
      System.out.println(car);
  }

  static void display(OwnerDriver driver) {
      System.out.println("Все автомобили водителя " + driver.name + ": ");
  }
}

class Model {

  String name;
  String color;
  String engine;
  String transmission;
  int oil;
  boolean repair;

  public Model(String color, String engine, String transmission) {
      this.color = color;
      this.engine = engine;
      this.transmission = transmission;
  }

  public Model(String name, String color, String engine, String transmission, int oil, boolean repair) {
      this.name = name;
      this.color = color;
      this.engine = engine;
      this.transmission = transmission;
      this.oil = oil;
      this.repair = repair;
  }

  Model repair(Model car) {
      this.color = car.color;
      this.oil++;
      return this;
  }

  @Override
  public String toString() {
      return "Car{" +
          "name='" + name + '\'' +
          ", color='" + color + '\'' +
          ", engine='" + engine + '\'' +
          ", transmission='" + transmission + '\'' +
          ", oil='" + oil + '\'' +
          '}';
  }
}
