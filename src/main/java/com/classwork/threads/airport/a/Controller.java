package com.classwork.threads.airport.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {
	public static final List<Family> allPassagers = new ArrayList<>();

	public static final List<String> cities = new ArrayList<>(Arrays.asList("Kalush", "Kosiv", "Galych", "Kolomiya"));

	static Integer generateCountFamily() {
		return ThreadLocalRandom.current().nextInt(1, 5);
	}

	static String generateCity() {
		return cities.get(ThreadLocalRandom.current().nextInt(0, 4));
	}
	
	public static List<Plane> createPlanes() {

		int sum;
		Integer count;
		int amount;
		int planes = 3;
		int total = 100;
		int[] places = new int[planes];
		List<Plane> aircrafts = new ArrayList<>();
		List<Family> families = new ArrayList<>();


		for (int plane = 0; plane < planes - 1; plane++) {
			places[plane] = ThreadLocalRandom.current().nextInt(total / 4, total / 2);
			total -= places[plane];
		}
		places[planes - 1] = total;

		for (int plane = 1; plane <= planes; plane++) {
			sum = 0;
			amount = places[plane - 1];

			while (sum < amount - 3) {
				count = Controller.generateCountFamily();
				sum += count;
				families.add(new Family(count, AirportController.generateName(97, 122, 10 - count), plane,
						Controller.generateCity()));
			}
			if (sum != amount) {
				families.add(new Family(amount - sum, AirportController.generateName(97, 122, 7), plane,
						Controller.generateCity()));
			}
//			Gate gate = new Gate(aircrafts);
			System.out.println(families);
			aircrafts.add(new Plane(plane, families));
			allPassagers.addAll(families);

		}
		return aircrafts;
	}
}