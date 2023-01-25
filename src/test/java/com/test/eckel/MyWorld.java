package com.test.eckel;

import java.io.*;
import java.util.*;

class House implements Serializable {

	
}

class Animal implements Serializable {
	private String name;

	Animal(String nm) {
		name = nm;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}	
}

public class MyWorld {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog" ));
		animals.add(new Animal("Ralph the hamster" ));
		animals.add(new Animal("Molly the cat" ));
		System.out.println("animals: " + animals);
		
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals); // Write a 2nd set

		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		List animals1 = (List) in1.readObject();
		System.out.println("animals1: " + animals1);
	}
}