package com.classwork.threads.airport.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class Dispatcher {
	
	public static void main(String[] args) {

		Plane plane1 = new Plane(1, new ArrayList<Family>());
		plane1.setRandomFamilies("aa");
		Plane plane2 = new Plane(2, new ArrayList<Family>());
		plane2.setRandomFamilies(plane1.getFamilies().get(plane1.getFamilies().size() - 1).getName());
		Plane plane3 = new Plane(3, new ArrayList<Family>());
		plane3.setRandomFamilies(plane2.getFamilies().get(plane2.getFamilies().size() - 1).getName());

		System.out.println(plane1);
		System.out.println(plane2);
		System.out.println(plane3);
		
		List<Plane> planes = new ArrayList<>();
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);

//		Map<City, List<Bus>> buses = Controller.runSingleThread(planes);
		
		Map<City, List<Bus>> buses = Controller.runMultiThread(planes);

		System.out.println(buses);
	}
	
}
