package com.homework.bench;

public class CharArrayConcat {
    public static String concat(String a, String b) {
        char[] result = new char[a.length() + b.length()];
        System.arraycopy(a.toCharArray(), 0, result, 0, a.length());
        System.arraycopy(b.toCharArray(), 0, result, a.length(), b.length());
        return new String(result);
    }
}
