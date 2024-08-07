package com.homework.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dispatcher {
    private final static String outputfileShip = "SHIPS";
    private final static String outputfilePlane = "PLANES";
    private final static Controller controller = new Controller();

    public static void main(String[] args) {
        run(outputfileShip);
        run(outputfilePlane);
    }

    private static void run(String outputfile) {
        switch (outputfile) {
            case "SHIPS":
                execute(controller.getShips(), outputfile);
                break;
            case "PLANES":
                execute(controller.getPlanes(), outputfile);
                break;
        }
    }

    private static void execute(ArrayList<Vehicle> arrayList, String outputfile) {
        Collections.sort(arrayList);
        controller.write(arrayList, outputfile);
        ArrayList<Vehicle> vehicles = controller.read(outputfile);
        controller.check(arrayList, vehicles);
    }
}

class Controller {

    private final Dao dao = new Dao();

    public ArrayList<Vehicle> getPlanes() {
        return dao.airplanes();
    }

    public ArrayList<Vehicle> getShips() {
        return dao.ships();
    }

    public void write(ArrayList<Vehicle> values, String outputfile) {

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(outputfile))) {

            output.writeObject(values);

            System.out.printf("File %s was written.%n", outputfile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Vehicle> read(String outputfile) {
        ArrayList<Vehicle> values = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(outputfile))) {

            values = (ArrayList<Vehicle>) input.readObject();

            System.out.printf("Data from file %s:%n", outputfile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("%s%n", e.getMessage());
        }
        return values;
    }

    public void check(ArrayList<Vehicle> array, ArrayList<Vehicle> file) {
        for (int i = 0; i < file.size(); i++) {
            assertEquals(file.get(i), array.get(i));
            System.out.printf("%s%n", file.get(i));
        }
    }
}

class Dao {
    Engine bmw = new Engine(200, "BMW");
    Engine man = new Engine(250, "MAN");

    ArrayList<Boat> boats = new ArrayList<Boat>(Arrays.asList(
            new Boat(4, "metal"), new Boat(2, "wood"), new Boat(5, "plastic")));

    ArrayList<Wheel> wheels = new ArrayList<Wheel>(Arrays.asList(
            new Wheel(100, 6), new Wheel(100, 6), new Wheel(100, 6)));

    ArrayList<Chassis> chassis = new ArrayList<Chassis>(Arrays.asList(
            new Chassis(wheels.get(0), 4),
            new Chassis(wheels.get(1), 2),
            new Chassis(wheels.get(2), 1)));

    ArrayList<Vehicle> ships = new ArrayList<Vehicle>(Arrays.asList(
            new Ship(2010, 150, man, 100, 20, boats.get(0)),
            new Ship(1999, 220, bmw, 10, 5, boats.get(1)),
            new Ship(2020, 170, man, 20, 7, boats.get(2))));

    ArrayList<Vehicle> airplanes = new ArrayList<Vehicle>(Arrays.asList(
            new Airplane(1996, 300, bmw, "Transport", 1500, chassis.get(0)),
            new Airplane(1991, 500, man, "Fighter", 2000, chassis.get(1)),
            new Airplane(1969, 200, bmw, "Zeppelin", 1000, chassis.get(2))));

    public ArrayList<Vehicle> ships() {
        return ships;
    }

    public ArrayList<Vehicle> airplanes() {
        return airplanes;
    }
}
