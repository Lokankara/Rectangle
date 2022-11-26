package com.test.raposa;

public class PrintX implements Runnable {
    private int count;

    public PrintX(int count) {
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.print("x");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new PrintX(3));
        t.start();
        System.out.print("y");
    }
}
