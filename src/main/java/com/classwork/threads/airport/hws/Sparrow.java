package com.classwork.threads.airport.hws;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.*;

public class Sparrow {

	public static void main(String[] args) {
//        var familiesList1 = new LinkedList<>(List.of(
//                Family.of("a01", "Kalush", 2),
//                Family.of("a12", "Kalush", 4),
//                Family.of("a02", "Kalush", 3),
//                Family.of("a03", "Kalush", 1),
//                Family.of("a04", "Kalush", 4),
//                Family.of("a09", "Galych", 4),
//                Family.of("a05", "Kosiv", 4),
//                Family.of("a06", "Kosiv", 4),
//                Family.of("a07", "Kosiv", 4),
//                Family.of("a08", "Kosiv", 4),
//                Family.of("a10", "Galych", 4),
//                Family.of("a11", "Galych", 4)
//        ));

//        var planes = List.of(
//                Plane.of(1, familiesList1)
//        );

		/*
		 * Change following parameters to configure generator or use hardcoded values
		 * above.
		 *
		 * To truly showcase efficiency of multithreading method use larger data sets.
		 * For instance, set int passengersOnPlane = 5000; int totalPlanes = 5;
		 */
		int minFamilyCount = 1;
		int maxFamilyCount = 4;
		int passengersOnPlane = 100;
		int totalPlanes = 3;

		List<Plane> planes = PlaneGenerator.generateList(minFamilyCount, maxFamilyCount, passengersOnPlane,
				totalPlanes);

		TimerUtil timer = new TimerUtil();
		timer.start();
		var busesList = Service.distributePassengersMultithreading(planes);
		timer.end();
		System.out.println("With Multithreading");
		System.out.printf("Time passed = %s ms%n", timer.getPassedTimeInMs());
//        busesList.forEach(System.out::println);

		timer.reset();
		timer.start();
		var buses = Service.distributePassengersSingleThread(planes);
		timer.end();
		System.out.println("With Single Thread");
		System.out.printf("Time passed = %s ms%n", timer.getPassedTimeInMs());
//        busesList.forEach(System.out::println);
	}
}

