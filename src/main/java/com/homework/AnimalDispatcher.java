package com.homework;

import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Comparator;

interface Mammal {abstract void say();}
public class AnimalDispatcher {

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

class Controller {

	public static <T, K extends T> Map<K, Integer> sameMammals(List<? extends T> animals, K[] mammals) {
		Map<K, Integer> result = new HashMap<>();

		int counter;

		for (K mammal : mammals) {
			counter = 1;
			for (T animal : animals) {
				if (Objects.equals(mammal, animal)) {
					counter++;
				}
			}
			if (counter > 1) {
				result.put(mammal, counter);				
			}
		}
		return result;
	}

	public static <T, K extends T> void differenceMammals(List<? super T> animals, K[] mammals) {

		for (K mammal : mammals) {
			if (!animals.contains(mammal)) {
				animals.add(mammal);
			}
		}
	}

	public static <T extends Comparable<? super T>> AnimalHolder<? extends Animal> minmax(List<Animal> animals) {
		return new AnimalHolder<Animal>(generatedAnimals);
	}
	
	public static void testContainer() {

		AnimalHolder<Animal> animalHolder = new AnimalHolder<Animal>(Controller.generatedAnimals);
		AnimalHolder<Felidae> catHolder = new AnimalHolder<Felidae>(Controller.generatedCats);
		AnimalHolder<Canidae> dogHolder = new AnimalHolder<Canidae>(Controller.generatedDogs);
		AnimalHolder<Rodent> rodentHolder = new AnimalHolder<Rodent>(Controller.generatedRodents);

		Controller.insertRandom();
		AnimalHolder<Felidae> randomCatsHolder = new AnimalHolder<Felidae>(generatedCats);
		AnimalHolder<Canidae> randomDogHolder = new AnimalHolder<Canidae>(generatedDogs);
		AnimalHolder<Animal> randomAnimalHolder = new AnimalHolder<Animal>(generateAnimals());

		randomAnimalHolder.arraysCompare(randomCatsHolder);
		randomAnimalHolder.arraysCompare(randomDogHolder);
		randomAnimalHolder.arraysCompare(rodentHolder);

		animalHolder.arraysCompare(catHolder);
		animalHolder.arraysCompare(dogHolder);
		animalHolder.arraysCompare(rodentHolder);

		animalHolder.arraysCompare(randomCatsHolder);
		animalHolder.arraysCompare(randomDogHolder);
		animalHolder.arraysCompare(rodentHolder);
	}

	private final static Long age = 6L;
	private final static Double weight = 100D;
	private final static int max = 10;
	private final static Random random = new Random();
	static Felidae[] cats = { new Lynx(3L, 2.5), new Lion(2L, 23.2), new Tiger(3L, 25.2), new Cat(1L, 2.9),
			new Lynx(1L, 1.5), new Lion(1L, 13.2), new Tiger(1L, 15.2), new Cat(2L, 2.9) };

	static Animal[] animals = { new Dog(1L, 1.5), new Lion(1L, 15.9), new Wolf(1L, 2.1), new Tiger(1L, 16.9),
			new Cat(1L, 0.9), new Lynx(1L, 2.9), new Hamster(1L, 0.5), new Chipmunk(1L, 0.2), new Fox(1L, 1.5),
			new Beaver(1L, 1.2) };

	static Canidae[] dogs = { new Dog(1L, 3.5), new Wolf(3L, 5.5), new Fox(2L, 3.2), new Dog(2L, 3.5),
			new Wolf(1L, 5.5), new Fox(1L, 3.2) };

	static Rodent[] rodents = { new Beaver(5L, 2.5), new Chipmunk(3L, 0.5), new Hamster(3L, 0.2) };

	static ArrayList<Animal> generatedAnimals = new ArrayList<>();
	static ArrayList<Felidae> generatedCats = new ArrayList<>();
	static List<Canidae> generatedDogs = new ArrayList<>();
	static List<Rodent> generatedRodents = new ArrayList<>();

