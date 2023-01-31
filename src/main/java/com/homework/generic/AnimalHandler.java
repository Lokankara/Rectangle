package com.homework.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnimalHandler {

	static List<Cat> cats = new ArrayList<>();
	static List<Tiger> tigers = new ArrayList<>();
	static List<Lion> lions = new ArrayList<>();
	static List<Lynx> lynxes = new ArrayList<>();
	static List<Dog> dogs = new ArrayList<>();
	static List<Wolf> wolves = new ArrayList<>();
	static List<Fox> foxes = new ArrayList<>();
	static List<Beaver> beavers = new ArrayList<>();
	static List<Hamster> hamsters = new ArrayList<>();
	static List<Chipmunk> chipmunks = new ArrayList<>();

	Map<? extends Animal, Integer> mapAnimals = new HashMap<>();

	Animal[] animals;

	static <T extends Animal> void handle(List<Animal> animals) {

		int[] primes = { 13, 11, 17, 7, 19, 23, 31, 101, 103, 107 };

		for (int prime : primes) {
			for (Animal animal : animals) {

				boolean flag = (animal.hashCode() - animal.voice.hashCode())
						/ prime == (animal.weight.hashCode() + prime * (animal.age.hashCode() + prime));

				if (flag && prime == 13) {
					cats.add((Cat) animal);
				} else if (flag && prime == 11) {
					tigers.add((Tiger) animal);
				} else if (flag && prime == 7) {
					lynxes.add((Lynx) animal);
				} else if (flag && prime == 17) {
					lions.add((Lion) animal);
				} else if (flag && prime == 19) {
					dogs.add((Dog) animal);
				} else if (flag && prime == 23) {
					wolves.add((Wolf) animal);
				} else if (flag && prime == 103) {
					beavers.add((Beaver) animal);
				} else if (flag && prime == 31) {
					foxes.add((Fox) animal);
				} else if (flag && prime == 101) {
					hamsters.add((Hamster) animal);
				} else if (flag && prime == 107) {
					chipmunks.add((Chipmunk) animal);
				}
			}
		}
	}
}
