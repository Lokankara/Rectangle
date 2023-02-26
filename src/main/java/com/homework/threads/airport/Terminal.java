package com.homework.threads.airport;

import java.util.List;

class Terminal implements Runnable {
    private final int size;
    protected final Thread thread;
    private final List<Plane> planes;
    private final List<Plane> aircraft;

    public Terminal(List<Plane> planes, List<Plane> aircraft) {
        this.size = aircraft.size();
        this.planes = planes;
        this.aircraft = aircraft;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        fly();
    }

    private void fly() {
        int i = 0;
        while (i < size) {
            synchronized (planes) {
                while (planes.size() == size) {
                    try {
                        System.out.printf("The queue#%s is full%n",
                                Thread.currentThread().getName());
                        planes.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.printf(e.getMessage());
                    }
                }
            }

            synchronized (planes) {
                Plane plane = (aircraft.get(i));
//                System.out.printf("%s\u001B[36m fly from the airport with %s families on board \u001B[0m%n", plane, plane.getFamilies().size());
                planes.add(plane);
                plane.thread.start();
                i++;
                if (planes.size() == 1) {
                    System.out.println("Notifying Airplane");
                    planes.notifyAll();
                }
            }
        }
    }

    protected void join() {
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
