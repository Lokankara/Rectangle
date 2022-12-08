package com.classwork.hws;

public class Cars {
    public static void main(String[] args) {

        Car reno = new Car("Renault", true);
        Car tesla = new Car("Tesla", false);
        Car mitsubishi = new Car("Mitsubishi", true);

        Driver driver = new Driver("Pavlo");
        driver.repairAuto(reno);

        AutoServiceStation.repairAuto(tesla);
        AutoServiceStation.repairAuto(mitsubishi);
    }
}

class Car {
    private String model;
    protected boolean isBroken;

    public Car(String model, boolean isBroken) {
        this.setModel(model);
        this.isBroken = isBroken;
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

class Driver {
    private String name;

    public Driver(String name) {
        this.setName(name);
    }

    public void repairAuto(Car Auto){
        if(Auto.isBroken){
            System.out.println("Finding a problem and repairing");
            System.out.println("Finally repaired it after spending 3 days in the garage");
        } else{
            System.out.println("Auto isn't broken.");
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class AutoServiceStation {
    public static void repairAuto(Car Auto){
        if(Auto.isBroken){
            System.out.println("Finding a problem and repairing");
            System.out.println("Auto is repaired. Please, pay a bill.");
        } else{
            System.out.println("Auto isn't broken.");
        }
    }
}
