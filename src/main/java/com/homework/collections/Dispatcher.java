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
		
		controller.read(outputfile);

//        var lineMapFromFile = res.getKey();
//        var pointMapFromFile = res.getValue();

//        System.out.println(lineMapFromFile);
//        System.out.println(pointMapFromFile);
//
		controller.check(pointMap);
		controller.check(lineMap);
	}
}
