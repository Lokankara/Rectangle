package com.ua.lab.homework.shape;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Rectangle {

    private static String intersection(Quadrilateral r1, Quadrilateral r2) {
        return intersection(r1.a.x, r1.a.y, r1.c.x, r1.c.x, r2.a.x, r2.a.y, r2.c.x, r2.c.x);
    }

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
            return "Quadrilateral{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    ", d=" + d +
                    ", ab=" + ab +
                    ", ac=" + ac +
                    ", bd=" + bd +
                    ", bc=" + bc +
                    '}';
        }
    }

    static String intersection(int ax1, int ay1, int bx1, int by1, int ax2, int ay2, int bx2, int by2) {
//
//        int x1 = Math.max(ax1, bx1);
//        int y1 = Math.max(ay1, by1);
//        int x2 = Math.min(ax2, bx2);
//        int y2 = Math.min(ay2, bx2);

        String result;
        boolean AF = ax1 == bx2;
        boolean BE = bx1 == ax2;
        boolean CH = ay1 == by2;
        boolean DG = by1 == ay2;

        boolean Af = ax1 > bx2;
        boolean bE = bx1 < ax2;
        boolean Ch = ay1 > by2;
        boolean dG = by1 < ay2;

//        if (x1 > x2 || y1 > y2) {
        if (Af || bE || Ch || dG) {
            result = ("перетину немає");
        } else if (AF && CH || AF && DG || BE && CH || BE && DG) {
            result = ("перетином є крапка");
        } else if (AF && (!Ch || dG) || BE && (Ch || !dG)) {
            result = ("перетином є вертикальна лінія");
        } else if (CH && (!Af || bE) || DG && (!Af || bE)) {
            result = ("перетином є горизонтальна лінія");
        } else {
            result = ("перетином є прямокутник");
        }
        return result;
    }

    public static void main(String[] args) {

        int x = 5;
        int y = 5;
        int z = x / y;
        Quadrilateral[] rectangles = new Quadrilateral[24];
        Point[] points = setPoints();
        int j = 0;
        for (int i = 0; i < 24; i = i + 4) {
            rectangles[j++] = new Quadrilateral(points[i], points[i + 1], points[i + 2], points[i + 3]);
        }

        String intersection = intersection(rectangles[0], rectangles[1]);
        System.out.println(intersection);
        System.out.println(z);
    }

    private static Point[] setPoints() {

        Point[] points = new Point[24];

        points[0] = new Point(4, 5);
        points[1] = new Point(11, 5);
        points[2] = new Point(11, 8);
        points[3] = new Point(4, 8);

        points[4] = new Point(1, 7);
        points[5] = new Point(3, 7);
        points[6] = new Point(3, 11);
        points[7] = new Point(1, 11);

        points[8] = new Point(4, 2);
        points[9] = new Point(10, 5);
        points[10] = new Point(10, 8);
        points[11] = new Point(4, 8);

        points[12] = new Point(8, 2);
        points[13] = new Point(9, 2);
        points[14] = new Point(9, 4);
        points[15] = new Point(8, 4);

        points[16] = new Point(14, 5);
        points[17] = new Point(15, 5);
        points[18] = new Point(15, 6);
        points[19] = new Point(14, 6);

        points[20] = new Point(12, 7);
        points[21] = new Point(16, 7);
        points[22] = new Point(15, 11);
        points[23] = new Point(12, 11);

        return points;
    }
}

