package com.homework.io.serializable;

import java.util.Collections;
import java.util.List;

public class Dispatcher {
	private final static String outputfileShip = "SHIPS";
	private final static String outputfilePlane = "PLANES";
	private final static Controller controller = new Controller();

	public static void main(String[] args) {
		
		run(outputfileShip);
		run(outputfilePlane);	

	}

	private static void run(String outputfile) {

		switch (outputfile) {
		case "SHIPS":
			execute(controller.getShips(), outputfile);
			break;
		case "PLANES":
			execute(controller.getPlanes(), outputfile);
			break;
		}
	}

	private static void execute(List<Vehicle> arrayList, String outputfile) {
		Collections.sort(arrayList);
		controller.write(arrayList, outputfile);
		List<Vehicle> vehicles = controller.read(outputfile);
		controller.check(arrayList, vehicles);
	}
}
