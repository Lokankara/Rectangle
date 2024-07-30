package com.classwork.threads.airport.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Plane> arrivalList = Controller.createPlanes();
		System.out.println("Arrive " + arrivalList.size() + " planes");
//		Tester.setFamilyForTest(new Family(4, "Millers", 1, "Kiev"));
//        Tester.setEveryoneTravelToOneDirection(arrivalList, "Kiev");
//
		BorderService.arrivalToAirport(arrivalList);
//
		Tester.getTestHowManyPeopleTravelToEachDirection();
        Tester.getAllFamilies();

	}
}

class BorderService {
	public static List<Family> allArriving = new ArrayList<>();

	public static void arrivalToAirport(List<Plane> planeList) {
		planeList.forEach(plane -> allArriving.addAll(plane.getFamilies()));		
		sortByCity(allArriving);
	}
	
	public static void sortByCity(List<Family> familyList) {
		System.out.println("Total people arrived "
				+ familyList.stream().collect(Collectors.summarizingLong(Family::getMembers)).getSum());

		Map<String, List<Family>> sortedToCityMap = familyList.stream()
				.collect(Collectors.groupingBy(Family::getTravelTo, Collectors.toList()));

		for (Map.Entry<String, List<Family>> cityTo : sortedToCityMap.entrySet()) {
			new GateRunnable(cityTo.getKey(), cityTo.getValue());
		}
	}
}


