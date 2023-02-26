package com.classwork.threads.airport.a;

import java.util.List;
import java.util.stream.Collectors;

class Tester {

	public static void getTestHowManyPeopleTravelToEachDirection() {
		BorderService.allArriving.stream()
				.collect(Collectors.groupingBy(Family::getTravelTo, Collectors.summingInt(Family::getMembers)))
				.forEach((key, value) -> System.out.println(key + " " + value));
	}

	public static void getAllFamilies() {
		BorderService.allArriving.forEach(System.out::println);
	}

	public static void setFamilyForTest(Family family) {
		BorderService.allArriving.add(family);
	}

	public static void setEveryoneTravelToOneDirection(List<Plane> arrivalList, String travelTo) {
		arrivalList.forEach(plane -> plane.getFamilies().forEach(family -> family.setTravelTo(travelTo)));
	}
}
