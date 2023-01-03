// package com.homework.shape;

// import java.util.Arrays;
// import static java.lang.StrictMath.pow;
// import static java.lang.StrictMath.sqrt;

// public class Shapes {
// 	private static final Point A = new Point();
// 	private static final Point B = new Point();
// 	private static final Point C = new Point();
// 	private static final Point D = new Point();

// 	public static final String SYMBOL = ".";
// 	public static final String SPACE = " ";
// 	private static final int LENGTH = 4;
// 	public static final String ENTER = "\n";

// 	public static void main(String[] args) {

// 		int x = 5;
// 		int y = 5;
// 		int z = x / y;
// 		Quadrilateral[] rectangles = new Quadrilateral[24];
// 		Point[] points = setPoints();
// 		int j = 0;
// 		for (int i = 0; i < 24; i = i + 4) {
// 			rectangles[j++] = new Quadrilateral(points[i], points[i + 1], points[i + 2], points[i + 3]);
// 		}

// 		String intersection = intersection(rectangles[0], rectangles[1]);
// 		System.out.println(intersection);
// 		System.out.println(z);

// 		String[] forms = new String[5];

// 		A.x = 0;
// 		A.y = LENGTH;
// 		B.x = 0;
// 		B.y = 0;
// 		C.x = LENGTH;
// 		C.y = 0;
// 		D.x = LENGTH;
// 		D.y = LENGTH;

// 		Triangle triangle = new Triangle(A, B, C);

// 		Shape shape = new Shape(triangle);

// 		forms[0] = shape.rectangle(LENGTH, LENGTH, SYMBOL);
// 		forms[1] = shape.aQuadrant(SYMBOL, SPACE);
// 		forms[2] = shape.bQuadrant(SYMBOL);
// 		forms[3] = shape.cQuadrant(SYMBOL);
// 		forms[4] = shape.dQuadrant(SYMBOL, SPACE);

// 		levelOne(forms, shape);
// 		levelTwo(forms, shape);
// 		levelThreeA();
// 		levelThreeB();
// 	}

// 	private static Point[] setPoints() {
// 		Point[] points = new Point[24];

// 		points[0] = new Point(4, 5);
// 		points[1] = new Point(11, 5);
// 		points[2] = new Point(11, 8);
// 		points[3] = new Point(4, 8);

// 		points[4] = new Point(1, 7);
// 		points[5] = new Point(3, 7);
// 		points[6] = new Point(3, 11);
// 		points[7] = new Point(1, 11);

// 		points[8] = new Point(4, 2);
// 		points[9] = new Point(10, 5);
// 		points[10] = new Point(10, 8);
// 		points[11] = new Point(4, 8);

// 		points[12] = new Point(8, 2);
// 		points[13] = new Point(9, 2);
// 		points[14] = new Point(9, 4);
// 		points[15] = new Point(8, 4);

// 		points[16] = new Point(14, 5);
// 		points[17] = new Point(15, 5);
// 		points[18] = new Point(15, 6);
// 		points[19] = new Point(14, 6);

// 		points[20] = new Point(12, 7);
// 		points[21] = new Point(16, 7);
// 		points[22] = new Point(15, 11);
// 		points[23] = new Point(12, 11);

// 		return points;
// 	}

// 	private static String intersection(Quadrilateral quadrilateral, Quadrilateral quadrilateral2) {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	private static void levelThreeB() {
// 		String[] forms = new String[5];
// 		A.y = 5;
// 		C.x = 5;
// 		Triangle triangle = new Triangle(A, B, C);
// 		Shape shape = new Shape(triangle);
// 		String aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
// 		String bQuadrant = shape.bQuadrant(SYMBOL);
// 		forms[0] = shape.pyramidJoiner(aQuadrant, bQuadrant);
// 		forms[1] = shape.rectangle(5, 9, SYMBOL);
// 		forms[2] = shape.trapezoid(aQuadrant, forms[1], bQuadrant);
// 		forms[3] = shape.rectangle(5, 9, SYMBOL);

