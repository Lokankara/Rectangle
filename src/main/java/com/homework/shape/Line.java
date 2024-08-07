package com.homework.shape;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

class Line extends Figure {

	private Point a;
	private Point b;
	private double ab;

	public Point a() {
		return a;
	}

	public void a(Point a) {
		this.a = a;
	}

	public Point b() {
		return b;
	}

	public void b(Point b) {
		this.b = b;
	}

	public Line(Point a, Point b) {
		super();
		this.a = a;
		this.b = b;
		ab  = sqrt(pow(b.x(), 2) + pow(a.y(), 2));		
	}

	@Override
	double area() {
		return ab;
	}

	@Override
	String draw() {
		return sign.repeat((int) ab);
	}

	@Override
	public String toString() {
		return "Line [a=" + a + ", b=" + b + ", ab=" + ab + "]";
	}
}
