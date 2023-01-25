package com.homework.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class Dao {
	
	private final int max = 5;
	private final Random random = new Random();
	private final HashMap<Shape, Long> lineMap = new HashMap<>();
	private final HashMap<Shape, Long> pointMap = new HashMap<>();

	public ArrayList<Shape> getPoints() {
		var points = new ArrayList<Shape>(Arrays.asList(
				new Point(1, 3), 
				new Point(3, 2), 
				new Point(0, 1), 
				new Point(1, 1), 
				new Point(1, 9), 
				new Point(0, 5)));
		points.addAll(generatePoint());
		return points;
	}

	public ArrayList<Shape> getLines() {
		return new ArrayList<Shape>(Arrays.asList(
				new Line(3, 1), 
				new Line(4, 5), 
				new Line(2, -1), 
				new Line(2, 1)));
	}
	
	private ArrayList<Shape> generatePoint() {
		
		return new ArrayList<Shape>(Arrays.asList(
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)), 
				new Point(random.nextInt(max), random.nextInt(max)) 
				));		
	}

	public HashMap<Shape, Long> getPointsMap() {
		return pointMap;
	}

	public HashMap<Shape, Long> getLineMap() {
		return lineMap;
	}
}