//nil
//        intersection(8, 2, 9, 4, 4, 5, 11, 8);
//        intersection(1, 7, 3, 11, 4, 5, 11, 8);
//        intersection(14, 5, 15, 6, 4, 5, 11, 8);
//        intersection(12, 7, 16, 11, 4, 5, 11, 8);
//        //point
//        intersection(11, 2, 13, 5, 4, 5, 11, 8);
//        intersection(3, 8, 4, 9, 4, 5, 11, 8);
//        //vertical line
//        intersection(11, 6, 12, 7, 4, 5, 11, 8);
//        //horizontal line
//        intersection(6, 4, 7, 5, 4, 5, 11, 8);
//        intersection(6, 8, 8, 10, 4, 5, 11, 8);
//        intersection(10, 8, 11, 10, 4, 5, 11, 8);
//        //square area
//        intersection(1, 2, 5, 6, 4, 5, 11, 8);
//        intersection(4, 7, 5, 8, 4, 5, 11, 8);
//
//        boolean a = bx1 < ax2 && ax2 > ax1;
//        boolean b = by1 < ay2 && ay2 > ay1;
//        boolean point = bx1 == ax2 && ax2 != ay1;
//        boolean a = (ax1 + bx1) < ax2 && ax2 > ay1;
//        boolean a = (ax1 + bx1) < ax2 && ax2 > ay1;


//        int ax1 = 4, ay1 = 3, bx1 = 7, by1 = 6;
//        int ax2 = 7, ay2 = 6, bx2 = 10, by2 = 8;
//
//        } else if ((bx1 == ax2 && ay1 == by2) || (ax1 == bx2 && ay1 == by2) || (ax1 == bx2 && by1 == ay2) || (bx1 == ax2 && by1 == ay2)) {
//            System.out.println("point");
//        } else if ((ax1 == ax2 && ay1 == by2) || (ax1 == ax2 && by1 == ay2)) {
//            System.out.println("vertical");
//        } else if ((bx1 == ax2 && ay2 == ay1) || (bx2 == ax1 && ay1 == by2)) {
//            System.out.println("horizontal");
//        } else {
//            System.out.println("rectangle");
//        }


//    var s1 = ( a.x>=b.x && a.x<=b.x1 )||( a.x1>=b.x && a.x1<=b.x1 ),
//            s2 = ( a.y>=b.y && a.y<=b.y1 )||( a.y1>=b.y && a.y1<=b.y1 ),
//            s3 = ( b.x>=a.x && b.x<=a.x1 )||( b.x1>=a.x && b.x1<=a.x1 ),
//            s4 = ( b.y>=a.y && b.y<=a.y1 )||( b.y1>=a.y && b.y1<=a.y1 );
//
//
//    private static String intersection(Quadrilateral r1, Quadrilateral r2) {
//        return intersection(r1.a.x, r1.a.y, r1.c.x, r1.c.x, r2.a.x, r2.a.y, r2.c.x, r2.c.x);
//    }
//
//    private static class Quadrilateral {
//        Point a;
//        Point b;
//        Point c;
//        Point d;
//        int ab;
//        double ac;
//        double bd;
//        int bc;
//
//        public Quadrilateral(Point a, Point b, Point c, Point d) {
//            this.a = a;
//            this.b = b;
//            this.c = c;
//            this.d = d;
//
//            ab = a.y - b.y;
//            bc = c.x - b.x;
//            ac = sqrt(pow(c.x, 2) + pow(a.y, 2));
//            bd = sqrt(pow(d.x, 2) + pow(b.y, 2));
//        }
//
//        @Override
//        public String toString() {
//            return "Quadrilateral{" +
//                    "a=" + a +
//                    ", b=" + b +
//                    ", c=" + c +
//                    ", d=" + d +
//                    ", ab=" + ab +
//                    ", ac=" + ac +
//                    ", bd=" + bd +
//                    ", bc=" + bc +
//                    '}';
//        }
//    }
//
//        int x = 5;
//        int y = 5;
//        int z = x / y;
//        Quadrilateral[] rectangles = new Quadrilateral[24];
//        Point[] points = setPoints();
//        int j = 0;
//        for (int i = 0; i < 24; i = i + 4) {
//            rectangles[j++] = new Quadrilateral(points[i], points[i + 1], points[i + 2], points[i + 3]);
//        }
//
//        String intersection = intersection(rectangles[0], rectangles[1]);
//        System.out.println(intersection);
//    }
//
