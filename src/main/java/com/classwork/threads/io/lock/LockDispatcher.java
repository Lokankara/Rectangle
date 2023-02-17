package com.classwork.threads.io.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockDispatcher {
    public static void main(String[] args) {
        Controller.runDoubleThread();
        Controller.runMultiThread();
    }
}

class Controller {
    private Controller() {}
    static Manager manager = new Manager();
    static List<Runner> threadPool = new ArrayList<>();
    
    static List<String> filenames = new ArrayList<>(Arrays.asList("f1", "f2", "f3"));

    public static void runDoubleThread() {
    	long start = System.nanoTime();
        new Thread(new Counters(manager)).start();
        new Thread(new Transformers(manager)).start();
        long end = System.nanoTime();
        System.out.printf("Execution time using dual-threading: %s microseconds%n", (end - start) / 1000);
    }

    public static void runMultiThread() {
        for (int i = 0; i < filenames.size(); i++) {
        	threadPool.add(new Counter(filenames.get(i), manager));
        	threadPool.add(new Transformer(filenames.get(i), manager));
        	
        }
           
        long start = System.nanoTime();
        for (int i = 0; i < threadPool.size(); i++) {
        	new Thread(threadPool.get(i)).start();
//        	new Thread(threadPool.get(i)).start();
		}
        long end = System.nanoTime();
        System.out.printf("Execution time using multi-threading: %s microseconds%n", (end - start) / 1000);
    }
}