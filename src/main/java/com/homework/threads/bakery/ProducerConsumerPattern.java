//package com.homework.threads.bakery;
//
//import lombok.SneakyThrows;
//
//import java.util.Queue;
//import java.util.Random;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class ProducerConsumerPattern {
//    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
//    private static AtomicBoolean isRunning = new AtomicBoolean(false);
//
//    public static void main(String[] args) {
//
//        Producer p = new Producer(queue, isRunning);
//        p.start();
//        Consumer c = new Consumer(queue, isRunning);
//        c.start();
//    }
//
//}
//
//class Producer extends Thread {
//    private static Queue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);
//    private static AtomicBoolean isRunning = new AtomicBoolean(false);
//
//    public Producer(Queue<Integer> myQueue, AtomicBoolean bExit) {
//        this.sharedQueue = myQueue;
//        this.isRunning = bExit;
//    }
//
//    @SneakyThrows
//    public void run() {
//        Random random = new Random();
//        while (!isRunning.get()) {
//            if (sharedQueue.size() >= 10) {
//                isRunning.set(true);
//            } else {
//                isRunning.set(false);
//                sharedQueue.add(random.nextInt(100));
//                System.out.println(":producer " + sharedQueue.size());
//            }
//        }
//    }
//}
//
//class Consumer extends Thread {
//    private static Queue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);
//    private static AtomicBoolean isRunning = new AtomicBoolean(false);
//
//    public Consumer(Queue<Integer> myQueue, AtomicBoolean bExit) {
//        this.sharedQueue = myQueue;
//        this.isRunning = bExit;
//    }
//
//    @SneakyThrows
//    public void run() {
//        Integer v = 0;
//        while (v != null) {
//            Thread.sleep(100);
//            v = sharedQueue.poll();
//            if (v != null) {
//                System.out.println(v + ":consumer " + sharedQueue.size());
//            }
//        }
//    }
//}
