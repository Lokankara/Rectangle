package com.homework.collections;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

class Line extends Shape implements Comparator<Point> {
    @Serial
    private static final long serialVersionUID = -78291364212463245L;
    private Point o;
    private int k;
    private int b;
    private long pointCounter;

    public Line(int k, int b) {
        super();
        this.k = k;
        this.b = b;
    }

    public int b() {
        return b;
    }

    public void b(int b) {
        this.b = b;
    }

    public int k() {
        return k;
    }

    public void t(int k) {
        this.k = k;
    }

    public boolean intersection(Point m) {
        return m.y() == k * m.x() + b ? true : false;
    }

    public Point getO() {
        return o;
    }

    public void setO(Point o) {
        if (intersection(o)) {
            this.o = o;
            this.setCounter(this.getCounter() + 1);
        }
    }

    @Override
    public int hashCode() {
        return 17 * Objects.hash(b, k);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line other = (Line) obj;
        return b == other.b && k == other.k;
    }

    @Override
    public String toString() {
        return String.format("Line f(%s%dx%s%d)", k < 0 ? "-" : "", k, b < 0 ? "" : "+", b);
    }

    @Override
    public long setCounter(ArrayList<? extends Shape> points) {
        for (Shape point : points) {
            if (intersection((Point) point)) {
                pointCounter++;
            }
        }
        super.setCounter(pointCounter);
        return pointCounter;
    }

    @Override
    public int compare(Point a, Point b) {
        return (o.y() - a.y()) / (b.y() - a.y()) - (o.x() - a.x()) / (b.x() - a.x());
    }
}