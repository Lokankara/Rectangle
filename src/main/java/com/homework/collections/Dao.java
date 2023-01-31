package com.homework.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class Dao {
	
	private final int max = 5;
	private final Random random = new Random();
	private final HashMap<Line, Long> lineMapFromFile = new HashMap<>();
	private final HashMap<Point, Long> pointMapFromFile = new HashMap<>();
	
	public ArrayList<Point> getPoints() {
		var points = new ArrayList<Point>(Arrays.asList(
				new Point(1, 3), 
				new Point(3, 2), 
				new Point(0, 1), 
				new Point(1, 1), 
				new Point(1, 9), 
				new Point(0, 5)));
		points.addAll(generatePoint());
		return points;
	}

	public ArrayList<Line> getLines() {
		return new ArrayList<Line>(Arrays.asList(
				new Line(3, 1), 
				new Line(4, 5), 
				new Line(2, -1), 
				new Line(2, 1)));
	}
	
	private ArrayList<Point> generatePoint() {
		
		return new ArrayList<Point>(Arrays.asList(
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)) 
				));		
	}

	public HashMap<Line, Long> getLineMap() {
		return lineMapFromFile;
	}

	public HashMap<Point, Long> getPointMap() {
		return pointMapFromFile;
	}

	public void addToLines(Line key, Long value) {
		lineMapFromFile.put(key, value);
	}

	public void addToPoints(Point key, Long value) {
		pointMapFromFile.put(key, value);
	}
}
