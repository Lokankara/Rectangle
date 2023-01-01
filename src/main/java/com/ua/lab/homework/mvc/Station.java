package com.ua.lab.homework.mvc;

public class Station {
	
public static void main(String[] args){

	double pow = mathFunction("pow", 2, 16);

	System.out.println(pow);	
	
	Car car = new Car();
	car.price(6000);
	car.weight(1500);
	car.speed(150);
	
	double  newWeight = operation("multi", "weight", car, 1.2);
	car.weight(newWeight);
	
	double  newPrice = operation("div", "price", car, .75);
	car.price(newPrice);
	
	System.out.println(car);
}
private static double operation(String command, String field, Car car, double k) {

	switch(field) {
	case ("price"):
		return (mathFunction(command, car.price(), k));
	case ("weight"):
		return (mathFunction(command, car.weight(), k));
	case ("speed"):
		return (mathFunction(command, car.speed(), k));
	default: 
		return -1;
	}
}
public static double mathFunction(String command, double a, double b){
	switch(command) {
	case ("multi"):
		return multi(a,b);
	case ("div"):
		return div(a,b);
	case ("pow"):
		return pow(a,b);
	case ("log"):
	return log(a,b);
	case ("log10"):
		return log10(a,b);
	default:
		return -1;
	}
}
private static double multi(double a, double b) {
	return a * b;
}
private static double log10(double a, double b) {
	 return Math.log10(a+b);
}
private static double log(double a, double b) {
	return Math.log(a+b);

}
private static double div(double a, double b) {
	return b !=0 ? a/b : -1;
}
private static double pow(double a, double b) {
	return Math.pow(a, b);
}
}


class Car {

	public Car() {};
	
	private double price;
	private double weight;
	private double speed;
	
	
	@Override
	public String toString() {
		return String.format("price: %s, weight: %s, speed: %s", price, weight, speed) ;
	}
	public double price() {
		return price;
	}
	public void price(double price) {
		this.price = price;
	}
	public double weight() {
		return weight;
	}
	public void weight(double weight) {
		this.weight = weight;
	}
	public double speed() {
		return speed;
	}
	public void speed(double speed) {
		this.speed = speed;
	}	
}
