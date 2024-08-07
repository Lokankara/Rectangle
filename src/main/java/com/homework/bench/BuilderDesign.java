package com.homework.bench;

public class BuilderDesign {
    public static String concat(String a, String b) {
        return new StringBuilder().append(a).append(b).toString();
    }
}
