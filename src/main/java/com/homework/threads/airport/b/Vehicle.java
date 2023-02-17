//package com.homework.threads.airport.b;
//
//
//abstract class Vehicle implements Runnable {
//    Thread thread;
//    Manager manager;
//
//    Vehicle(String name, Manager manager) {
//        this.manager = manager;
//        this.thread = new Thread(this, name);
//    }
//}
//
//class Plane extends Vehicle {
//    public Plane(Manager manager) {
//        super("Counter", manager);
//    }
//
//    @Override
//    public void run() {
//        for (String filename : Controller.filenames) {
////            manager.count(new Gate(plane));
//        }
//    }
//}
//
//class Bus extends Vehicle {
//    public Bus(Manager manager) {
//        super("Transformer", manager);
//    }
//
//    @Override
//    public void run() {
//        for (int n = 0; n < Controller.filenames.size(); n++) {
//            manager.transform();
//        }
//    }
//}
//
////class Transformer extends Vehicle {
////    public Transformer(String filename, Manager manager) {
////        super(filename, manager);
////    }
////
////    @Override
////    public void run() {
////        manager.transform();
////    }
////}
////
////class Counter extends Vehicle {
////
////    public Counter(String filename, Manager manager) {
////        super(filename, manager);
////    }
////
////    @Override
////    public void run() {
////        manager.count(new Gate(thread.getName()));
////    }
////}
