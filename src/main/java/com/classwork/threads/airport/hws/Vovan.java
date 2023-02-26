package com.classwork.threads.airport.hws;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Vovan {
	public static void main(String[] args) {
		long startTime, endTime;
		int planesNumber = 3000;
		List<String> cities = List.of("Kalush", "Kosiv", "Galych", "Kolomiya");
		Airport airport = new Airport(cities, 678123);
		List<AirPlane> planes = airport.generateAirPlanesWithPassengers(planesNumber);

		startTime = System.nanoTime();
		List<Bus> buses1 = airport.fillBuses(planes);
		endTime = System.nanoTime();
		System.out.println("----------one thread airport system v1 (no Depot)---------");
		System.out.println("----------took " + (endTime - startTime) + " nanoseconds----------");
		System.out.println("number of buses: " + buses1.size());
		System.out.println("number of buses passengers (should be " + planesNumber * AirPlane.MAX_CAPACITY + "): "
				+ getBusesPassengersNum(buses1));
		System.out.println("--------------------------------------------------\n");

		Depot busDepot1 = new Depot(cities);
		startTime = System.nanoTime();
		airport.fillDepot(planes, busDepot1);
		endTime = System.nanoTime();
		System.out.println("----------one thread airport system v2 (Depot)----------");
		printDepotInfo(busDepot1, startTime, endTime, planesNumber);

		Depot busDepot2 = new Depot(cities);
		startTime = System.nanoTime();
		airport.fillDepot2(planes, busDepot2);
		endTime = System.nanoTime();
		System.out.println("----------one thread airport system v3 (Depot + temp Depot)----------");
		printDepotInfo(busDepot2, startTime, endTime, planesNumber);

		Depot busDepot3 = new Depot(cities);
		List<Thread> threads = planes.stream().map(e -> new Thread(() -> airport.fillDepotMultithread(e, busDepot3)))
				.collect(Collectors.toList());
		startTime = System.nanoTime();
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		endTime = System.nanoTime();
		System.out.println("----------multi thread airport system v1 (Depot)----------");
		printDepotInfo(busDepot3, startTime, endTime, planesNumber);

		Depot busDepot4 = new Depot(cities);
		Depot tempDepot4 = new Depot(busDepot4);
		List<Thread> threads2 = planes.stream()
				.map(e -> new Thread(() -> airport.fillDepotMultithread2(e, busDepot4, tempDepot4)))
				.collect(Collectors.toList());
		startTime = System.nanoTime();
		for (Thread thread : threads2) {
			thread.start();
		}
		for (Thread thread : threads2) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		endTime = System.nanoTime();
		System.out.println("----------multi thread airport system v2 (Depot + temp Depot)----------");
		printDepotInfo(busDepot4, startTime, endTime, planesNumber);
	}

	public static <T> void printCollection(List<T> collection) {
		for (T t : collection) {
			System.out.println(t);
		}
		System.out.println();
	}

	public static int getBusesPassengersNum(List<Bus> buses) {
		return buses.stream().flatMap(e -> e.getFamilies().stream()).map(Family::getCount).reduce(0, Integer::sum);
	}

	public static void printDepotInfo(Depot busDepot, long startTime, long endTime, int planesNumber) {
		System.out.println("----------took " + (endTime - startTime) + " nanoseconds----------");
		System.out.println("number of buses: " + busDepot.getBusesNumber());
		System.out.println("number of buses passengers (should be " + planesNumber * AirPlane.MAX_CAPACITY + "): "
				+ busDepot.getTotalPassengersNumber());
		System.out.println("--------------------------------------------------\n");
	}
}

class Airport {
	private final List<String> cities;
	private final Random random;

	public Airport(List<String> cities, int randomSeed) {
		this.cities = cities;
		random = new Random(randomSeed);
	}

	public Airport(List<String> cities) {
		this.cities = cities;
		random = new Random();
	}

	public List<Bus> fillBuses(List<AirPlane> planes) {
		List<Bus> tempBuses = new ArrayList<>();
		List<Bus> resultBuses = new ArrayList<>();
		Bus tempBus;
		Iterator<Bus> busIterator;
		boolean busAdded = false;
		for (AirPlane plane : planes) {
			for (Family family : plane.getFamilies()) {
				busIterator = tempBuses.iterator();
				while (busIterator.hasNext()) {
					tempBus = busIterator.next();
					if (tempBus.getDriveTo().equals(family.getTravelTo()) && tempBus.addFamily(family)) {
						if (tempBus.getMaxPassengersCount() == tempBus.getCurrentPassengersCount()) {
							resultBuses.add(tempBus);
							busIterator.remove();
						}
						busAdded = true;
						break;
					}
				}
				if (!busAdded) {
					tempBus = generateBus(family.getTravelTo());
					tempBus.addFamily(family);
					tempBuses.add(tempBus);
				}
				busAdded = false;
			}
		}

		resultBuses.addAll(tempBuses);
		return resultBuses;
	}

