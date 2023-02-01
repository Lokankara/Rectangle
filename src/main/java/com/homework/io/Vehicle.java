package com.homework.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

class Vehicle implements Comparable<Vehicle> {
	public Vehicle() {}
	private int speed;
	private int year;
	private Engine engine;

	@Override
	public int compareTo(Vehicle v) {return Integer.compare(this.getYear(), v.getYear());}

	public Vehicle(int year, int speed, Engine engine) {
		super();
		this.speed = speed;
		this.year = year;
		this.engine = engine;
	}
	public int getYear() {return year;}
	public int getSpeed() {return speed;}
	public Engine getEngine() {return engine;}
	public void setYear(int year) {this.year = year;}
	public void setSpeed(int speed) {this.speed = speed;}
	public void setEngine(Engine engine) {this.engine = engine;
	}
	@Override
	public String toString() {
		return String.format("Vehicle [speed=%d, year=%d, %s]", speed, year, engine);
	}
	@Override
	public int hashCode() {return Objects.hash(engine, speed, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(engine, other.engine) && speed == other.speed && year == other.year;
	}
}
class Airplane extends Vehicle implements Serializable {
	private static final long serialVersionUID = 7829136421241571165L;
	private String model;
	private int distance;
	private Chassis chassis;
	public Airplane() {super();}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(getYear());
		out.writeUTF(getModel());
		out.writeInt(getDistance());
		out.writeInt(getSpeed());		
		out.writeInt(getChassis().getWheel().getLoad());
		out.writeInt(getChassis().getWheel().getDiameter());
		out.writeInt(getChassis().getQuantity());
	    out.writeInt(getEngine().getPower());
	    out.writeUTF(getEngine().getType());
	}    
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		setYear(in.readInt());
		setModel(in.readUTF());
		setDistance(in.readInt());
		setSpeed(in.readInt());
		setChassis(new Chassis(new Wheel(in.readInt(), in.readInt()), in.readInt()));
	    setEngine(new Engine(in.readInt(), in.readUTF()));
	}
	public Airplane(int year, int speed, Engine engine, String model, int distance, Chassis chassis) {
		super(year, speed, engine);
		this.model = model;
		this.distance = distance;
		this.chassis = chassis;
	}
	public String getModel() {return model;}
	public int getDistance() {return distance;}
	public Chassis getChassis() {return chassis;}
	public void setModel(String model) {this.model = model;}
	public void setDistance(int distance) {this.distance = distance;}
	public void setChassis(Chassis chassis) {this.chassis = chassis;
	}
	@Override
	public String toString() {
		return String.format("Airplane [year=%d, model=%s, distance=%d, speed=%d, %s, %s]",
				getYear(), model, distance, getSpeed(), chassis, getEngine());
	}
	@Override
	public int hashCode() {return 31 * super.hashCode() + Objects.hash(chassis, distance, model);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(chassis, other.chassis) && distance == other.distance && Objects.equals(model, other.model);
	}
}
class Ship extends Vehicle implements Externalizable {
	private static final long serialVersionUID = -18982551340645L;
	private double length;
	private int capacity;
	private Boat boat;
	public Ship() {super();}	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getYear());
		out.writeInt(getSpeed());
		out.writeInt(getCapacity());
	    out.writeDouble(getLength());
	    out.writeInt(getBoat().getPlace());
	    out.writeUTF(getBoat().getMaterial());	    
	    out.writeInt(getEngine().getPower());
	    out.writeUTF(getEngine().getType());    
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 setYear(in.readInt());
		 setSpeed(in.readInt());
		 setCapacity(in.readInt());
	     setLength(in.readDouble());
	     setBoat(new Boat(in.readInt(), in.readUTF()));
	     setEngine(new Engine(in.readInt(), in.readUTF()));
	}
	public Ship(int year, int speed, Engine engine, double length, int capacity, Boat boat) {
		super(year, speed, engine);
		this.length = length;
		this.capacity = capacity;
		this.boat = boat;
	}
	public double getLength() {return length;}
	public int getCapacity() {return capacity;}
	public void setLength(double length) {this.length = length;}
	public void setCapacity(int capacity) {this.capacity = capacity;}
	public Boat getBoat() {return boat;}
	public void setBoat(Boat boat) {this.boat = boat;
	}
	@Override
	public String toString() {
		return String.format("Ship [year=%d, length=%.2f, capacity=%d, speed=%d, %s, %s]", 
				getYear(), length, capacity, getSpeed(), boat, getEngine());
	}
	@Override
	public int hashCode() {return Objects.hash(boat, capacity, length);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Ship other = (Ship) obj;
		return Objects.equals(boat, other.boat) && capacity == other.capacity && length == other.length;
	}
}
class Boat {
	private int place;
	private String material;
	public Boat() {	}

	public Boat(int place, String material) {
		super();
		this.place = place;
		this.material = material;
	}
	public int getPlace() {return place;}
	public String getMaterial() {return material;}
	public void setPlace(int place) {this.place = place;}
	public void setMaterial(String material) {this.material = material;
	}
	@Override
	public String toString() {return String.format("Boat [place=%d, material=%s]", place, material);
	}
	@Override
	public int hashCode() {return Objects.hash(material, place);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Boat other = (Boat) obj;
		return Objects.equals(material, other.material) && place == other.place;
	}
}
class Wheel {
	private int load;
	private int diameter;
	public Wheel(){}
	
	public Wheel(int load, int diameter) {
		super();
		this.load = load;
		this.diameter = diameter;
	}
	public int getLoad() {return load;}
	public int getDiameter() {return diameter;}
	public void setLoad(int load) {this.load = load;}
	public void setDiameter(int diameter) {this.diameter = diameter;
	}
	@Override
	public String toString() {return String.format("Wheel [load=%d, diameter=%d]", load, diameter);
	}
	@Override
	public int hashCode() {return Objects.hash(diameter, load);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Wheel other = (Wheel) obj;
		return diameter == other.diameter && load == other.load;
	}
}
class Engine {
	private int power;
	private String type;
	public Engine() {}
	
	public Engine(int power, String type) {
		super();
		this.power = power;
		this.type = type;
	}
	public int getPower() {return power;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public void setPower(int power) {this.power = power;
	}
	@Override
	public String toString() {return String.format("Engine [type=%s, power=%d]", type, power);
	}
	@Override
	public int hashCode() {return Objects.hash(power, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Engine other = (Engine) obj;
		return power == other.power && Objects.equals(type, other.type);
	}
}
class Chassis {
	private Wheel wheel;
	private int quantity;
	public Chassis() {}
	
	public Chassis(Wheel wheel, int quantity) {
		super();
		this.wheel = wheel;
		this.quantity = quantity;
	}
	public Wheel getWheel() {return wheel;}
	public int getQuantity() {return quantity;}
	public void setWheel(Wheel wheel) {this.wheel = wheel;}
	public void setQuantity(int quantity) {this.quantity = quantity;
	}
	@Override
	public String toString() {return String.format("Chassis [quantity=%d, %s]", quantity, wheel);
	}
	@Override
	public int hashCode() {return Objects.hash(quantity, wheel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Chassis other = (Chassis) obj;
		return quantity == other.quantity && Objects.equals(wheel, other.wheel);
	}
}