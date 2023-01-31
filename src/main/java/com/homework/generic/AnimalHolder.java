package com.homework.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class AnimalHolder<T extends Animal> implements Comparator<Animal> {

	List<T> animals;

	AnimalHolder(List<T> list) {
		this.animals = list;
	}

	<T extends Animal> void arraysCompare(AnimalHolder<T> holder) {

		List<Animal> same = new ArrayList<>();
		List<Animal> diff = new ArrayList<>();

		for (Animal animal : this.animals) {
			if (holder.animals.contains(animal)) {
				same.add(animal);
			} else {
				diff.add(animal);
			}
		}

		AnimalHandler.handle(diff);
		AnimalHandler.handle(same);
//		AnimalHandler.handle(holder);
		
		System.out.printf("Sizes: {animals: %d, holder: %d, same: %d, difference: %d}%n", this.animals.size(),
				holder.animals.size(), same.size(), diff.size());
	}

	@Override
	public int compare(Animal a, Animal b) {
		return (int) (b.age - a.age);
	}
}