	public static void insertRandom() {
		generatedDogs.addAll(generateDogs());
		generatedCats.addAll(generateCats());
		generatedAnimals.addAll(generateDogs());
		generatedAnimals.addAll(generateCats());
		generatedAnimals.addAll(generateAnimals());
		generatedRodents.addAll(generateRodents());
		generatedAnimals.addAll(generateRodents());
	}
	public static List<Animal> generateAnimals() {
//		List<Animal> generateAnimals = new ArrayList<>();
		generatedAnimals.addAll(generateCats());
		generatedAnimals.addAll(generateDogs());
		generatedAnimals.addAll(generateRodents());
		Collections.shuffle(generatedAnimals);
		return generatedAnimals;
	}
	public static List<? extends Rodent> generateRodents() {
//		List<Rodent> generatedRodents = new ArrayList<>();
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedRodents.add(new Hamster((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 10));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedRodents.add(new Chipmunk((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 10));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedRodents.add(new Beaver((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 4));
		Collections.shuffle(generatedRodents);
		return generatedRodents;
	}
	public static List<? extends Felidae> generateCats() {
//		List<Felidae> generatedCats = new ArrayList<>();
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedCats.add(new Cat(random.nextLong(age) + 1, (random.nextDouble(weight) + age) / 5));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedCats.add(new Lynx(random.nextLong(age) + 1, (random.nextDouble(weight) + age) / 3));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedCats.add(new Lion(random.nextLong(age) + 1, (random.nextDouble(weight) + age) * 2));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedCats.add(new Tiger(random.nextLong(age) + 1, (random.nextDouble(weight) + age) * 2));
		Collections.shuffle(generatedCats);
		return generatedCats;
	}
	public static List<? extends Canidae> generateDogs() {
//		List<Canidae> generatedDogs = new ArrayList<>();
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedDogs.add(new Fox(random.nextLong(age) + 1, (random.nextDouble(weight) + age) / 5));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedDogs.add(new Dog(random.nextLong(age) + 1, (random.nextDouble(weight) + age) / 3));
		for (int i = 1; i <= random.nextInt(max) + 1; i++)
			generatedDogs.add(new Wolf(random.nextLong(age) + 1, (random.nextDouble(weight) + age) / 2));
		Collections.shuffle(generatedDogs);
		return generatedDogs;
	}
	public static void print(ArrayList<? extends Animal> animals) {
		for (Animal animal : animals) {
			animal.say();
		}
	}
	public static void print(Map<? extends Animal, Integer> map) {
		for (var animal : map.keySet()) {
			animal.say();
		}
	}
	
	public static void print(Animal[] animals) {
		for (Animal animal : animals) {
			animal.say();
		}
	}
}
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
abstract class Animal implements Mammal {
	protected final String type = this.getClass().getSimpleName();
	protected Long age;
	protected Double weight;
	protected String voice;
	protected void eat(Double food) {
		System.out.printf("The %.2f weight %s was fed%n", weight += food, type);
	}
	@Override
	public void say() {
		System.out.printf("The %d year-old %s says '%s'%n", age, type, voice);
	}
	public Animal(Long age, Double weight, String voice) {
		super();
		this.age = age;
		this.weight = weight;
		this.voice = voice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, weight, voice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(voice, other.voice)
				&& Objects.equals(age, other.age);
//				&& Objects.equals(weight, other.weight);	
	}
}
abstract class Canidae extends Animal { 
	protected void sniff() {
		System.out.printf("The %.2f weight %s sniffs%n", weight, type);
	}
	public Canidae(Long age, Double weight) {
		super(age, weight, "Woof");
	}
	public Canidae(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}	
}
class Dog extends Canidae {
	public Dog(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 19;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Wolf extends Canidae {	
	public Wolf(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 23;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wolf other = (Wolf) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Fox extends Canidae {
	public Fox(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
abstract class Felidae extends Animal {
	protected void purr() {
		System.out.printf("The %.2f weight %s purrs%n", weight, type);		
	}
	public Felidae(Long age, Double weight) {
		super(age, weight, "Meow");
	}
	public Felidae(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Felidae other = (Felidae) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Cat extends Felidae {
	public Cat(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 13;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Tiger extends Felidae {
	public Tiger(Long age, Double weight) {
		super(age, weight, "Argthhh");
	}
	@Override
	public int hashCode() {
		final int prime = 11;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tiger other = (Tiger) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Lion extends Felidae {
	public Lion(Long age, Double weight) {
		super(age, weight, "Roar");
	}
	@Override
	public int hashCode() {
		final int prime = 17;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Lynx extends Felidae {
	public Lynx(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 7;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lynx other = (Lynx) obj;
		return Objects.equals(voice, other.voice);
	}
}
abstract class Rodent extends Animal {
	protected void chew() {
		System.out.printf("The %.2f weight %s chews%n", weight, type);
	}
	public Rodent(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}
	public Rodent(Long age, Double weight) {
		super(age, weight, "Squeak");
	}		
}
class Hamster extends Rodent {
	public Hamster(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 101;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hamster other = (Hamster) obj;
		return Objects.equals(voice, other.voice);
	}	
}
class Beaver extends Rodent {
	public Beaver(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 103;
		int hash = 1;
		hash += prime * hash;
		hash += prime * this.age.hashCode();
		hash += prime * this.weight.hashCode();
		hash += prime * this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beaver other = (Beaver) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Chipmunk extends Rodent {
	public Chipmunk(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 107;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chipmunk other = (Chipmunk) obj;
		return Objects.equals(voice, other.voice);
	}
}