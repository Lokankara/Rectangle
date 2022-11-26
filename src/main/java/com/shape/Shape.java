//package com.shape;
//
//
//public class Shape {
//    public static final String ENTER = "\n";
//    Point a;
//    Point b;
//    Point c;
//    String sign;
//    private final int ab;
//    private final int bc;
//
//    public Shape(Triangle triangle) {
//        this.a = triangle.a;
//        this.b = triangle.b;
//        this.c = triangle.c;
//        ab = a.y - b.y;
//        bc = c.x - b.x;
//    }
//
//    public String bQuadrant(String fill) {
//        this.sign = fill;
//        StringBuilder triangle = new StringBuilder();
//        int x = b.x;
//        int y = b.y;
//
//        while (y < ab - x) {
//            while (x++ - y - 1 < b.x) {
//                triangle.append(sign);
//            }
//            triangle.append(ENTER);
//            x = b.x;
//            y++;
//        }
//        return String.valueOf(triangle);
//    }
//
//    protected String cQuadrant(String fill) {
//        this.sign = fill;
//        StringBuilder triangle = new StringBuilder();
//        int x = b.x;
//        int y = b.y;
//        while (y < ab - x) {
//            while (x++ + y < bc) {
//                triangle.append(fill);
//            }
//            triangle.append(ENTER);
//            x = b.x;
//            y++;
//        }
//        return String.valueOf(triangle);
//    }
//
//    protected String dQuadrant(String fill, String out) {
//        this.sign = fill;
//        StringBuilder triangle = new StringBuilder();
//        int y = b.y;
//        while (y < ab) {
//            int x = b.x;
//            while (x < bc) {
//                triangle.append(y > x ? out : fill);
//                x++;
//            }
//            triangle.append(ENTER);
//            y++;
//        }
//        return String.valueOf(triangle);
//
//    }
//
//    protected String aQuadrant(String fill, String out) {
//        this.sign = fill;
//        StringBuilder triangle = new StringBuilder();
//        int y = b.y;
//        while (y < ab) {
//            int x = b.x;
//            while (x < bc) {
//                triangle.append(y < ab - x - 1 ? out : fill);
//                x++;
//            }
//            triangle.append(ENTER);
//            y++;
//        }
//        return String.valueOf(triangle);
//    }
//
//    protected String rectangle(int ab, int bc, String fill) {
//        this.sign = fill;
//        StringBuilder shape = new StringBuilder();
//        int y = b.y;
//        while (y < ab) {
//            shape.append(fill.repeat(Math.max(0, bc - b.x)));
//            shape.append(ENTER);
//            y++;
//        }
//        return String.valueOf(shape);
//    }
//
//    protected String pyramidJoiner(String left, String right) {
//        return triangle(removeLastColumn(left), right);
//    }
//
//    private String removeLastColumn(String string) {
//        return string.replace(sign + ENTER, ENTER);
//    }
//
//    protected String trapezoid(String aQuadrant, String bQuadrant, String c) {
//        String[] left = aQuadrant.split(cutColumn());
//        String[] right = bQuadrant.split(cutColumn());
//        String[] rectangles = c.split(ENTER);
//
//        StringBuilder shape = new StringBuilder();
//        int i = 0;
//        while (i < rectangles.length) {
//            shape
//                    .append(left[i])
//                    .append(rectangles[i])
//                    .append(right[i])
//                    .append(ENTER);
//            i++;
//        }
//        return shape.toString();
//    }
//
//    protected String quadrilateral(String a, String b) {
//        return String.format("%s%s", a, cutRow(b));
//    }
//
//    protected static String cutRow(String b) {
//        String[] split = b.split("\n");
//        int size = split.length - 1;
//        String[] newArray = new String[size];
//        System.arraycopy(split, 1, newArray, 0, size);
//        return String.join("\n", newArray);
//    }
//
//    protected String triangle(String a, String b) {
//
//        String[] aq = a.split(ENTER);
//        String[] bq = b.split(ENTER);
//
//        StringBuilder shape = new StringBuilder();
//        int i = 0;
//        while (i < aq.length) {
//            shape.append(aq[i]).append(bq[i]).append(ENTER);
//            i++;
//        }
//        return shape.toString();
//    }
//
//    private String cutColumn() {
//        return String.format("%s%s", sign, ENTER);
//    }
//
//    public String quadrilateral(String a, String b, String c) {
//        return String.format("%s%s%n%s", a, cutRow(c), cutRow(b));
//    }
//}
