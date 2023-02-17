package com.classwork.threads.io.deadlock.test;

class WaitNotify implements Runnable {

    Color c;
    Thread t;

    public WaitNotify(Color c, String name) {
        t = new Thread(this,name);
        this.c = c;
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i<5; i++) {
            if(c.color.equalsIgnoreCase("red")) {
                c.printRed();
            } else {
                c.printGreen();
            }
        }

    }
}

public class Colors{

    public static void main(String[] args) {

        Color red = new Color("red");
        WaitNotify w1 = new WaitNotify(red, "Red Thread");
        WaitNotify w2 = new WaitNotify(red, "Green Thread");

    }
}

class Color {

    String color;

    public Color(String color) {
        this.color = color;
    }

    public synchronized void printRed() {
        System.out.println("Red");
        color = "green";
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printGreen() {
        System.out.println("Green");
        color = "red";
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
