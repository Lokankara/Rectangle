package com.classwork.hws;

public class Main {
    public static void main(String[] args) {
        Auto nissanLeaf = new Auto(true, false, true);
        Auto nissanPixo = new Auto(false, true, true);

        Drive driver = new Drive();
        
        driver.repairBearing(nissanPixo);
        AutoStation.repairChassis(nissanLeaf);
    }
}

class Auto {
    boolean wornBearing;
    boolean brokenChassis;
    boolean flatTire;

    public Auto(boolean wornBearing, boolean brokenChassis, boolean flatTire) {
        this.wornBearing = wornBearing;
        this.brokenChassis = brokenChassis;
        this.flatTire = flatTire;
    }

    public boolean isBrokenChassis() {
        return brokenChassis;
    }

    public boolean isFlatTire() {
        return flatTire;
    }

    public boolean isWornBearing() {
        return wornBearing;
    }
}

class Drive {
	
	public Drive() {}

	void repairBearing(Auto car) {
        car.wornBearing = false;
        System.out.println("wornBearing: " + car.wornBearing);
    }

    void repairChassis(Auto car) {
        car.brokenChassis = false;
        System.out.println("brokenChassis: " + car.brokenChassis);
    }

    void repairTire(Auto car) {
        car.flatTire = false;
        System.out.println("Tire repaired: " + car.flatTire);
    }
}

class AutoStation {
	
	public AutoStation() {};
	
	static void repairBearing(Auto car) {
        car.wornBearing = false;
        System.out.println("wornBearing: " + car.wornBearing);
    }

    static void repairChassis(Auto car) {
        car.brokenChassis = false;
        System.out.println("brokenChassis: " + car.brokenChassis);
    }

    static void repairTire(Auto car) {
        car.flatTire = false;
        System.out.println("Tire repaired: " + car.flatTire);
    }
}