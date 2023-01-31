package com.classwork.collection.generic;

import java.util.ArrayList;
import java.util.List;

public class AnimalDoctorGeneric {
	public void checkAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.checkup();
		}
	}

	public void checkAnimals(List<? extends Animal> animals) {
		animals.forEach(animal -> animal.checkup());
	}

	public static void main(String[] args) {
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();

		AnimalHolder<Dog> dogHolder = new AnimalHolder<>();
		AnimalHolder<Cat> catHolder = new AnimalHolder<>();
		List<Dog> dogsList = dogHolder.makeArrayList(new Dog());
		List<Cat> catsList = catHolder.makeArrayList(new Cat());

		Dog[] dogs = { new Dog(), new Dog() };
		Cat[] cats = { new Cat(), new Cat(), new Cat() };
		Bird[] birds = { new Bird() };

		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]

		doc.checkAnimals(dogsList); // send a List<Dog>
		doc.checkAnimals(catsList); // send a List<Cat>
//		doc.checkAnimals(birds); // send a List<Bird>
	}
}

class AnimalHolder<T extends Animal> {

	public List<T> makeArrayList(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}
}

abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}

class Cat extends Animal {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}
