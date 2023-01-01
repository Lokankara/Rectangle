package main.java.com.ua.lab.homework.shape;

import java.util.concurrent.CountDownLatch;


class Counter implements Runnable {
    private static int COUNTER = 0;
    private CountDownLatch latch;

    public Counter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < latch.getCount(); i++) {
            COUNTER++;
            latch.countDown();
            System.out.println(COUNTER);
        }
    }
}
