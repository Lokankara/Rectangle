package com.test.heller;

 interface Washer {

}

public class Animal {
	public static void main(String[] a) {
		Dog rover, fido;
		Animal animal;
		Cat sunflower;
		Washer wawa;
		Washer w;
		Swamp pogo;

		sunflower = new Cat();
		wawa = sunflower;
//		pogo = (Swamp) wawa;

		rover = new Dog();
		animal = rover;
		fido = (Dog) animal;
		
		Raccon rocky;
		rocky = new Raccon();
		w = rocky;
//		pogo = (Swamp) w;
	}

}

 class Mammal extends Animal {
	
}
 
 class Dog extends Mammal {
	 
 }

 class Cat extends Mammal implements Washer{
	 
 }
 class Raccon extends Mammal implements Washer{
	 
 }
 
 class Swamp extends Mammal {
	 
 }
