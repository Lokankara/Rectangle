package com.ua.lab.homework.shape;

public class Task {
    private static int min = 1, max = 7;

    public static void main(String[] args) {
        StringBuilder shape = new StringBuilder();
        StringBuilder multi = new StringBuilder();

        shape
                .append(bQuadrant(max))
                .append("\n")
                .append(cQuadrant(max))
                .append("\n")
                .append(dQuadrant(max))
                .append("\n")
                .append(aQuadrant(max))
                .append("\n")
                .append(rectangle(max));

        System.out.println(shape);

        multi
                .append(bQuadrant(max))
                .append(cQuadrant(max - 1))
                .append("\n")
                .append(bQuadrant(max - 1))
                .append(dQuadrant(max))
                .append("\n")
                .append(aQuadrant(max))
                .append(dQuadrant(max - 1))
                .append(aQuadrant(max))
                .append(cQuadrant(max - 1))
                .append(aQuadrant(max - 1))
                .append(rectangle(max - 1))
                .append(dQuadrant(max))
                .append("\n")

                .append(aQuadrant(max))
                .append(rectangle(max))
                .append(cQuadrant(max))
                .append(middleUp())
                .append(middleUp())
                .append(middleDown())
                .append(middleUp());

        System.out.println(multi);
    }

    private static String middleUp() {
        StringBuilder shape = new StringBuilder();
        for (int i = min - 1; i <= max; i++) {
            for (int j = max; j > min; j--) {
                shape.append(i < j ? " " : "o ");
            }
            shape.append("\n");
        }
        return shape.toString();
    }

    private static String dQuadrant(int max) {
        StringBuilder shape = new StringBuilder();
        for (int i = min; i < max; i++) {
            for (int j = min; j < max; j++) {
                shape.append(i > j ? "  " : "o ");
            }
            shape.append("\n");
        }
        return shape.toString();
    }

    private static String aQuadrant(int max) {
        StringBuilder shape = new StringBuilder();
        for (int i = min; i < max; i++) {
            shape.append(String.format("%s%s%n", " ".repeat(max - i - 1), ".".repeat(i)));
        }
        return shape.toString();
    }

    private static String middleDown() {
        StringBuilder shape = new StringBuilder();
        for (int i = min; i < max; i++) {
            for (int j = min; j < max; j++) {
                shape.append(i > j ? " " : "o ");
            }
            shape.append("\n");
        }
        return shape.append("\n").toString();
    }

    private static String bQuadrant(int max) {
        StringBuilder shape = new StringBuilder();
        for (int i = min; i < max; i++) {
            shape.append(String.format("%s%n", "o ".repeat(i)));
        }
        return shape.toString();
    }

    private static String cQuadrant(int max) {
        StringBuilder shape = new StringBuilder();
        for (int i = max - 1; i >= min; i--) {
            shape.append(String.format("%s%n", "o ".repeat(i)));
        }
        return shape.toString();
    }

    private static String rectangle(int max) {
        StringBuilder shape = new StringBuilder();
        for (int i = min - 1; i < max * max; i++) {
            shape.append(i % max != 0 ? "o " : "\n");
        }
        return shape.toString();
    }
}
