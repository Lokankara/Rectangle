package com.homework.inherit;

class Inheritance {
	public static void main(String[] args) {
		VehicleManager manager = new VehicleManager();
		Object create = manager.create();
		System.out.println(create.toString());
		
//		Transport a = new Transport();
//		Factory<Bus> busFactory = new BusFactory();
//		Factory<Auto> autoFactory = new AutoFactory();
//		Vehicle vehicle = busFactory.create();
//		Auto dog = autoFactory.create();
//		System.out.println(dog.toString());

	}
}

 interface Transport {
	void run();
	String info();
}

interface Factory<T> {
	T create();
}

class VehicleManager implements Transport, Factory<Vehicle>{
	
	private Auto auto;

	@Override
	public Auto create() {
		this.auto = new Auto();
		return auto;
	}

	@Override
	public void run() {
		boolean run = auto.isRun();
		auto.s !run ? true : false;
		
	}

	@Override
	public String info() {
		return auto.info();
	}
}



abstract interface VehicleFactory extends Factory<Vehicle> {	
	public default Vehicle create() {
		return new Vehicle();
	}
}

class AutoFactory implements Factory<Auto> {
	public Auto create() {
		return new Auto();
	}
}

class BusFactory implements Factory<Bus> {	
	public Bus create() {
		return new Bus();
	}
}

class TruckFactory implements Factory<Truck> {	
	public Truck create() {
		return new Truck();
	}
}

class Auto extends Vehicle {
	public String info() {
		return this.toString();
	}
	public Auto(int wheels) {
		super(wheels);
	}
	public Auto() {
	}
}

class Bus extends Vehicle {
	public Bus(int wheels) {
		super(wheels);
	}
	public Bus() {
	}
	@Override
	public String toString() {
		return String.format(
				"Bus [wheels=%d, weight=%f, speed=%f, run=%b]", 
				 getWheels(), getWeight(), getSpeed(), isRun());
	}
	
}

class Truck extends Vehicle {
	public Truck(int wheels) {
		super(wheels);
	}

	public Truck() {
	}
}

class Vehicle implements Transport {
	private int wheels;
	private double weight;
	private double speed;
	private boolean run;

	public Vehicle(int wheels) {
		this.wheels = wheels;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
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
	
	public boolean isRun() {
		return run;
	}

	public void run(boolean run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return String.format(
				"Vehicle [wheels=%d, weight=%f, speed=%f, run=%b]", 
				wheels, weight, speed, run);
	}

	public Vehicle() {
		this.wheels = 4;
	}
	
	class Ship implements Transport {
		private double weight;
		private double speed;
		private boolean run;
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
		public boolean isRun() {
			return run;
		}
		public void run(boolean run) {
			this.run = run;
		}
		@Override
		public void run() {
			run = !run ? true : false;
		}
		@Override
		public String info() {
			// TODO Auto-generated method stub
			return null;
		}	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return null;
	}
}
