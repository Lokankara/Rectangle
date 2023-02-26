package com.classwork.threads.airport.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

class Controller {
	
	private static Map<City, List<Bus>> busStation = new ConcurrentHashMap<>();

	private static void makeNewStation() {
		busStation.clear();
		busStation.put(City.KALUSH, new ArrayList<Bus>());
		busStation.put(City.KOSIV, new ArrayList<Bus>());
		busStation.put(City.GALYCH, new ArrayList<Bus>());
		busStation.put(City.KOLOMIYA, new ArrayList<Bus>());
	}

	public static Map<City, List<Bus>> runMultiThread(List<Plane> planes) {
		Controller.makeNewStation();
		long startTimeNanos = System.nanoTime();
		ArrayList<Thread> threadsList = new ArrayList<>();
		for (Plane p : planes) {
			threadsList.add(new Thread(p, "" + p.getID()));
		}
		for (Thread temp : threadsList) {
			temp.start();
		}
//		try {
//			for (Thread temp : threadsList) {
//				temp.join();
//			}
//		} catch (InterruptedException ie) {
//			System.out.println("Error! Some thread was interrupted.");
//		}

		System.out.println("Execution time : " + (System.nanoTime() - startTimeNanos) + " nanos.");
		return busStation;
	}

	public static Map<City, List<Bus>> runSingleThread(List<Plane> planes) {
		Controller.makeNewStation();
		long startTimeNanos = System.nanoTime();
		for (Plane p : planes) {
			System.out.println("Service of plane with ID " + p.getID() + " is started.");

			for (Family f : p.getFamilies()) {
				boardAFamily.accept(f);
			}
			p.freePassengers();

			System.out.println("Service of plane with ID " + p.getID() + " is finished.");
		}

		System.out.println(System.nanoTime() - startTimeNanos);
		return busStation;
	}

	public static Function<City, Bus> callNewBus = (city) -> {
		Bus newBus = new Bus(city, (int) (Math.random() * 3 + 6));
		busStation.get(city).add(newBus);
		return newBus;
	};

	public static Consumer<Family> boardAFamily = (f) -> {
		int members = f.getCount();
		for (Bus bus : busStation.get(f.getTravelTo())) {
			synchronized (bus) {
				if (bus.getPassengersCount() + members - 1 < bus.getPassengersCapacity()) {
					bus.addPassengers(members);
					return;
				}
			}
		}
		callNewBus.apply(f.getTravelTo()).addPassengers(members);
	};

}