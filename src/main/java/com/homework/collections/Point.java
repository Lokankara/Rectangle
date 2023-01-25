package com.homework.collections;

import java.util.ArrayList;
import java.util.Objects;

class Point extends Shape {
	private static final long serialVersionUID = 78291364212465L;
	private int x;
	private int y;
	private long lineCounter;

	public boolean intersection(Line line) {
		return (this.y == line.k() * this.x + line.b()) ? true : false;
	}
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int x() {
		return x;
	}
	public void x(int x) {
		this.x = x;
	}
	public int y() {
		return y;
	}
	public void y(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		return 11 * Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
	@Override
	public String toString() {
		return String.format("Point  (%d, %d)", x, y);
	}
	@Override
	public long setCounter(ArrayList<? extends Shape> lines) {
		for (Shape line : lines) {
			if(intersection((Line)line)) {lineCounter++;}
		}
		super.setCounter(lineCounter);
		return lineCounter;
	}
}