package com.homework.shape;


class Quadrilateral extends Shape {

	Point a;
	Point b;
	Point c;
	Point d;

	private Triangle abc;
	private Triangle cda;

	int width;
	int height;
	double ac;

	public Quadrilateral(Point a, Point b, Point c, Point d) {

		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		abc = new Triangle(a, b, c);
		cda = new Triangle(c, d, a);
	}

	@Override
	double area() {
		return abc.area() + cda.area();
	}

	@Override
	String draw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return String.format("Quadrilateral [a=%s, b=%s, c=%s, d=%s, abc=%s, cda=%s, width=%d, height=%d, ac=%f]", a, b,
				c, d, abc, cda, width, height, ac);
	}
}