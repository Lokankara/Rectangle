package com.homework.shape;

import static com.homework.shape.Shape.ENTER;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

class Triangle extends Figure {

    Point a;
    Point b;
    Point c;
    Line ab;
    Line bc;
    Line ca;

    double ba;
    static double ac;
    static double cb;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ab = new Line(a, b);
        bc = new Line(b, c);
        ca = new Line(c, a);
        ba = a.y() - b.y();
        cb = c.x() - b.x();
        ac = sqrt(pow(c.x(), 2) + pow(a.y(), 2));
    }

    @Override
    public double area() {
        return ba * cb / 2;
    }

    public Point a() {
        return a;
    }

    public void a(Point a) {
        this.a = a;
    }

    public Point b() {
        return b;
    }

    public void b(Point b) {
        this.b = b;
    }

    public Point c() {
        return c;
    }

    public void c(Point c) {
        this.c = c;
    }

    public String bQuadrant(String fill) {
        sign = fill;
        StringBuilder triangle = new StringBuilder();
        int x = b.x();
        int y = b.y();

        while (y < ba - x) {
            while (x++ - y - 1 < b.x()) {
                triangle.append(sign);
            }
            triangle.append(ENTER);
            x = b.x();
            y++;
        }
        return String.valueOf(triangle);
    }

    protected String cQuadrant(String fill) {
        sign = fill;
        StringBuilder triangle = new StringBuilder();
        int x = b.x();
        int y = b.y();
        while (y < ba - x) {
            while (x++ + y < cb) {
                triangle.append(fill);
            }
            triangle.append(ENTER);
            x = b.x();
            y++;
        }
        return String.valueOf(triangle);
    }

    protected String dQuadrant(String fill, String out) {
        sign = fill;
        StringBuilder triangle = new StringBuilder();
        int y = b.y();
        while (y < ba) {
            int x = b.x();
            while (x < cb) {
                triangle.append(y > x ? out : fill);
                x++;
            }
            triangle.append(ENTER);
            y++;
        }
        return String.valueOf(triangle);
    }

    protected String aQuadrant(String fill, String out) {
        sign = fill;
        StringBuilder triangle = new StringBuilder();
        int y = b.y();
        while (y < ba) {
            int x = b.x();
            while (x < cb) {
                triangle.append(y < ba - x - 1 ? out : fill);
                x++;
            }
            triangle.append(ENTER);
            y++;
        }
        return String.valueOf(triangle);
    }

    protected String rectangle(int ab, int bc, String fill) {
        sign = fill;
        StringBuilder shape = new StringBuilder();
        int y = b.y();
        while (y < ab) {
            shape.append(fill.repeat(Math.max(0, bc - b.x())));
            shape.append(ENTER);
            y++;
        }
        return String.valueOf(shape);
    }

    protected String pyramidJoiner(String left, String right) {
        return triangle(removeLastColumn(left), right);
    }

    private String removeLastColumn(String string) {
        return string.replace(sign + ENTER, ENTER);
    }

    protected String trapezoid(String aQuadrant, String bQuadrant, String c) {
        String[] left = aQuadrant.split(cutColumn());
        String[] right = bQuadrant.split(cutColumn());
        String[] rectangles = c.split(ENTER);

        StringBuilder shape = new StringBuilder();
        int i = 0;
        while (i < rectangles.length) {
            shape.append(left[i]).append(rectangles[i]).append(right[i]).append(ENTER);
            i++;
        }
        return shape.toString();
    }

    protected String quadrilateral(String a, String b) {
        return String.format("%s%s", a, cutRow(b));
    }

    protected String cutRow(String b) {
        String[] split = b.split("\n");
        int size = split.length - 1;
        String[] newArray = new String[size];
        System.arraycopy(split, 1, newArray, 0, size);
        return String.join("\n", newArray);
    }

    protected String triangle(String a, String b) {

        String[] aq = a.split(ENTER);
        String[] bq = b.split(ENTER);

        StringBuilder shape = new StringBuilder();
        int i = 0;
        while (i < aq.length) {
            shape.append(aq[i]).append(bq[i]).append(ENTER);
            i++;
        }
        return shape.toString();
    }

    private String cutColumn() {
        return String.format("%s%s", sign, ENTER);
    }

    public String quadrilateral(String a, String b, String c) {
        return String.format("%s%s%n%s", a, cutRow(c), cutRow(b));
    }

    @Override
    String draw() {
        return String.format("Triangle [ab=%s, bc=%s, ca=%s, ba=%f, ac=%s]", ab, bc, ca, ba, ac);
    }
}
