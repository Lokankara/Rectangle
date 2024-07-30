package com.homework.threads.lock;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 10;
    private static final ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing#1 " + i);
                    buffer.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing#2 " + i);
                    buffer.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int data = buffer.take();
                    System.out.println("Consuming#1 " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int data = buffer.take();
                    System.out.println("Consuming#2 " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        producer.start();
        consumer.start();
        consumerThread.start();
    }
}
