package com.homework.shape;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

class Rectangle {

 	private static class Quadrilateral {
 		Point a;
 		Point b;
 		Point c;
 		Point d;
 		int ab;
 		double ac;
 		double bd;
 		int bc;

 		public Quadrilateral(Point a, Point b, Point c, Point d) {
 			this.a = a;
 			this.b = b;
 			this.c = c;
 			this.d = d;

 			ab = a.y - b.y;
 			bc = c.x - b.x;
 			ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
 			bd = sqrt(pow(d.x, 2) + pow(b.y, 2));
 		}

 		@Override
 		public String toString() {
 			return "Quadrilateral{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", ab=" + ab + ", ac=" + ac
 					+ ", bd=" + bd + ", bc=" + bc + '}';
 		}
 	}
}