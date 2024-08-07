package com.homework.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Controller {

    private final Dao dao = new Dao();

    public List<Vehicle> getPlanes() {
        return dao.airplanes();
    }

    public List<Vehicle> getShips() {
        return dao.ships();
    }

    public void write(List<Vehicle> values, String outputfile) {

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(outputfile))) {

            output.writeObject(values);

            System.out.printf("File %s was written%n", outputfile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Vehicle> read(String outputfile) {
        List<Vehicle> values = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(outputfile))) {

            values = (List<Vehicle>) input.readObject();

            System.out.printf("File %s was read%n", outputfile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("%s%n", e.getMessage());
        }
        return values;
    }

    public void check(List<Vehicle> array, List<Vehicle> file) {
        IntStream.range(0, file.size()).forEach(i -> System.out.printf("%s = %s%n", file.get(i), array.get(i)));
    }
}
