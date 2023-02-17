package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

class Controller {
	public static final List<Family> allPassagers = new ArrayList<>();
	public static final List<String> cities = new ArrayList<>(Arrays.asList("Kalush", "Kosiv", "Galych", "Kolomiya"));

	public static List<Plane> buildPlanes() {

		int sum;
		int amount;
		Integer count;
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
				count = Controller.generateMemberFamily();
				sum += count;
				families.add(new Family(count, Controller.generateName(97, 122, 5), plane, Controller.generateCity()));
			}
			if (sum != amount) {
				families.add(new Family(amount - sum, Controller.generateName(97, 122, 5), plane,
						Controller.generateCity()));
			}

			aircrafts.add(new Plane(plane, families, Gate.getGate()));
			allPassagers.addAll(families);
			families.clear();

		}
		int m = 0, f = 0;
		for (int i = 0; i < aircrafts.size(); i++) {
			m += aircrafts.get(i).getMembers();
			f += aircrafts.get(i).families.size();
		}
		View.display(String.format("%s planes contains %s families and %s seats%n", planes, f, m));
		return aircrafts;
	}

	private static Integer generateMemberFamily() {
		return ThreadLocalRandom.current().nextInt(1, 5);
	}

	private static String generateCity() {
		return cities.get(ThreadLocalRandom.current().nextInt(0, 4));
	}

	private static String generateName(int min, int max, int length) {
		StringBuilder builder = new StringBuilder();
		builder.append((char) (ThreadLocalRandom.current().nextInt(min, max + 1) - 32));
		for (int i = 0; i < length - 1; i++) {
			builder.append((char) ThreadLocalRandom.current().nextInt(min, max + 1));
		}
		return new String(builder);
	}

	public static Map<String, List<Bus>> buildBuses(String city, Queue<Family> passengers) {

		List<Bus> listBus = new ArrayList<>();
		List<Family> families = new ArrayList<>();
		Map<String, List<Bus>> mapBus = new HashMap<>();

		int seats = 0;
		Family family = passengers.poll();

		while (family != null) {
			seats += family.getCount();

			families.add(family);
			if (seats > 5 && seats < 9) {
				listBus.add(new Bus(city, families, BusStation.getStation()));
				families.clear();
				seats = 0;
			}
			family = passengers.poll();
		}

		mapBus.put(city, listBus);
		return mapBus;

	}
}