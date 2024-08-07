//package com.exam.airport;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
//public class Aircraft {
//
//    public static void main(String[] args) {
//
//        List<Plane> planes = Manager.buildPlanes(5, 100);
//        System.out.println(planes);
////        CountDownLatch latch = new CountDownLatch(planes.size());
////        planes.stream().map(plane ->
////                        new Terminal(plane, latch))
////                .forEach(terminal ->
////                        terminal.thread.start());
//    }
//
//}
//
//class Terminal implements Runnable {
//
//    protected final Thread thread;
//    private final Plane plane;
//    private static boolean isLang = false;
//    private static CountDownLatch latch;
//    private static final List<Plane> planes = new ArrayList<>();
//
//    public Terminal(Plane plane, CountDownLatch count) {
//        latch = count;
//        this.plane = plane;
//        planes.add(plane);
//        this.thread = new Thread(this,
//                String.format("Thread#%s", latch.getCount()));
//    }
//
//    @Override
//    public void run() {
//        planes.forEach(Terminal::arrive);
//    }
//
//    protected static void arrive(Plane plane) {
//        if (plane.tryLock()) {
//            try {
//                System.out.printf("%s is arrived to %s %n",
//                        plane, Thread.currentThread().getName());
//                count(plane);
//            } finally {
//                plane.unlock();
//            }
//        }
//    }
//
//    static void count(Plane plane) {
//        if (!isLang) {
//            isLang = true;
//            planes.add(plane);
//            latch.countDown();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return isLang
//                ? String.format("The file %s was counted by the %s", plane, Thread.currentThread().getName())
//                : String.format("The file %s cannot read by %s", plane, Thread.currentThread().getName());
//    }
//}
//
