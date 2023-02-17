//package com.homework.threads.airport.b;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class Main {
//    public static void main(String[] args) {
//        Controller.runDoubleThread();
////        Controller.runMultiThread();
//    }
//}
//
//class Controller {
//    private Controller() {}
//    static Manager manager = new Manager();
//    static List<Vehicle> threadPool = new ArrayList<>();
//    static List<String> filenames = new ArrayList<>(Arrays.asList("f1", "f2", "f3"));
//
//    public static void runDoubleThread() {
//    	long start = System.nanoTime();
//        new Plane(manager).thread.start();
//        new Bus(manager).thread.start();
//        long end = System.nanoTime();
//        System.out.printf("Execution time using dual-threading: %s microseconds%n", (end - start) / 1000);
//    }
////
////    public static void runMultiThread() {
////        for (String filename : filenames) {
////        	threadPool.add(new Counter(filename, manager));
////        	threadPool.add(new Transformer(filename, manager));
////        }
////        long start = System.nanoTime();
////        for (int i = 0; i < threadPool.size(); i++) {
////			threadPool.get(i).thread.start();
////		}
////        long end = System.nanoTime();
////        System.out.printf("Execution time using multi-threading: %s microseconds%n", (end - start) / 1000);
////    }
//}
//
//class Gate {
//	private final Plane plane;
//    private final AtomicLong counter;
//
//    public Gate(Plane plane) {
//        this.plane = plane;
//        this.counter = new AtomicLong();
//    }
//    public void add(long value) {
//        this.counter.addAndGet(value);
//    }
//
//    private static char changeLowerCase(char[] letters, int n) {
//        return letters.length == 1 ? letters[0]
//                : (char) (letters[n] >= 96 && letters[n] <= 122 ? letters[n] - 32 : letters[n]);
//    }
//
//    synchronized void arrive() {
//
//        try (Scanner scanner = new Scanner(file)) {
//
//            counter.addAndGet(scanner.findAll(" ").count());
//            
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            notifyAll();
//        }
//    }
//
//    synchronized void boarding() {
//        int n;
//        int k;
//        char[] letters;
//        StringBuilder buffer = new StringBuilder();
//
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//
//                letters = scanner.nextLine().toLowerCase().toCharArray();
//                for (n = 0; n < letters.length; n++) {
//
//                    k = n;
//
//                    while (n < letters.length && letters[n] != ' ' && letters[n] != ',' && letters[n] != '.'
//                            && letters[n] != '\'' && letters[n] != '`' && letters[n] != ';' && letters[n] != ':'
//                            && letters[n] != '"' && letters[n] != '?' && letters[n] != '!' && letters[n] != '–'
//                            && letters[n] != '(' && letters[n] != ')' && letters[n] != '{' && letters[n] != '}'
//                            && letters[n] != '[' && letters[n] != ']' && letters[n] != '«' && letters[n] != '»'
//                            && letters[n] != '@' && letters[n] != '…' && letters[n] != '„' && letters[n] != '“'
//                            && letters[n] != '”' && letters[n] != '*' && letters[n] != '_' && letters[n] != '\t') {
//                        n++;
//                    }
//
//                    if (counter.get() % 2 != 0 && (n > 0)) {
//                        letters[n - 1] = changeLowerCase(letters, n - 1);
//                    } else {
//                        letters[k] = changeLowerCase(letters, k);
//                    }
//                }
//
//                buffer.append(new String(letters));
//                buffer.append(System.lineSeparator());
//            }
//
//            try (PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8)) {
//                writer.append(buffer.toString());
//            }
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            notifyAll();
//        }
//    }
//}
//
//class Manager {
//    private Gate resource;
//    private final AtomicBoolean lock = new AtomicBoolean(false);
//
//    synchronized void transform() {
//        while (!lock.get()) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.err.println("InterruptedException");
//            }
//        }
//        resource.boarding();
//        lock.set(false);
//        notifyAll();
//        
//        System.out.printf("The %s of all the words found in file %s have been capitalized by %s-thread #%s%n",
//                resource.getCounter() % 2 == 0 ? "first letters" : "last letters",
//                resource.getPlane().getName(),
//                Thread.currentThread().getName(),
//                Thread.currentThread().getId());
//    }
//
//    synchronized void count(Gate resource) {
//        while (lock.get()) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.err.println("InterruptedException");
//            }
//        }
//        this.resource = resource;
//        resource.arrive();
//        lock.set(true);
//        notifyAll();
//
//        System.out.printf("%s spaces found in file %s by %s-thread #%s%n",
//                resource.getCounter(),
//                resource.getPlane().getName(),
//                Thread.currentThread().getName(),
//                Thread.currentThread().getId());
//    }
//}