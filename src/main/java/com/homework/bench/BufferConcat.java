package com.homework.bench;

public class BufferConcat {
    public static String concat(String a, String b) {
        return new StringBuffer().append(a).append(b).toString();
    }
}
