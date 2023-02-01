package com.homework.shape;

import java.util.Arrays;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

/**
 * @author PPoliak
 *
 */
 class Shapes {

	private static final int LENGTH = 4;

	private static final Point A = new Point();
	private static final Point B = new Point();
	private static final Point C = new Point();
	private static final Point D = new Point();

	public static final String SYMBOL = ".";
	public static final String SPACE = " ";
	public static final String ENTER = "\n";

	public static void main(String[] args) {
		String[] forms = new String[5];

		A.x(0);
		A.y(LENGTH);
		B.x(0);
		B.y(0);
		C.x(LENGTH);
		C.y(0);
		D.x(LENGTH);
		D.y(LENGTH);

		Triangle shape = new Triangle(A, B, C);

		forms[0] = shape.rectangle(LENGTH, LENGTH, SYMBOL);
		forms[1] = shape.aQuadrant(SYMBOL, SPACE);
		forms[2] = shape.bQuadrant(SYMBOL);
		forms[3] = shape.cQuadrant(SYMBOL);
		forms[4] = shape.dQuadrant(SYMBOL, SPACE);

		levelOne(forms, shape);
		levelTwo(forms, shape);
		levelThreeA();
		levelThreeB();
	}

	private static void levelThreeB() {
		String[] forms = new String[5];

		A.y(5);
		C.x(5);
		Triangle shape = new Triangle(A, B, C);

		String aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
		String bQuadrant = shape.bQuadrant(SYMBOL);
		forms[0] = shape.pyramidJoiner(aQuadrant, bQuadrant);
		forms[1] = shape.rectangle(5, 9, SYMBOL);
		forms[2] = shape.trapezoid(aQuadrant, forms[1], bQuadrant);
		forms[3] = shape.rectangle(5, 9, SYMBOL);

		A.y(9);
		C.x(9);
		shape = new Triangle(A, B, C);

		aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
		bQuadrant = shape.bQuadrant(SYMBOL);
		String rectangle = shape.rectangle(9, 9, SYMBOL);
		forms[4] = shape.trapezoid(aQuadrant, rectangle, bQuadrant);

		String middle = middle(forms);

		System.out.println(middle);
	}

	private static void levelThreeA() {
		String[] forms = new String[4];

		A.y(4);
		C.x(4);
		forms[0] = pyramid(A, B, C);

		A.y(5);
		C.x(5);
		forms[1] = pyramid(A, B, C);

		A.y(6);
		C.x(6);
		forms[2] = pyramid(A, B, C);

		A.y(2);
		C.x(3);
		forms[3] = new Triangle(A, B, C).rectangle(2, 3, SYMBOL);

		String middle = middle(forms);

		System.out.println(middle);
	}

	private static void levelTwo(String[] forms, Triangle shape) {
		String[] quadrilateral = new String[8];
		StringBuilder level2 = new StringBuilder();

		quadrilateral[0] = shape.quadrilateral(forms[2], forms[3]);
		quadrilateral[1] = shape.quadrilateral(forms[2], forms[4]);
		quadrilateral[2] = shape.quadrilateral(forms[1], forms[4]);
		quadrilateral[3] = shape.quadrilateral(forms[1], forms[3]);
		quadrilateral[4] = shape.quadrilateral(forms[2], forms[3], forms[0]);
		quadrilateral[5] = shape.quadrilateral(forms[2], forms[4], forms[0]);
		quadrilateral[6] = shape.quadrilateral(forms[1], forms[4], forms[0]);
		quadrilateral[7] = shape.quadrilateral(forms[1], forms[3], forms[0]);

		Arrays.stream(quadrilateral).forEach(q -> level2.append(q).append(ENTER).append(ENTER));

		System.out.println(level2);
	}

	private static void levelOne(String[] forms, Triangle shape) {
		StringBuilder level1 = new StringBuilder();

		level1.append(forms[2]).append(ENTER).append(forms[3]).append(ENTER).append(forms[4]).append(ENTER)
				.append(forms[1]).append(ENTER).append(forms[0]).append(ENTER);

		String pyramid = shape.pyramidJoiner(forms[1], forms[2]);
		level1.append(pyramid).append(ENTER);

		String trapezoid = shape.trapezoid(forms[1], forms[2], forms[0]);
		level1.append(trapezoid);
		System.out.println(level1);
	}

	private static String middle(String[] forms) {
		int size = 0;
		String[] split;
		StringBuilder join = new StringBuilder();

		for (String form : forms) {
			size = getSize(size, form.split("\n"));
		}

		for (String form : forms) {
			split = form.split("\n");
			addSpace(size, split);
			join.append(String.format("%s%n", String.join("\n", split)));
		}
		return join.toString();
	}

	private static void addSpace(int size, String[] split) {
		for (int i = 0; i < split.length; i++) {
			if (split[split.length - 1].length() < size) {
				int diff = size - split[split.length - 1].length();
				split[i] = String.format("%s%s", " ".repeat(diff / 2), split[i]);
			}
		}
	}

	private static int getSize(int size, String[] split) {
		return Math.max(size, split[split.length - 1].length());
	}

	private static String pyramid(Point a, Point b, Point c) {
		Triangle shape = new Triangle(a, b, c);
		String left = shape.aQuadrant(SYMBOL, SPACE);
		String right = shape.bQuadrant(SYMBOL);
		return shape.pyramidJoiner(left, right);
	}
}
