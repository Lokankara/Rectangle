package com.test.raposa;
//Assessment Test#3
public class Hello {
    String greeting = "hi";

    public static void main(String[] args) {
        Hello h = new Hello();
        h.greeting = null;
        System.gc();
        return;
    }
}