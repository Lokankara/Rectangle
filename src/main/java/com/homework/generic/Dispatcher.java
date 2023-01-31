package com.homework.generic;

import java.util.Map;

//interface Mammal {abstract void say();}
public class Dispatcher {

	public static void main(String[] args) {

//		Controller.testContainer();
		Controller.insertRandom();

		Map<Felidae, Integer> sameFelidaes = Controller.sameMammals(Controller.generatedAnimals, Controller.cats);
		Map<Canidae, Integer> sameCanidaes = Controller.sameMammals(Controller.generatedAnimals, Controller.dogs);
		Map<Animal, Integer> sameAnimal = Controller.sameMammals(Controller.generatedAnimals, Controller.animals);
		
		Controller.differenceMammals(Controller.generatedCats, Controller.cats);
		Controller.differenceMammals(Controller.generatedAnimals, Controller.dogs);

//		Map<Cat, Integer> sameCats= Controller.sameElements(AnimalHandler.cats, Controller.animals);
		
		Controller.print(sameCanidaes);
		Controller.print(sameFelidaes);
		Controller.print(sameAnimal);
//		Controller.print(Controller.generatedCats);
	}
}
