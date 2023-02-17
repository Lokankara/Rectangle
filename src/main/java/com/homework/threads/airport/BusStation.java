package com.homework.threads.airport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.homework.threads.airport.Controller.cities;

class BusStation {

	Map<String, List<Bus>> buses;
	List<Bus> Kalush = new ArrayList<>();
	Queue<Family> toKalush;
	Queue<Family> toKosiv;
	Queue<Family> toGalych;
	Queue<Family> toKolomiya;

	private static BusStation station;

	public static BusStation getStation() {
		return station == null ? station = new BusStation() : station;
	}

	Predicate<Family> kalush = family -> family.getTravelTo() == cities.get(0);
	Predicate<Family> kosiv = family -> family.getTravelTo() == cities.get(1);
	Predicate<Family> galych = family -> family.getTravelTo() == cities.get(2);
	Predicate<Family> kolomiya = family -> family.getTravelTo() == cities.get(3);

	private BusStation() {
		this.buses = new ConcurrentHashMap<String, List<Bus>>();
		this.toKalush = new PriorityBlockingQueue<>(5, new FamilyComparator());
		this.toKosiv = new PriorityBlockingQueue<>(5, new FamilyComparator());
		this.toGalych = new PriorityBlockingQueue<>(5, new FamilyComparator());
		this.toKolomiya = new PriorityBlockingQueue<>(5, new FamilyComparator());
	}

	void boarding(List<Family> arrivedPassengers) {
		System.out.printf("%s families went at the Gate%n", arrivedPassengers.size());
		buyTicket(arrivedPassengers);
	}

	void buyTicket(List<Family> arrivedPassengers) {

		toKalush.addAll(arrivedPassengers.stream().filter(kalush).collect(Collectors.toList()));
		toKosiv.addAll(arrivedPassengers.stream().filter(kosiv).collect(Collectors.toList()));
		toGalych.addAll(arrivedPassengers.stream().filter(galych).collect(Collectors.toList()));
		toKolomiya.addAll(arrivedPassengers.stream().filter(kolomiya).collect(Collectors.toList()));
		arrivedPassengers.clear();

		View.display(String.format("To Kalush boarding %s families at the Bus Station%n", toKalush.size()));
		View.display(String.format("To Kosiv boarding %s families at the Bus Station%n", toKosiv.size()));
		View.display(String.format("To Galych boarding %s families at the Bus Station%n", toGalych.size()));
		View.display(String.format("To Kolomiya boarding %s families at the Bus Station%n", toKolomiya.size()));

		buses.putAll(Controller.buildBuses("Kalush", toKalush));
		buses.putAll(Controller.buildBuses("Kosiv", toKosiv));
		buses.putAll(Controller.buildBuses("Galych", toGalych));
		buses.putAll(Controller.buildBuses("Kolomiya", toKolomiya));

		departure();

	}

	public void departure() {
		Set<String> keySet = buses.keySet();
		for (String key : keySet) {
			System.err.println(buses.get(key));
		}


	}

	public void departure(Bus bus) {
		// TODO Auto-generated method stub

	}
}

class FamilyComparator implements Comparator<Family> {

	@Override
	public int compare(Family a, Family b) {
		return Integer.compare(b.getCount(), a.getCount());
	}
}

//private final AtomicBoolean lock = new AtomicBoolean(false);
//
//synchronized void transform() {
//    while (!lock.get()) {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println("InterruptedException");
//        }
//    }
//    station.transform();
//    lock.set(false);
//    notifyAll();
//    
//}
//
//synchronized void count(BusStation station) {
//    while (lock.get()) {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println("InterruptedException");
//        }
//    }
//    this.station = station;
//    station.count();
//    lock.set(true);
//    notifyAll();
//
//
//}