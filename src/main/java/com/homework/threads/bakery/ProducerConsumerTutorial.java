package com.homework.threads.bakery;

import java.util.ArrayList;

public class ProducerConsumerTutorial {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-----------------------------------");
        System.out.println("starting the factory..................");
        System.out.println("-----------------------------------");

        ArrayList<Integer> products=new ArrayList<>();
        int size=5;

        Thread producerThread=new Thread(new Producer(products,size));
        Thread consumerThread=new Thread(new Consumer(products,size));
        producerThread.start();
        consumerThread.start();

//        producerThread.join();
//        consumerThread.join();

        System.out.println("-----------------------------------");
        System.out.println("End of the process/problem.");
        System.out.println("-----------------------------------");
    }

}