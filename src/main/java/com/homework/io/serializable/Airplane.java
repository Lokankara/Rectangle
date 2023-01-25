package com.homework.io.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

class Airplane extends Vehicle implements Serializable {
	private static final long serialVersionUID = 7829136421241571165L;
	private String model;
	private int distance;
	private Chassis chassis;
	
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
	public Airplane() {super();}
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
