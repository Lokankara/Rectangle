package com.shape;

import java.util.Arrays;

public class Shapes {
    private static final Point A = new Point();
    private static final Point B = new Point();
    private static final Point C = new Point();
    public static final String SYMBOL = ".";
    public static final String SPACE = " ";
    private static final int LENGTH = 4;
    public static final String ENTER = "\n";

    public static void main(String[] args) {
        String[] forms = new String[5];

        A.x = 0;
        A.y = LENGTH;
        B.x = 0;
        B.y = 0;
        C.x = LENGTH;
        C.y = 0;

        Triangle triangle = new Triangle(A, B, C);

        Shape shape = new Shape(triangle);

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
        A.y = 5;
        C.x = 5;
        Triangle triangle = new Triangle(A, B, C);
        Shape shape = new Shape(triangle);
        String aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
        String bQuadrant = shape.bQuadrant(SYMBOL);
        forms[0] = shape.pyramidJoiner(aQuadrant, bQuadrant);
        forms[1] = shape.rectangle(5, 9, SYMBOL);
        forms[2] = shape.trapezoid(aQuadrant, forms[1], bQuadrant);
        forms[3] = shape.rectangle(5, 9, SYMBOL);

        A.y = 9;
        C.x = 9;
        triangle = new Triangle(A, B, C);
        shape = new Shape(triangle);
        aQuadrant = shape.aQuadrant(SYMBOL, SPACE);
        bQuadrant = shape.bQuadrant(SYMBOL);
        String rectangle = shape.rectangle(9, 9, SYMBOL);
        forms[4] = shape.trapezoid(aQuadrant, rectangle, bQuadrant);
        String middle = middle(forms);
        System.out.println(middle);
    }


    private static void levelThreeA() {
        String[] forms = new String[4];
        A.y = 4;
        C.x = 4;
        forms[0] = pyramid(A, B, C);

        A.y = 5;
        C.x = 5;
        forms[1] = pyramid(A, B, C);

        A.y = 6;
        C.x = 6;
        forms[2] = pyramid(A, B, C);

        A.y = 2;
        C.x = 3;
        forms[3] = new Shape(new Triangle(A, B, C)).rectangle(2, 3, SYMBOL);

        String middle = middle(forms);
        System.out.println(middle);
    }

    private static void levelTwo(String[] forms, Shape shape) {
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

    private static void levelOne(String[] forms, Shape shape) {
        StringBuilder level1 = new StringBuilder();

        level1
                .append(forms[2]).append(ENTER)
                .append(forms[3]).append(ENTER)
                .append(forms[4]).append(ENTER)
                .append(forms[1]).append(ENTER)
                .append(forms[0]).append(ENTER);

        String pyramid = shape.pyramidJoiner(forms[1], forms[2]);
        level1.append(pyramid);
        level1.append(ENTER);

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
        Triangle flat = new Triangle(a, b, c);
        Shape shape = new Shape(flat);
        String left = shape.aQuadrant(SYMBOL, SPACE);
        String right = shape.bQuadrant(SYMBOL);
        return shape.pyramidJoiner(left, right);
    }

    public static class Shape {
        Point a;
        Point b;
        Point c;
        String sign;
        private final int ab;
        private final int bc;

        public Shape(Triangle triangle) {
            this.a = triangle.a;
            this.b = triangle.b;
            this.c = triangle.c;
            ab = a.y - b.y;
            bc = c.x - b.x;
        }

        public String bQuadrant(String fill) {
            this.sign = fill;
            StringBuilder triangle = new StringBuilder();
            int x = b.x;
            int y = b.y;

            while (y < ab - x) {
                while (x++ - y - 1 < b.x) {
                    triangle.append(sign);
                }
                triangle.append(ENTER);
                x = b.x;
                y++;
            }
            return String.valueOf(triangle);
        }

        protected String cQuadrant(String fill) {
            this.sign = fill;
            StringBuilder triangle = new StringBuilder();
            int x = b.x;
            int y = b.y;
            while (y < ab - x) {
                while (x++ + y < bc) {
                    triangle.append(fill);
                }
                triangle.append(ENTER);
                x = b.x;
                y++;
            }
            return String.valueOf(triangle);
        }

        protected String dQuadrant(String fill, String out) {
            this.sign = fill;
            StringBuilder triangle = new StringBuilder();
            int y = b.y;
            while (y < ab) {
                int x = b.x;
                while (x < bc) {
                    triangle.append(y > x ? out : fill);
                    x++;
                }
                triangle.append(ENTER);
                y++;
            }
            return String.valueOf(triangle);

        }

        protected String aQuadrant(String fill, String out) {
            this.sign = fill;
            StringBuilder triangle = new StringBuilder();
            int y = b.y;
            while (y < ab) {
                int x = b.x;
                while (x < bc) {
                    triangle.append(y < ab - x - 1 ? out : fill);
                    x++;
                }
                triangle.append(ENTER);
                y++;
            }
            return String.valueOf(triangle);
        }

        protected String rectangle(int ab, int bc, String fill) {
            this.sign = fill;
            StringBuilder shape = new StringBuilder();
            int y = b.y;
            while (y < ab) {
                shape.append(fill.repeat(Math.max(0, bc - b.x)));
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
                shape
                        .append(left[i])
                        .append(rectangles[i])
                        .append(right[i])
                        .append(ENTER);
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
    }
}