// 		A.y = 9;
// 		C.x = 9;
// 		triangle = new Triangle(A, B, C);
// 		shape = new Shape(triangle);
// 		aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
// 		bQuadrant = shape.bQuadrant(SYMBOL);
// 		String rectangle = shape.rectangle(9, 9, SYMBOL);
// 		forms[4] = shape.trapezoid(aQuadrant, rectangle, bQuadrant);
// 		String middle = middle(forms);
// 		System.out.println(middle);
// 	}

// 	private static void levelThreeA() {
// 		String[] forms = new String[4];
// 		A.y = 4;
// 		C.x = 4;
// 		forms[0] = pyramid(A, B, C);

// 		A.y = 5;
// 		C.x = 5;
// 		forms[1] = pyramid(A, B, C);

// 		A.y = 6;
// 		C.x = 6;
// 		forms[2] = pyramid(A, B, C);

// 		A.y = 2;
// 		C.x = 3;
// 		forms[3] = new Shape(new Triangle(A, B, C)).rectangle(2, 3, SYMBOL);

// 		String middle = middle(forms);
// 		System.out.println(middle);
// 	}

// 	private static void levelTwo(String[] forms, Shape shape) {
// 		String[] quadrilateral = new String[8];
// 		StringBuilder level2 = new StringBuilder();

// 		quadrilateral[0] = shape.quadrilateral(forms[2], forms[3]);
// 		quadrilateral[1] = shape.quadrilateral(forms[2], forms[4]);
// 		quadrilateral[2] = shape.quadrilateral(forms[1], forms[4]);
// 		quadrilateral[3] = shape.quadrilateral(forms[1], forms[3]);
// 		quadrilateral[4] = shape.quadrilateral(forms[2], forms[3], forms[0]);
// 		quadrilateral[5] = shape.quadrilateral(forms[2], forms[4], forms[0]);
// 		quadrilateral[6] = shape.quadrilateral(forms[1], forms[4], forms[0]);
// 		quadrilateral[7] = shape.quadrilateral(forms[1], forms[3], forms[0]);

// 		Arrays.stream(quadrilateral).forEach(q -> level2.append(q).append(ENTER).append(ENTER));

// 		System.out.println(level2);
// 	}

// 	private static void levelOne(String[] forms, Shape shape) {
// 		StringBuilder level1 = new StringBuilder();

// 		level1.append(forms[2]).append(ENTER).append(forms[3]).append(ENTER).append(forms[4]).append(ENTER)
// 				.append(forms[1]).append(ENTER).append(forms[0]).append(ENTER);

// 		String pyramid = shape.pyramidJoiner(forms[1], forms[2]);
// 		level1.append(pyramid);
// 		level1.append(ENTER);

// 		String trapezoid = shape.trapezoid(forms[1], forms[2], forms[0]);
// 		level1.append(trapezoid);
// 		System.out.println(level1);
// 	}

// 	private static String middle(String[] forms) {
// 		int size = 0;
// 		String[] split;
// 		StringBuilder join = new StringBuilder();

// 		for (String form : forms) {
// 			size = getSize(size, form.split("\n"));
// 		}

// 		for (String form : forms) {
// 			split = form.split("\n");
// 			addSpace(size, split);
// 			join.append(String.format("%s%n", String.join("\n", split)));
// 		}
// 		return join.toString();
// 	}

// 	private static void addSpace(int size, String[] split) {
// 		for (int i = 0; i < split.length; i++) {
// 			if (split[split.length - 1].length() < size) {
// 				int diff = size - split[split.length - 1].length();
// 				split[i] = String.format("%s%s", " ".repeat(diff / 2), split[i]);
// 			}
// 		}
// 	}

// 	private static int getSize(int size, String[] split) {
// 		return Math.max(size, split[split.length - 1].length());
// 	}

