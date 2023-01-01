package com.homework;

public class Rectangle {
//        int ax1, ay1, bx1, by1;
//        int ax2, ay2, bx2, by2;
    static void intersection(int ax1, int ay1, int bx1, int by1, int ax2, int ay2, int bx2, int by2) {

        boolean AF = ax1 == bx2;
        boolean BE = bx1 == ax2;
        boolean CH = ay1 == by2;
        boolean DG = by1 == ay2;

        boolean Af = ax1 > bx2;
        boolean bE = bx1 < ax2;
        boolean Ch = ay1 > by2;
        boolean dG = by1 < ay2;

        if (Af || bE || Ch || dG) {
            System.out.println("there is no intersection");

        } else if (AF && CH || AF && DG || BE && CH || BE && DG) {
            System.out.println("the intersection is a point");

        } else if (AF && (!Ch || dG) || BE && (Ch || !dG)) {
            System.out.println("the intersection is a vertical line");

        } else if (CH && (!Af || bE) || DG && (!Af || bE)) {
            System.out.println("the intersection is a horizontal line");

        } else {
            System.out.println("the intersection is a rectangle");
        }
    }

    public static void main(String[] args) {
        //nil
        intersection(8, 2, 9, 4, 4, 5, 11, 8);
        intersection(1, 7, 3, 11, 4, 5, 11, 8);
        intersection(14, 5, 15, 6, 4, 5, 11, 8);
        intersection(12, 7, 16, 11, 4, 5, 11, 8);
        //point
        intersection(11, 2, 13, 5, 4, 5, 11, 8);
        intersection(3, 8, 4, 9, 4, 5, 11, 8);
        //vertical line
        intersection(11, 6, 12, 7, 4, 5, 11, 8);
        //horizontal line
        intersection(6, 4, 7, 5, 4, 5, 11, 8);
        intersection(6, 8, 8, 10, 4, 5, 11, 8);
        intersection(10, 8, 11, 10, 4, 5, 11, 8);
        //square area
        intersection(1, 2, 5, 6, 4, 5, 11, 8);
        intersection(4, 7, 5, 8, 4, 5, 11, 8);
    }
}