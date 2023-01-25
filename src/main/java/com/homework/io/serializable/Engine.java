package com.homework.io.serializable;

import java.util.Objects;

class Engine {
	private int power;
	private String type;
	public Engine() {}
	public Engine(int power, String type) {
		super();
		this.power = power;
		this.type = type;
	}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public int getPower() {return power;}
	public void setPower(int power) {this.power = power;}
	@Override
	public String toString() {return String.format("Engine [type=%s, power=%d]", type, power);}
	@Override
	public int hashCode() {return Objects.hash(power, type);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Engine other = (Engine) obj;
		return power == other.power && Objects.equals(type, other.type);}
}