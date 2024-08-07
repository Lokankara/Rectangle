package com.thread.bakery;

import java.util.ArrayList;

class ConsumerRunnable implements Runnable {

    private final ArrayList<Integer> list;
    private final int SIZE;

    public ConsumerRunnable(ArrayList<Integer> list, int size) {
        this.list = list;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("the list is." + list);
            synchronized (list) {
                waitUntil();
            }

            synchronized (list) {
                consume(i);
            }
        }
    }

    private void consume(int i) {
//        try {
//            //to add the complex problem touch.
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        list.remove(Integer.valueOf(i));
        System.out.println("Consuming " + i);
        if (list.size() == SIZE - 1) {
            System.out.println("Notifying the Producer Thread.");
            list.notifyAll();
        }
    }

    private synchronized void waitUntil() {
        while (list.isEmpty()) {
            try {
                System.out.println("The queue is empty, consumer is waiting for producer to produce something "
                        + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}