	public void fillDepot(List<AirPlane> planes, Depot busDepot) {
		Bus tempBus;
		ListIterator<Bus> busIterator;
		boolean busAdded = false;
		for (AirPlane plane : planes) {
			for (Family family : plane.getFamilies()) {
				busIterator = busDepot.getCityBuses(family.getTravelTo()).listIterator();
				while (busIterator.hasNext()) {
					tempBus = busIterator.next();
					if (tempBus.addFamily(family)) {
						busAdded = true;
						break;
					}
				}
				if (!busAdded) {
					tempBus = generateBus(family.getTravelTo());
					tempBus.addFamily(family);
					busIterator.add(tempBus);
				}
				busAdded = false;
			}
		}
	}

	public void fillDepot2(List<AirPlane> planes, Depot busDepot) {
		Bus tempBus;
		Depot tempDepot = new Depot(busDepot);
		ListIterator<Bus> busIterator;
		boolean busAdded = false;
		for (AirPlane plane : planes) {
			for (Family family : plane.getFamilies()) {
				busIterator = tempDepot.getCityBuses(family.getTravelTo()).listIterator();
				while (busIterator.hasNext()) {
					tempBus = busIterator.next();
					if (tempBus.addFamily(family)) {
						if (tempBus.getMaxPassengersCount() == tempBus.getCurrentPassengersCount()) {
							busDepot.getCityBuses(family.getTravelTo()).add(tempBus);
							busIterator.remove();
						}
						busAdded = true;
						break;
					}
				}
				if (!busAdded) {
					tempBus = generateBus(family.getTravelTo());
					tempBus.addFamily(family);
					busIterator.add(tempBus);
				}
				busAdded = false;
			}
		}

		for (Map.Entry<String, List<Bus>> buses : tempDepot.getCitiesBuses().entrySet()) {
			busDepot.getCityBuses(buses.getKey()).addAll(buses.getValue());
		}
	}

	public void fillDepotMultithread(AirPlane plane, Depot busDepot) {
		Bus tempBus;
		List<Bus> tempBuses;
		ListIterator<Bus> busIterator;
		boolean busAdded = false;
		for (Family family : plane.getFamilies()) {
			tempBuses = busDepot.getCityBuses(family.getTravelTo());
			synchronized (tempBuses) {
				busIterator = tempBuses.listIterator();
				while (busIterator.hasNext()) {
					tempBus = busIterator.next();
					if (tempBus.getCurrentPassengersCount() + family.getCount() <= tempBus.getMaxPassengersCount()) {
						tempBus.addFamily(family);
						busAdded = true;
						break;
					}
				}
				if (!busAdded) {
					tempBus = generateBus(family.getTravelTo());
					tempBus.addFamily(family);
					busIterator.add(tempBus);
				}
				busAdded = false;
			}
		}
	}

	public void fillDepotMultithread2(AirPlane plane, Depot busDepot, Depot tempDepot) {
		Bus tempBus;
		List<Bus> tempBuses;
		ListIterator<Bus> busIterator;
		boolean busAdded = false;
		for (Family family : plane.getFamilies()) {
			tempBuses = tempDepot.getCityBuses(family.getTravelTo());
			synchronized (tempBuses) {
				busIterator = tempBuses.listIterator();
				while (busIterator.hasNext()) {
					tempBus = busIterator.next();
					if (tempBus.getCurrentPassengersCount() + family.getCount() <= tempBus.getMaxPassengersCount()) {
						tempBus.addFamily(family);
						if (tempBus.getMaxPassengersCount() == tempBus.getCurrentPassengersCount()) {
							busDepot.getCityBuses(family.getTravelTo()).add(tempBus);
							busIterator.remove();
						}
						busAdded = true;
						break;
					}
				}
				if (!busAdded) {
					tempBus = generateBus(family.getTravelTo());
					tempBus.addFamily(family);
					busIterator.add(tempBus);
				}
				busAdded = false;
			}
		}
		for (Map.Entry<String, List<Bus>> buses : tempDepot.getCitiesBuses().entrySet()) {
			synchronized (buses.getValue()) {
				busDepot.getCityBuses(buses.getKey()).addAll(buses.getValue());
				buses.getValue().removeAll(buses.getValue());
			}
		}

	}

	public Family generateFamily() {
		return new Family(generateName(), getRandomCity(), generateFamilySize());
	}

	public AirPlane generateAirPlane(int id) {
		return new AirPlane(id);
	}

	public List<AirPlane> generateAirPlanesWithPassengers(int planesNumber) {
		List<AirPlane> planes = new ArrayList<>();
		AirPlane plane;
		for (int i = 0; i < planesNumber; i++) {
			plane = generateAirPlane(i + 1);
			while (plane.getCurrentPassengersCount() < AirPlane.MAX_CAPACITY) {
				plane.addFamily(generateFamily());
			}
			planes.add(plane);
		}
		return planes;
	}

	public Bus generateBus(String city) {
		return new Bus(generateBusCapacity(), city);
	}

