package main.java.com.homework.threads.airport;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
class Terminal implements Runnable {
    private final int size;
    protected final Thread thread;
    private final Gate gate;
    private final List<Plane> aircraft;

    public Terminal(List<Plane> aircraft) {
        this.size = aircraft.size();
        this.aircraft = aircraft;
        this.gate = Gate.getGate();
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        for (Plane plane : aircraft)
            gate.arrive(plane);
//            gate.arrive(aircraft.get(0));

    }

//    private void fly() {
//        int i = 0;
//        while (i < size) {
//            synchronized (families) {
//                while (families.size() == size) {
//                    try {
//                        log.info("The queue#%%s is full%%n%s".formatted(Thread.currentThread().getName()));
//                        families.wait();
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        log.info(String.format((e.getMessage())));
//                    }
//                }
//            }
//
//            synchronized (families) {
//                Plane plane = (aircraft.get(i));
//                log.info(plane.toString());
//                families.addAll(plane.getFamilies());
//                i++;
//                if (families.size() == 1) {
//                    log.info("Notifying Airport");
//                    families.notifyAll();
//                }
//            }
//        }
//    }

//    protected void join() {
//        try {
//            this.thread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            log.info(e.getMessage());
//        }
//    }
}