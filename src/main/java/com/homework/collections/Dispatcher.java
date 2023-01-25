package com.homework.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class Dispatcher {

	private final static String outputfile = "LINES";
	private final static Controller controller = new Controller();
	private final static ArrayList<Shape> points = controller.getPoints();
	private final static ArrayList<Shape> lines = controller.getLines();

	public static void main(String[] args) {

		HashMap<Shape, Long> maps = controller.joinToMap(points, lines);
		controller.write(outputfile, maps);

		HashMap<Shape, Long> mapsFromFile = controller.read(outputfile);

		controller.check(mapsFromFile);
	}
}
