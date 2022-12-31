package com.shape;

class Point {
    int x;
    int y;
    String sign;

    public Point() {
        sign = ".";
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String sign) {
        this.sign = sign;

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}