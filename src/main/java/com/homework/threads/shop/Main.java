package main.java.com.homework.threads.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean temp = random.nextBoolean();
            if (temp) {
                list.add(new Vehicle(VehicleType.CAR));
            } else {
                list.add(new Vehicle(VehicleType.TRUCK));
            }
        }
        Thread daemon = new UnloadThread();
        daemon.setDaemon(true);
        daemon.start();
        ExecutorService service = Executors.newFixedThreadPool(list.size());

        for (Vehicle v : list
        ) {
            service.execute(v);
        }
        service.shutdown();
    }
}