class Service {
	public static List<AirBus> distributePassengersMultithreading(List<Plane> planesList) {

		List<PassengersDistributor> passengersDistributorList = planesList.stream()
				.map(x -> new PassengersDistributor(x.getFamilies())).toList();

		try {
			ExecutorService executorService = Executors.newFixedThreadPool(planesList.size());

			var futuresResult = executorService.invokeAll(passengersDistributorList);

			executorService.shutdown();
			return futuresResult.stream().flatMap(future -> {
				try {
					return future.get().stream();
				} catch (InterruptedException | ExecutionException e) {
					throw new RuntimeException(e);
				}
			}).toList();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<AirBus> distributePassengersSingleThread(List<Plane> planesList) {
		List<Passenger> families = planesList.stream().flatMap(plane -> plane.getFamilies().stream())
				.collect(Collectors.toCollection(LinkedList::new));

		PassengersDistributor passengersDistributor = new PassengersDistributor(families);

		return passengersDistributor.call();
	}

}

class PassengersDistributor implements Callable<List<AirBus>> {

	private List<Passenger> families;

	public PassengersDistributor(List<Passenger> families) {
		this.families = families;
	}

	@Override
	public List<AirBus> call() {
		var travelToAndFamilyListMap = groupByTravelTo(families);

		List<AirBus> busList = new ArrayList<>();
		for (var entry : travelToAndFamilyListMap.values()) {
			busList.addAll(fillBusesByDriveTo(entry));
		}
		return busList;
	}

	private List<AirBus> fillBusesByDriveTo(List<Passenger> familyList) {

		if (familyList.isEmpty()) {
			return List.of();
		}
		List<AirBus> buses = new ArrayList<>();
		String travelTo = familyList.get(0).getTravelTo();

		familyList.sort(Comparator.comparing(Passenger::getCount));

		while (!familyList.isEmpty()) {

			AirBus bus = BusFactory.createBus(travelTo);
			buses.add(bus);

			for (int i = familyList.size() - 1; i >= 0; i--) {
				if (bus.isFull()) {
					break;
				} else if (bus.countAvailablePlaces() >= familyList.get(i).getCount()) {
					bus.addFamily(familyList.get(i));
					familyList.remove(i);
				}
			}
		}
		return buses;
	}

	public Map<String, List<Passenger>> groupByTravelTo(List<Passenger> familyList) {
		return familyList.stream()
				.collect(Collectors.groupingBy(Passenger::getTravelTo, Collectors.toCollection(LinkedList::new)));
	}
}

class Plane {
	private static final int MAX_PASSENGERS = 100;
	private final int id;
	private List<Passenger> families;

	public Plane(int id, List<Passenger> AirCar) {
		this.id = id;
		this.families = AirCar;
	}

	public static Plane of(int id, List<Passenger> families) {
		if (!isValidFamiliesList(families)) {
			throw new IllegalArgumentException("Families count must be less or equal to maximum passengers count");
		}
		return new Plane(id, families);
	}

//    public boolean setFamilies(List<Family> families) {
//        if (!isValidFamiliesList(families)) {
//            return false;
//        }
//        this.families = families;
//        return true;
//    }

	private static boolean isValidFamiliesList(List<Passenger> families) {
		return families != null && families.stream().mapToInt(Passenger::getCount).sum() <= MAX_PASSENGERS;
	}

	public int getId() {
		return id;
	}

	public List<Passenger> getFamilies() {
		return new ArrayList<>(families);
	}
}

class Passenger {
	private String name;
	private String travelTo;
	private int count;

	public Passenger(String name, String travelTo, int count) {
		this.name = name;
		this.travelTo = travelTo;
		this.count = count;
	}

	public static Passenger of(String name, String travelTo, int count) {
		if (!isValidCount(count)) {
			throw new IllegalArgumentException("Count must be positive!");
		}
		return new Passenger(name, travelTo, count);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTravelTo() {
		return travelTo;
	}

	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (!isValidCount(count)) {
			throw new IllegalArgumentException("Count must be positive!");
		}
		this.count = count;
	}

	private static boolean isValidCount(int count) {
		return count > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Passenger family = (Passenger) o;

		if (count != family.count)
			return false;
		if (name != null ? !name.equals(family.name) : family.name != null)
			return false;
		return travelTo != null ? travelTo.equals(family.travelTo) : family.travelTo == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (travelTo != null ? travelTo.hashCode() : 0);
		result = 31 * result + count;
		return result;
	}

	@Override
	public String toString() {
		return "Family{" + "name='" + name + '\'' + ", travelTo='" + travelTo + '\'' + ", count=" + count + '}';
	}
}

class AirBus {
	private final int capacity;
	private String driveTo;

	private final List<Passenger> families;

	public AirBus(int maxPassengers, String driveTo) {
		this.capacity = maxPassengers;
		this.driveTo = driveTo;
		this.families = new LinkedList<>();
	}

	public boolean isEnoughSpaceForFamily(Passenger family) {
		return families.stream().mapToInt(Passenger::getCount).sum() + family.getCount() <= capacity;
	}

	public int countAvailablePlaces() {
		return capacity - families.stream().mapToInt(Passenger::getCount).sum();
	}

	public boolean addFamily(Passenger family) {
		if (isEnoughSpaceForFamily(family)) {
			return families.add(family);
		}
		return false;
	}

	public int getPassengersCount() {
		return families.stream().mapToInt(Passenger::getCount).sum();
	}

	public String getDriveTo() {
		return driveTo;
	}

	public void setDriveTo(String driveTo) {
		this.driveTo = driveTo;
	}

	public boolean isFull() {
		return families.stream().mapToInt(Passenger::getCount).sum() == capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Passenger> getFamilies() {
		return new ArrayList<>(families);
	}

	@Override
	public String toString() {
		return "Bus{" + "capacity=" + capacity + ", driveTo='" + driveTo + '\'' + ", families=" + families + '}';
	}
}

class BusFactory {
	private static final int MAX_CAPACITY = 8;
	private static final int MIN_CAPACITY = 6;

	public static AirBus createBus(int capacity, String driveTo) {
		if (capacity < MIN_CAPACITY || capacity > MAX_CAPACITY) {
			throw new IllegalArgumentException("Capacity should lie within range!");
		}
		return new AirBus(capacity, driveTo);
	}

	public static AirBus createBus(String driveTo) {
		return new AirBus(current().nextInt(MIN_CAPACITY, MAX_CAPACITY + 1), driveTo);
	}
}

class FamilyGenerator {
	private static final List<String> CITIES = List.of("Kalush", "Kosiv", "Galych", "Kolomiya");

	public static Passenger generate(int minFamilyCount, int maxFamilyCount) {
		return new Passenger(generateFamilyName(), generateCity(),
				current().nextInt(minFamilyCount, maxFamilyCount + 1));
	}

	public static String generateFamilyName() {
		return String.valueOf((char) current().nextInt(97, 123)) + current().nextInt(10) + current().nextInt(10);
	}

	public static String generateCity() {
		return CITIES.get(current().nextInt(CITIES.size()));
	}

	public static List<Passenger> generateList(int minFamilyCount, int maxFamilyCount, int totalFamilyCount) {
		List<Passenger> families = new ArrayList<>();
		int members = 0;

		while (members + maxFamilyCount <= totalFamilyCount) {
			Passenger family = generate(minFamilyCount, maxFamilyCount);
			families.add(family);
			members += family.getCount();
		}

		families.add(new Passenger(generateFamilyName(), generateCity(), totalFamilyCount - members));

		return families;
	}
}

class PlaneGenerator {
	public static Plane generate(int minFamilyCount, int maxFamilyCount, int totalCount) {
		return new Plane(current().nextInt(1, Integer.MAX_VALUE),
				FamilyGenerator.generateList(minFamilyCount, maxFamilyCount, totalCount));
	}

	public static List<Plane> generateList(int minFamilyCount, int maxFamilyCount, int totalPassengers,
			int totalPlanes) {
		return IntStream.range(0, totalPlanes).mapToObj(x -> generate(minFamilyCount, maxFamilyCount, totalPassengers))
				.toList();
	}
}

class TimerUtil {
	private long startTime;
	private long endTime;

	private boolean isStarted = false;

	public void start() {
		if (!isStarted) {
			startTime = System.currentTimeMillis();
			isStarted = true;
		}
	}

	public void end() {
		if (isStarted) {
			endTime = System.currentTimeMillis();
			isStarted = false;
		}
	}

	public void reset() {
		isStarted = false;
		startTime = 0;
		endTime = 0;
	}

	public long getPassedTimeInMs() {
		return endTime - startTime;
	}
}

class PassengersDistributorTest {

	@Test
	void passengersAtTheBeginningShouldBeSameAsAtTheEnd() {
		var familiesList1 = List.of(Passenger.of("a01", "Kalush", 2), Passenger.of("a12", "Kalush", 4),
				Passenger.of("a02", "Kalush", 3), Passenger.of("a03", "Kalush", 1));
		var familiesList2 = List.of(Passenger.of("a04", "Kalush", 4), Passenger.of("a09", "Galych", 4),
				Passenger.of("a05", "Kosiv", 4), Passenger.of("a06", "Kosiv", 4));

		var familiesList3 = List.of(Passenger.of("a07", "Kosiv", 4), Passenger.of("a08", "Kosiv", 4),
				Passenger.of("a10", "Galych", 4), Passenger.of("a11", "Galych", 4));

		List<Plane> planes = List.of(new Plane(1, familiesList1), new Plane(2, familiesList2),
				new Plane(3, familiesList3));

		List<AirBus> resultBusList = Service.distributePassengersMultithreading(planes);

		assertNotNull(resultBusList);

		Comparator<Passenger> familyComparator = Comparator.comparing(Passenger::getName)
				.thenComparing(Passenger::getCount);

		var expectedPassengersList = Stream.of(familiesList1, familiesList2, familiesList3).flatMap(Collection::stream)
				.sorted(familyComparator).toList();

		var actualPassengersLst = resultBusList.stream().flatMap(bus -> bus.getFamilies().stream())
				.sorted(familyComparator).toList();

		assertEquals(expectedPassengersList, actualPassengersLst);
	}

	@ParameterizedTest
	@MethodSource("familiesListsGenerator")
	void busses_shouldNotBeOverfilled(List<Passenger> families) {
		PassengersDistributor passengersDistributor = new PassengersDistributor(families);

		var actualBuses = passengersDistributor.call();

		assertNotNull(actualBuses);

		for (var bus : actualBuses) {
			assertTrue(bus.getPassengersCount() > 0 && bus.getPassengersCount() <= bus.getCapacity());
		}
	}

	private static List<Passenger> familiesGenerator() {
		var cities = List.of("Kalush", "Kosiv", "Galych", "Kolomiya");
		int amountOfFamilies = 10;
		int maxFamilyCount = 4;
		int minFamilyCount = 1;

		Set<Passenger> familiesSet = new HashSet<>();

		while (familiesSet.size() != amountOfFamilies) {
			familiesSet
					.add(new Passenger(
							String.valueOf((char) current().nextInt(97, 123)) + current().nextInt(10)
									+ current().nextInt(10),
							cities.get(current().nextInt(cities.size())),
							current().nextInt(minFamilyCount, maxFamilyCount - 1)));
		}
		return familiesSet.stream().toList();
	}

	private static Stream<Arguments> familiesListsGenerator() {
		int amountOfTests = 10;

		return IntStream.range(0, amountOfTests).mapToObj(x -> Arguments.of(familiesGenerator()));
	}
}