// 	private static String pyramid(Point a, Point b, Point c) {
// 		Triangle flat = new Triangle(a, b, c);
// 		Shape shape = new Shape(flat);
// 		String left = shape.aQuadrant(SYMBOL, SPACE);
// 		String right = shape.bQuadrant(SYMBOL);
// 		return shape.pyramidJoiner(left, right);
// 	}

// 	public static class Shape {
// 		Point a;
// 		Point b;
// 		Point c;
// 		String sign;
// 		private final int ab;
// 		private final int bc;

// 		public Shape(Triangle triangle) {
// 			this.a = triangle.a;
// 			this.b = triangle.b;
// 			this.c = triangle.c;
// 			ab = a.y - b.y;
// 			bc = c.x - b.x;
// 		}

// 		public String bQuadrant(String fill) {
// 			this.sign = fill;
// 			StringBuilder triangle = new StringBuilder();
// 			int x = b.x;
// 			int y = b.y;

// 			while (y < ab - x) {
// 				while (x++ - y - 1 < b.x) {
// 					triangle.append(sign);
// 				}
// 				triangle.append(ENTER);
// 				x = b.x;
// 				y++;
// 			}
// 			return String.valueOf(triangle);
// 		}

// 		protected String cQuadrant(String fill) {
// 			this.sign = fill;
// 			StringBuilder triangle = new StringBuilder();
// 			int x = b.x;
// 			int y = b.y;
// 			while (y < ab - x) {
// 				while (x++ + y < bc) {
// 					triangle.append(fill);
// 				}
// 				triangle.append(ENTER);
// 				x = b.x;
// 				y++;
// 			}
// 			return String.valueOf(triangle);
// 		}

// 		protected String dQuadrant(String fill, String out) {
// 			this.sign = fill;
// 			StringBuilder triangle = new StringBuilder();
// 			int y = b.y;
// 			while (y < ab) {
// 				int x = b.x;
// 				while (x < bc) {
// 					triangle.append(y > x ? out : fill);
// 					x++;
// 				}
// 				triangle.append(ENTER);
// 				y++;
// 			}
// 			return String.valueOf(triangle);

// 		}

// 		protected String aQuadrant(String fill, String out) {
// 			this.sign = fill;
// 			StringBuilder triangle = new StringBuilder();
// 			int y = b.y;
// 			while (y < ab) {
// 				int x = b.x;
// 				while (x < bc) {
// 					triangle.append(y < ab - x - 1 ? out : fill);
// 					x++;
// 				}
// 				triangle.append(ENTER);
// 				y++;
// 			}
// 			return String.valueOf(triangle);
// 		}

// 		protected String rectangle(int ab, int bc, String fill) {
// 			this.sign = fill;
// 			StringBuilder shape = new StringBuilder();
// 			int y = b.y;
// 			while (y < ab) {
// 				shape.append(fill.repeat(Math.max(0, bc - b.x)));
// 				shape.append(ENTER);
// 				y++;
// 			}
// 			return String.valueOf(shape);
// 		}

// 		protected String pyramidJoiner(String left, String right) {
// 			return triangle(removeLastColumn(left), right);
// 		}

// 		private String removeLastColumn(String string) {
// 			return string.replace(sign + ENTER, ENTER);
// 		}

// 		protected String trapezoid(String aQuadrant, String bQuadrant, String c) {
// 			String[] left = aQuadrant.split(cutColumn());
// 			String[] right = bQuadrant.split(cutColumn());
// 			String[] rectangles = c.split(ENTER);

// 			StringBuilder shape = new StringBuilder();
// 			int i = 0;
// 			while (i < rectangles.length) {
// 				shape.append(left[i]).append(rectangles[i]).append(right[i]).append(ENTER);
// 				i++;
// 			}
// 			return shape.toString();
// 		}

