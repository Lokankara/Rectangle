package com.homework.io.serializable;

import java.util.Objects;

class Chassis {
	transient private Wheel wheel;
	private int quantity;
	public Chassis() {}
	public Chassis(Wheel wheel, int quantity) {
		super();
		this.wheel = wheel;
		this.quantity = quantity;
	}
	public Wheel getWheel() {return wheel;}
	public void setWheel(Wheel wheel) {this.wheel = wheel;}
	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	@Override
	public String toString() {return String.format("Chassis [quantity=%d, %s]", quantity, wheel);}
	@Override
	public int hashCode() {return Objects.hash(quantity, wheel);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Chassis other = (Chassis) obj;
		return quantity == other.quantity && Objects.equals(wheel, other.wheel);}
}