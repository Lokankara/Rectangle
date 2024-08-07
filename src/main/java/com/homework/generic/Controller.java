package com.homework.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

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
        AnimalHolder<MammalRodent> rodentHolder = new AnimalHolder<MammalRodent>(Controller.generatedMammalRodents);

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
    static Felidae[] cats = {new Lynx(3L, 2.5), new Lion(2L, 23.2), new Tiger(3L, 25.2), new Cat(1L, 2.9),
            new Lynx(1L, 1.5), new Lion(1L, 13.2), new Tiger(1L, 15.2), new Cat(2L, 2.9)};

    static Animal[] animals = {new Dog(1L, 1.5), new Lion(1L, 15.9), new Wolf(1L, 2.1), new Tiger(1L, 16.9),
            new Cat(1L, 0.9), new Lynx(1L, 2.9), new Hamster(1L, 0.5), new Chipmunk(1L, 0.2), new Fox(1L, 1.5),
            new Beaver(1L, 1.2)};

    static Canidae[] dogs = {new Dog(1L, 3.5), new Wolf(3L, 5.5), new Fox(2L, 3.2), new Dog(2L, 3.5),
            new Wolf(1L, 5.5), new Fox(1L, 3.2)};

    static MammalRodent[] mammalRodents = {new Beaver(5L, 2.5), new Chipmunk(3L, 0.5), new Hamster(3L, 0.2)};

    static ArrayList<Animal> generatedAnimals = new ArrayList<>();
    static ArrayList<Felidae> generatedCats = new ArrayList<>();
    static List<Canidae> generatedDogs = new ArrayList<>();
    static List<MammalRodent> generatedMammalRodents = new ArrayList<>();

    public static void insertRandom() {
        generatedDogs.addAll(generateDogs());
        generatedCats.addAll(generateCats());
        generatedAnimals.addAll(generateDogs());
        generatedAnimals.addAll(generateCats());
        generatedAnimals.addAll(generateAnimals());
        generatedMammalRodents.addAll(generateRodents());
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

    public static List<? extends MammalRodent> generateRodents() {
//		List<Rodent> generatedRodents = new ArrayList<>();
        for (int i = 1; i <= random.nextInt(max) + 1; i++)
            generatedMammalRodents.add(new Hamster((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 10));
        for (int i = 1; i <= random.nextInt(max) + 1; i++)
            generatedMammalRodents.add(new Chipmunk((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 10));
        for (int i = 1; i <= random.nextInt(max) + 1; i++)
            generatedMammalRodents.add(new Beaver((random.nextLong(age) + 1), (random.nextDouble(weight) + age) / 4));
        Collections.shuffle(generatedMammalRodents);
        return generatedMammalRodents;
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
