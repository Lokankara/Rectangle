package com.homework.collections;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

class Controller {

	private final Dao dao;

	public Controller() {
		this.dao = new Dao();
	}

	public ArrayList<Shape> getPoints() {
		return dao.getPoints();
	}

	public ArrayList<Shape> getLines() {
		return dao.getLines();
	}

	public void write(String outputfile, HashMap<Shape, Long> shapeMap) {

		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputfile))) {
			output.writeObject(shapeMap);
			System.out.printf("File %s was written%n", outputfile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public HashMap<Shape, Long> read(String outputfile) {
		
		HashMap<Shape, Long> shapes = new HashMap<>();

		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(outputfile))) {
			shapes = (HashMap<Shape, Long>) input.readObject();
			System.out.printf("File %s was read%n", outputfile);
		} catch (IOException | ClassNotFoundException e) {
			System.out.printf("%s%n", e.getMessage());
		}
		return shapes;
	}

	public HashMap<Shape, Long> joinToMap(ArrayList<Shape> points, ArrayList<Shape> lines) {

		HashMap<Shape, Long> shapeMap = new HashMap<>();
		HashMap<Shape, Long> pointMap = dao.getPointsMap();
		HashMap<Shape, Long> lineMap = dao.getLineMap();

		points.forEach(point -> pointMap.put(point, point.setCounter(lines)));
		lines.forEach(line -> lineMap.put(line, line.setCounter(points)));

		shapeMap.putAll(lineMap);
		shapeMap.putAll(pointMap);
		return shapeMap;
	}

	public void check(HashMap<Shape, Long> maps) {

		for (Shape shape : maps.keySet()) {
			if (shape instanceof Line) {
				assertEquals(dao.getLineMap().get(shape), maps.get(shape));
				System.out.printf("%s intersections %s object(s)%n", shape, maps.get(shape));
			}
			if (shape instanceof Point) {
				assertEquals(dao.getPointsMap().get(shape), maps.get(shape));
				System.out.printf("%s intersections %s object(s)%n", shape, maps.get(shape));
			}
		}
	}
}
