//package com.homework.collections;
//import static org.junit.Assert.assertEquals;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Objects;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Random;
//
//public class Main {
//
//	private final static String outputfile = "LINES";
//	private final static Controller controller = new Controller();
//	private final static ArrayList<Shape> points = controller.getPoints();
//	private final static ArrayList<Shape> lines = controller.getLines();
//
//	public static void main(String[] args) {
//
//		HashMap<Shape, Long> maps = controller.joinToMap(points, lines);
//		controller.write(outputfile, maps);
//
//		HashMap<Shape, Long> mapsFromFile = controller.read(outputfile);
//
//		controller.check(mapsFromFile);
//	}
//}
//
//class Controller {
//
//	private final Dao dao;
//
//	public Controller() {
//		this.dao = new Dao();
//	}
//
//	public ArrayList<Shape> getPoints() {
//		return dao.getPoints();
//	}
//
//	public ArrayList<Shape> getLines() {
//		return dao.getLines();
//	}
//
//	public void write(String outputfile, HashMap<Shape, Long> shapeMap) {
//
//		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputfile))) {
//			output.writeObject(shapeMap);
//			System.out.printf("File %s was written%n", outputfile);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public HashMap<Shape, Long> read(String outputfile) {
//		
//		HashMap<Shape, Long> shapes = new HashMap<>();
//
//		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(outputfile))) {
//			shapes = (HashMap<Shape, Long>) input.readObject();
//			System.out.printf("File %s was read%n", outputfile);
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.printf("%s%n", e.getMessage());
//		}
//		return shapes;
//	}
//
//	public HashMap<Shape, Long> joinToMap(ArrayList<Shape> points, ArrayList<Shape> lines) {
//
//		HashMap<Shape, Long> shapeMap = new HashMap<>();
//		HashMap<Shape, Long> pointMap = dao.getPointsMap();
//		HashMap<Shape, Long> lineMap = dao.getLineMap();
//
//		points.forEach(point -> pointMap.put(point, point.setCounter(lines)));
//		lines.forEach(line -> lineMap.put(line, line.setCounter(points)));
//
//		shapeMap.putAll(lineMap);
//		shapeMap.putAll(pointMap);
//		return shapeMap;
//	}
//
//	public void check(HashMap<Shape, Long> maps) {
//
//		for (Shape shape : maps.keySet()) {
//			if (shape instanceof Line) {
//				assertEquals(dao.getLineMap().get(shape), maps.get(shape));
//				System.out.printf("%s intersections %s object(s)%n", shape, maps.get(shape));
//			}
//			if (shape instanceof Point) {
//				assertEquals(dao.getPointsMap().get(shape), maps.get(shape));
//				System.out.printf("%s intersections %s object(s)%n", shape, maps.get(shape));
//			}
//		}
//	}
//}
//
//
//class Dao {
//	
//	private final int max = 5;
//	private final Random random = new Random();
//	private final HashMap<Shape, Long> lineMap = new HashMap<>();
//	private final HashMap<Shape, Long> pointMap = new HashMap<>();
//
//	public ArrayList<Shape> getPoints() {
//		var points = new ArrayList<Shape>(Arrays.asList(
//				new Point(1, 3), 
//				new Point(3, 2), 
//				new Point(0, 1), 
//				new Point(1, 1), 
//				new Point(1, 9), 
//				new Point(0, 5)));
//		points.addAll(generatePoint());
//		return points;
//	}
//
//	public ArrayList<Shape> getLines() {
//		return new ArrayList<Shape>(Arrays.asList(
//				new Line(3, 1), 
//				new Line(4, 5), 
//				new Line(2, -1), 
//				new Line(2, 1)));
//	}
//	
//	private ArrayList<Shape> generatePoint() {
//		
//		return new ArrayList<Shape>(Arrays.asList(
//				new Point(random.nextInt(max), random.nextInt(max)), 
//				new Point(random.nextInt(max), random.nextInt(max)), 
//				new Point(random.nextInt(max), random.nextInt(max)), 
//				new Point(random.nextInt(max), random.nextInt(max)), 
//				new Point(random.nextInt(max), random.nextInt(max)) 
//				));		
//	}
//
//	public HashMap<Shape, Long> getPointsMap() {
//		return pointMap;
//	}
//
//	public HashMap<Shape, Long> getLineMap() {
//		return lineMap;
//	}
//}
//
//class Line extends Shape implements Comparator<Point>{
//	private static final long serialVersionUID = -78291364212463245L;
//	private Point o;
//	private int k;
//	private int b;
//	private long pointCounter;
//	
//	public Line(int k, int b) {
//		super();
//		this.k = k;
//		this.b = b;
//	}
//	public int b() {
//		return b;
//	}
//	public void b(int b) {
//		this.b = b;
//	}
//	public int k() {
//		return k;
//	}
//	public void t(int k) {
//		this.k = k;
//	}
//	public boolean intersection(Point m) {
//		return m.y() == k * m.x() + b ? true : false;
//	}
//	public Point getO() {
//		return o;
//	}
//	public void setO(Point o) {
//		if(intersection(o)) {
//			this.o = o;
//			this.setCounter(this.getCounter() + 1);
//		}
//	}
//	@Override
//	public int hashCode() {
//		return 17 * Objects.hash(b, k);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Line other = (Line) obj;
//		return b == other.b && k == other.k;
//	}
//	@Override
//	public String toString() {
//		return String.format("Line  f(%s%dx%s%d)", k < 0 ? "-" : "", k, b < 0 ? "" : "+", b);
//	}
//	@Override
//	public long setCounter(ArrayList<? extends Shape> points) {
//		for(Shape point: points) {
//			if(intersection((Point)point)) {pointCounter++;}			
//		}
//		super.setCounter(pointCounter);
//		return pointCounter;
//	}
//	@Override
//	public int compare(Point a, Point b) {
//		return (o.y() - a.y()) / (b.y() - a.y()) - (o.x() - a.x()) / (b.x() - a.x());
//	}
//}
//
//class Point extends Shape {
//	private static final long serialVersionUID = 78291364212465L;
//	private int x;
//	private int y;
//	private long lineCounter;
//
//	public boolean intersection(Line line) {
//		return (this.y == line.k() * this.x + line.b()) ? true : false;
//	}
//	public Point() {
//		super();
//	}
//	public Point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//	public int x() {
//		return x;
//	}
//	public void x(int x) {
//		this.x = x;
//	}
//	public int y() {
//		return y;
//	}
//	public void y(int y) {
//		this.y = y;
//	}
//	@Override
//	public int hashCode() {
//		return 11 * Objects.hash(x, y);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Point other = (Point) obj;
//		return x == other.x && y == other.y;
//	}
//	@Override
//	public String toString() {
//		return String.format("Point  (%d, %d)", x, y);
//	}
//	@Override
//	public long setCounter(ArrayList<? extends Shape> lines) {
//		for (Shape line : lines) {
//			if(intersection((Line)line)) {lineCounter++;}
//		}
//		super.setCounter(lineCounter);
//		return lineCounter;
//	}
//}
//
//abstract class Shape implements Serializable{
//	private static final long serialVersionUID = 291364212463245L;
//	private long counter;
//	public long getCounter() {
//		return counter;
//	}
//	protected void setCounter(long count) {
//		this.counter = count;
//	}
//	protected abstract long setCounter(ArrayList<? extends Shape> shapes);
//}