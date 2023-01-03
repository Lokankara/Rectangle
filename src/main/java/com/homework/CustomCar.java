//package com.homework;
//
//import java.util.ArrayList;
//import java.util.Objects;
//
//interface Car {
//
//	void run();
//}
//
//public class CustomCar implements Car {
//
//	private String model;
//	private String owner = "";
//	private int price;
//	private int maxSpeed;
//	private int produceYear;
//
//	public boolean isSerg() {
//		return "Serg".equals(owner) ? true : false;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}
//
//	public String getOwner() {
//		return owner;
//	}
//
//	public void setOwner(String owner) {
//		this.owner = owner;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public int getProduceYear() {
//		return produceYear;
//	}
//
//	public void setProduceYear(int produceYear) {
//		this.produceYear = produceYear;
//	}
//
//	public int getMaxSpeed() {
//		return maxSpeed;
//	}
//
//	public void setMaxSpeed(int maxSpeed) {
//		this.maxSpeed = maxSpeed;
//	}
//
//	public CustomCar(String model, String owner, int price, int produceYear,  int maxSpeed) {
//		super();
//		this.model = model;
//		this.owner = owner;
//		this.price = price;
//		this.maxSpeed = maxSpeed;
//		this.produceYear = produceYear;
//	}
//	
//	public CustomCar() {
//		super();
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(maxSpeed, model, owner, price, produceYear);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CustomCar other = (CustomCar) obj;
//		return maxSpeed == other.maxSpeed && Objects.equals(model, other.model) && Objects.equals(owner, other.owner)
//				&& price == other.price && produceYear == other.produceYear;
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "CustomCar [model=" + model + ", owner=" + owner + ", price=" + price + ", maxSpeed=" + maxSpeed
//				+ ", produceYear=" + produceYear + "]";
//	}
//
//	public static void main(String[] args) {
//			Car customCar = new CustomCar();
//			customCar.run();
////		for (CustomCar car : cars) {
////			if (car.getOwner().contains("Serg")) {
////				System.out.printf("%s%n", car);
////			}
////		}
//	}
//
//	@Override
//	public void run() {
//	}
//}
