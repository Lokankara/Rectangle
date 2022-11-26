//package com.shape;
//
//import static java.lang.StrictMath.pow;
//import static java.lang.StrictMath.sqrt;
//
//public class Quadrilateral {
//
//    Point a;
//    Point b;
//    Point c;
//    Point d;
//    int ab;
//    double ac;
//    int bc;
//
//    public Quadrilateral(Point a, Point b, Point c, Point d) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.d = d;
//
//        ab = a.y - b.y;
//        bc = c.x - b.x;
//        ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
//    }
//}