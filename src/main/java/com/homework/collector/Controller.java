package com.homework.collector;

public class Controller {

	int[] primes = { 31, 37, 41 };

	Worker worker = new Worker(25L, "Chad");
	Keeper keeper = new Keeper(18L, "Alice");
	Visitor visitor = new Visitor(21L, "Bob");
	Visitor visitora = new Visitor(21L, "Boba");
	Person[] persons = { worker, keeper, visitor, visitora };

	public void check() {

		for (Person person : persons) {
			for (int p = 0; p < primes.length; p++) {
				int prime = primes[p];
				if (person.hashCode() - prime * (prime + person.age.hashCode()) == person.name.hashCode()) {
					System.out.printf("Found: %d %d %s %n", prime, person.hashCode(), person);
				}
			}
		}
	}
}