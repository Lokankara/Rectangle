package com.homework.shape;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

abstract class Shape {

	int centerX;
	int centerY;
	static String sign = ".";
	static String ENTER = "\n";

	abstract double area();

	abstract String draw();

	public int x() {
		return centerX;
	}

	public int y() {
		return centerY;
	}
}