	public List<Family> getAllFamiliesFromAirPlanes(List<AirPlane> planes) {
		return planes.stream().map(AirPlane::getFamilies).flatMap(Collection::stream).collect(Collectors.toList());
	}

	private int generateBusCapacity() {
		return generateValueWithinBorders(6, 8);
	}

	private String getRandomCity() {
		return cities.get(generateValueWithinBorders(0, cities.size() - 1));
	}

	private int generateFamilySize() {
		return generateValueWithinBorders(1, 4);
	}

	private String generateName() {
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 2;
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = generateValueWithinBorders(leftLimit, rightLimit);
			buffer.append((char) randomLimitedInt);
		}

		return buffer.toString();
	}

	private int generateValueWithinBorders(int minValue, int maxValue) {
		return random.nextInt((maxValue - minValue) + 1) + minValue;
	}
}

class Depot {
	private final ConcurrentHashMap<String, List<Bus>> citiesBuses;

	public Depot(List<String> cities) {
		this.citiesBuses = new ConcurrentHashMap<>();
		for (String city : cities) {
			citiesBuses.put(city, new ArrayList<>());
		}
	}

	public Depot(Depot busDepot) {
		this.citiesBuses = new ConcurrentHashMap<>();
		for (String city : busDepot.getCitiesBuses().keySet()) {
			citiesBuses.put(city, new ArrayList<>());
		}
	}

	public ConcurrentMap<String, List<Bus>> getCitiesBuses() {
		return citiesBuses;
	}

	public List<Bus> getCityBuses(String city) {
		return citiesBuses.get(city);
	}

	public void addCityBus(String city, Bus bus) {
		List<Bus> buses = citiesBuses.get(city);

		if (buses == null) {
			return;
		}
		buses.add(bus);
	}

	public long getBusesNumber() {
		return citiesBuses.values().stream().flatMap(Collection::stream).count();
	}

	public long getTotalPassengersNumber() {
		return citiesBuses.values().stream().flatMap(Collection::stream).flatMap(e -> e.getFamilies().stream())
				.map(Family::getCount).reduce(0, Integer::sum);
	}

	@Override
	public String toString() {
		return toStringCityBuses();
	}

	private String toStringCityBuses() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, List<Bus>> cityBuses : citiesBuses.entrySet()) {
			for (Bus bus : cityBuses.getValue()) {
				sb.append(bus.toString()).append("\n");
			}
		}
		return sb.toString();
	}
}

class Family {
	private final String name;
	private final String travelTo;
	private final int count;

	public Family(String name, String travelTo, int count) {
		this.name = name;
		this.travelTo = travelTo;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public String getTravelTo() {
		return travelTo;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Family{" + "name='" + name + '\'' + ", travelTo='" + travelTo + '\'' + ", count=" + count + '}';
	}
}

class AirPlane {
	private final List<Family> families;
	public static final int MAX_CAPACITY = 100;
	private int currentPassengersCount = 0;
	private final int id;

	public AirPlane(int id) {
		this.families = new ArrayList<>();
		this.id = id;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public int getId() {
		return id;
	}

	public int getCurrentPassengersCount() {
		return currentPassengersCount;
	}

	public void addFamily(Family family) {
		if (currentPassengersCount + family.getCount() <= MAX_CAPACITY) {
			families.add(family);
			currentPassengersCount += family.getCount();
		}
	}

	@Override
	public String toString() {
		return "AirPlane (id = " + id + ", currentPassengersCount = " + currentPassengersCount + ") {" + toStringFamilies()
				+ '}';
	}

	private String toStringFamilies() {
		StringBuilder sb = new StringBuilder("\n");
		for (Family family : families) {
			sb.append("      ").append(family.toString()).append("\n");
		}
		return sb.toString();
	}
}

class Bus {
	private final int maxPassengersCount;
	private int currentPassengersCount = 0;
	private final String driveTo;
	private final List<Family> families;

	public Bus(int maxPassengersCount, String driveTo) {
		this.maxPassengersCount = maxPassengersCount;
		this.driveTo = driveTo;
		this.families = new ArrayList<>();
	}

	public int getMaxPassengersCount() {
		return maxPassengersCount;
	}

	public int getCurrentPassengersCount() {
		return currentPassengersCount;
	}

	public String getDriveTo() {
		return driveTo;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public synchronized boolean addFamily(Family family) {
		if (family.getCount() + currentPassengersCount <= maxPassengersCount) {
			families.add(family);
			currentPassengersCount += family.getCount();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Bus { " + "masPassengersCount=" + maxPassengersCount + ", currentPassengersCount="
				+ currentPassengersCount + ", driveTo='" + driveTo + '\'' + toStringFamilies() + '}';
	}

	private String toStringFamilies() {
		StringBuilder sb = new StringBuilder("\n");
		for (Family family : families) {
			sb.append("      ").append(family.toString()).append("\n");
		}
		return sb.toString();
	}
}