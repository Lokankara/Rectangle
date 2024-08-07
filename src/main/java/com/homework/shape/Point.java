package com.homework.shape;

class Point extends Figure {

	protected int x;
	protected int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void y(int y) {
		this.y = y;
	}

	public void x(int x) {
		this.x = x;
	}

	public int y() {
		return this.y;
	}

	public int x() {
		return this.x;
	}

	public Point() {
		this.x = 1;
		this.y = 1;
	}

	@Override
	double area() {
		return 1;
	}

	@Override
	String draw() {
		return sign;
	}

	@Override
	public String toString() {
		return String.format("Point [x=%d, y=%d]", x, y);
	}
}
