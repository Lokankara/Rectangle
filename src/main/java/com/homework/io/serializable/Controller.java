package com.homework.io.serializable;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Controller {

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
			
			System.out.printf("File %s was written%n", outputfile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}

	public ArrayList<Vehicle> read(String outputfile) {
		ArrayList<Vehicle> values = new ArrayList<>();

		try (ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(outputfile))) {

			values = (ArrayList<Vehicle>) input.readObject();

			System.out.printf("File %s was read%n", outputfile);
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
