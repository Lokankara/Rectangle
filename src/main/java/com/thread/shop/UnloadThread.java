package com.thread.shop;

import java.util.concurrent.TimeUnit;

public class UnloadThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Daemon starts work");
        Ferry ferry = Ferry.getInstance();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (ferry.runToUnload()) {
                System.out.println("Ferry is unloading");
            }
        }
    }
}