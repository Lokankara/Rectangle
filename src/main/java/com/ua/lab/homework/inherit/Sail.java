///**
// * 
// */
//package com.homework.inherit;
//
///**
// * @author PPoliak
// *
// */
//public class Sail {
//
//	/**
//	 * 
//	 */
//	public Sail() {
//		// TODO Auto-generated constructor stub
//	}
//
//}
//
//abstract class Ship extends Vehicle implements CanSwim {
//
//	public Ship(String name) {
//		super(name);
//	}
//
//	public Ship() {
//		super("Ship");
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Ship [name=%s, isRun=%s]", name(), isRun());
//	}
//}
//
//abstract class Liner extends Vehicle {
//
//	public Liner() {
//		super("Liner");
//	}
//
//	public Liner(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Liner [name=%s, isRun=%s]", name(), isRun());
//	}
//}
//
//abstract class SailLiner extends Liner implements CanSwim {
//	public SailLiner() {
//		super("SailLiner");
//	}
//
//	public SailLiner(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("SailLiner [name=%s, isRun=%s]", name(), isRun());
//	}
//}
//
//class PassengersSailLiner extends SailLiner {
//	public PassengersSailLiner() {
//		super("PassengersSailLiner");
//	}
//
//	public PassengersSailLiner(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("PassengersSailLiner [price=%d, name=%s, isRun=%s]", price(), name(), isRun());
//	}
//
//}
//
//class TugBoat extends Ship {
//
//	public TugBoat() {
//		super("TugBoat");
//	}
//
//	public TugBoat(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("TugBoat [price=%d, name=%s, isRun=%s]", price(), name(), isRun());
//	}
//}
//
//class Tanker extends Ship {
//	public Tanker() {
//		super("Tanker");
//	}
//
//	public Tanker(String name) {
//		super(name);
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Tanker [price=%d, name=%s, isRun=%s]", price(), name(), isRun());
//	}
//}