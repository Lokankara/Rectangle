package com.homework.collections;

import java.util.HashMap;

public class Dispatcher {

	private final static String outputfile = "LINES";
	private final static Controller controller = new Controller();

	public static void main(String[] args) {

		HashMap<Point, Long> pointMap = controller.getPointMap();
		HashMap<Line, Long> lineMap = controller.getLineMap();

		controller.write(outputfile, pointMap, lineMap);

		controller.read(outputfile);

		controller.check(pointMap);
		controller.check(lineMap);
	}
}
