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
	private final ArrayList<Point> points;
	private final ArrayList<Line> lines;

	public Controller() {
		this.dao = new Dao();
		this.points = dao.getPoints();
		this.lines = dao.getLines();
	}

	public void write(String outputfile, Object... objects) {

		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputfile))) {

			output.writeObject(objects);

			System.out.printf("File %s was written%n", outputfile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void read(String outputfile) {

		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(outputfile))) {
			Object[] readObject = (Object[]) input.readObject();

			for (var object : readObject) {
				if (object instanceof HashMap) {
					HashMap map = ((HashMap) object);
					for (var key : map.keySet()) {
						if (key instanceof Line) {
							dao.addToLines((Line) key, (Long) map.get(key));
						}
						if (key instanceof Point) {
							dao.addToPoints((Point) key, (Long) map.get(key));
						}
					}
				}
			}
			System.out.printf("File %s was read%n", outputfile);
		} catch (IOException | ClassNotFoundException e) {
			System.out.printf("%s%n", e.getMessage());
		}
//		return shapes;
	}

	public void check(HashMap map) {

		for (var key : map.keySet()) {
			if (key instanceof Line) {
				assertEquals(dao.getLineMap().get(key), map.get(key));
				System.out.printf("%s intersections %s object(s)%n", key, map.get(key));
			}
			if (key instanceof Point) {
				assertEquals(dao.getPointMap().get(key), map.get(key));
				System.out.printf("%s intersections %s object(s)%n", key, map.get(key));
			}
		}
	}

	public HashMap<Point, Long> getPointMap() {
		HashMap<Point, Long> pointMap = new HashMap<>();
		points.forEach(point -> pointMap.put(point, point.setCounter(lines)));
		return pointMap;
	}

	public HashMap<Line, Long> getLineMap() {
		HashMap<Line, Long> lineMap = new HashMap<>();
		lines.forEach(line -> lineMap.put(line, line.setCounter(points)));
		return lineMap;
	}
}