// 		protected String quadrilateral(String a, String b) {
// 			return String.format("%s%s", a, cutRow(b));
// 		}

// 		protected String cutRow(String b) {
// 			String[] split = b.split("\n");
// 			int size = split.length - 1;
// 			String[] newArray = new String[size];
// 			System.arraycopy(split, 1, newArray, 0, size);
// 			return String.join("\n", newArray);
// 		}

// 		protected String triangle(String a, String b) {

// 			String[] aq = a.split(ENTER);
// 			String[] bq = b.split(ENTER);

// 			StringBuilder shape = new StringBuilder();
// 			int i = 0;
// 			while (i < aq.length) {
// 				shape.append(aq[i]).append(bq[i]).append(ENTER);
// 				i++;
// 			}
// 			return shape.toString();
// 		}

// 		private String cutColumn() {
// 			return String.format("%s%s", sign, ENTER);
// 		}

// 		public String quadrilateral(String a, String b, String c) {
// 			return String.format("%s%s%n%s", a, cutRow(c), cutRow(b));
// 		}
// 	}
// }

// class Triangle {
// 	Point a;
// 	Point b;
// 	Point c;
// 	double ab;
// 	double ac;
// 	double bc;

// 	public Triangle() {
// 	}

// 	public Triangle(Point a, Point b, Point c) {
// 		this.a = a;
// 		this.b = b;
// 		this.c = c;

// 		ab = a.y - b.y;
// 		bc = c.x - b.x;
// 		ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
// 	}
// }

// class Point {
// 	protected int x;
// 	protected int y;
// 	private String sign;

// 	public Point() {
// 		sign = ".";
// 	}

// 	public Point(int x, int y) {
// 		this.x = x;
// 		this.y = y;
// 	}

// 	public Point(String sign) {
// 		this.sign = sign;
// 	}

// 	public Point(int x, int y, String sign) {
// 		super();
// 		this.x = x;
// 		this.y = y;
// 		this.sign = sign;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Point{" + "x=" + x + ", y=" + y + '}';
// 	}
// }

// class Quadrilateral {

// 	Point a;
// 	Point b;
// 	Point c;
// 	Point d;
// 	int ab;
// 	double ac;
// 	int bc;

// 	public Quadrilateral(Point a, Point b, Point c, Point d) {
// 		this.a = a;
// 		this.b = b;
// 		this.c = c;
// 		this.d = d;

// 		ab = a.y - b.y;
// 		bc = c.x - b.x;
// 		ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
// 	}
// }

// class Rectangle {

// 	private static String intersection(Quadrilateral r1, Quadrilateral r2) {
// 		return intersection(r1.a.x, r1.a.y, r1.c.x, r1.c.x, r2.a.x, r2.a.y, r2.c.x, r2.c.x);
// 	}

// 	private static class Quadrilateral {
// 		Point a;
// 		Point b;
// 		Point c;
// 		Point d;
// 		int ab;
// 		double ac;
// 		double bd;
// 		int bc;

// 		public Quadrilateral(Point a, Point b, Point c, Point d) {
// 			this.a = a;
// 			this.b = b;
// 			this.c = c;
// 			this.d = d;

// 			ab = a.y - b.y;
// 			bc = c.x - b.x;
// 			ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
// 			bd = sqrt(pow(d.x, 2) + pow(b.y, 2));
// 		}

// 		@Override
// 		public String toString() {
// 			return "Quadrilateral{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", ab=" + ab + ", ac=" + ac
// 					+ ", bd=" + bd + ", bc=" + bc + '}';
// 		}
// 	}

// 	static String intersection(int ax1, int ay1, int bx1, int by1, int ax2, int ay2, int bx2, int by2) {
// //
// //        int x1 = Math.max(ax1, bx1);
// //        int y1 = Math.max(ay1, by1);
// //        int x2 = Math.min(ax2, bx2);
// //        int y2 = Math.min(ay2, bx2);

