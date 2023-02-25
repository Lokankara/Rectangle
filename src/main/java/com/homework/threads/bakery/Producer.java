package main.java.com.homework.threads.bakery;

import java.util.List;

class Producer implements Runnable {
    private final List<Integer> list;
    private final int SIZE;

    public Producer(List<Integer> list, int size) {
        this.list = list;
        this.SIZE = size;
        System.out.println("Producer/the ArrayList is " + list);
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            synchronized (list) {
                waitUntil();
            }

            synchronized (list) {
                produce(i);
            }
        }
    }

    private void produce(int i) {
//        try {
//            //to add the complex problem touch.
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Producing " + i);
        list.add(i);
        if (list.size() == 1) {
            System.out.println("Notifying Consumer Thread.");
            list.notifyAll();
        }
    }

    private void waitUntil() {
        while (list.size() == SIZE) {
            try {
                System.out.println("The queue is full, producer is not producing anything. "
                        + Thread.currentThread().getName());
                list.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}