package com.homework.io.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

class Ship extends Vehicle implements Externalizable {
	private static final long serialVersionUID = -18982551340645L;
	public Ship() {super();}
	
	private double length;
	private int capacity;
	transient private Boat boat;
	
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
	public void setLength(double length) {this.length = length;}
	public int getCapacity() {return capacity;}
	public void setCapacity(int capacity) {this.capacity = capacity;}
	public Boat getBoat() {return boat;}
	public void setBoat(Boat boat) {this.boat = boat;}
	
	@Override
	public String toString() {
		return String.format("Ship [year=%d, length=%.2f, capacity=%d, speed=%d, %s, %s]", 
				getYear(), length, capacity, getSpeed(), boat, getEngine());
	}

	@Override
	public int hashCode() {return Objects.hash(boat, capacity, length);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Ship other = (Ship) obj;
		return Objects.equals(boat, other.boat) && capacity == other.capacity && length == other.length;
	}
}
