package com.classwork.collection.generic;

import java.util.ArrayList;
import java.util.List;

public class AnimalDoctorGeneric {
	public void checkAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.say();
		}
	}

	public void checkAnimals(List<? extends Animal> animals) {
		animals.forEach(animal -> animal.say());
	}

	public static void main(String[] args) {
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();

		Holder<Dog> dogHolder = new Holder<>();
		Holder<Cat> catHolder = new Holder<>();
		List<Dog> dogsList = dogHolder.makeArrayList(new Dog(1L, 23.0));
		List<Cat> catsList = catHolder.makeArrayList(new Cat(1L, 23.0));

		Dog[] dogs = { new Dog(1L, 23.0), new Dog(1L, 23.0) };
		Cat[] cats = { new Cat(1L, 23.0), new Cat(1L, 23.0), new Cat(1L, 23.0) };
		Bird[] birds = { new Bird() };

		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]

		doc.checkAnimals(dogsList); // send a List<Dog>
		doc.checkAnimals(catsList); // send a List<Cat>
//		doc.checkAnimals(birds); // send a List<Bird>
	}
}

class Holder<T extends Animal> {

	public List<T> makeArrayList(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}
}

class Bird extends Animal {
	public Bird(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}

	public Bird() {
		super(1L, 23.0, "Chirick");
	}

	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}