// 		String result;
// 		boolean AF = ax1 == bx2;
// 		boolean BE = bx1 == ax2;
// 		boolean CH = ay1 == by2;
// 		boolean DG = by1 == ay2;

// 		boolean Af = ax1 > bx2;
// 		boolean bE = bx1 < ax2;
// 		boolean Ch = ay1 > by2;
// 		boolean dG = by1 < ay2;

// //        if (x1 > x2 || y1 > y2) {
// 		if (Af || bE || Ch || dG) {
// 			result = ("перетину немає");
// 		} else if (AF && CH || AF && DG || BE && CH || BE && DG) {
// 			result = ("перетином є крапка");
// 		} else if (AF && (!Ch || dG) || BE && (Ch || !dG)) {
// 			result = ("перетином є вертикальна лінія");
// 		} else if (CH && (!Af || bE) || DG && (!Af || bE)) {
// 			result = ("перетином є горизонтальна лінія");
// 		} else {
// 			result = ("перетином є прямокутник");
// 		}
// 		return result;
// 	}

// }

// //nil
// //        intersection(8, 2, 9, 4, 4, 5, 11, 8);
// //        intersection(1, 7, 3, 11, 4, 5, 11, 8);
// //        intersection(14, 5, 15, 6, 4, 5, 11, 8);
// //        intersection(12, 7, 16, 11, 4, 5, 11, 8);
// //        //point
// //        intersection(11, 2, 13, 5, 4, 5, 11, 8);
// //        intersection(3, 8, 4, 9, 4, 5, 11, 8);
// //        //vertical line
// //        intersection(11, 6, 12, 7, 4, 5, 11, 8);
// //        //horizontal line
// //        intersection(6, 4, 7, 5, 4, 5, 11, 8);
// //        intersection(6, 8, 8, 10, 4, 5, 11, 8);
// //        intersection(10, 8, 11, 10, 4, 5, 11, 8);
// //        //square area
// //        intersection(1, 2, 5, 6, 4, 5, 11, 8);
// //        intersection(4, 7, 5, 8, 4, 5, 11, 8);
// //
// //        boolean a = bx1 < ax2 && ax2 > ax1;
// //        boolean b = by1 < ay2 && ay2 > ay1;
// //        boolean point = bx1 == ax2 && ax2 != ay1;
// //        boolean a = (ax1 + bx1) < ax2 && ax2 > ay1;
// //        boolean a = (ax1 + bx1) < ax2 && ax2 > ay1;

// //        int ax1 = 4, ay1 = 3, bx1 = 7, by1 = 6;
// //        int ax2 = 7, ay2 = 6, bx2 = 10, by2 = 8;
// //
// //        } else if ((bx1 == ax2 && ay1 == by2) || (ax1 == bx2 && ay1 == by2) || (ax1 == bx2 && by1 == ay2) || (bx1 == ax2 && by1 == ay2)) {
// //            System.out.println("point");
// //        } else if ((ax1 == ax2 && ay1 == by2) || (ax1 == ax2 && by1 == ay2)) {
// //            System.out.println("vertical");
// //        } else if ((bx1 == ax2 && ay2 == ay1) || (bx2 == ax1 && ay1 == by2)) {
// //            System.out.println("horizontal");
// //        } else {
// //            System.out.println("rectangle");
// //        }

// //    var s1 = ( a.x>=b.x && a.x<=b.x1 )||( a.x1>=b.x && a.x1<=b.x1 ),
// //            s2 = ( a.y>=b.y && a.y<=b.y1 )||( a.y1>=b.y && a.y1<=b.y1 ),
// //            s3 = ( b.x>=a.x && b.x<=a.x1 )||( b.x1>=a.x && b.x1<=a.x1 ),
// //            s4 = ( b.y>=a.y && b.y<=a.y1 )||( b.y1>=a.y && b.y1<=a.y1 );
// //
