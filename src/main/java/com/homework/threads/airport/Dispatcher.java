package com.homework.threads.airport;

import java.util.List;

public class Dispatcher {
	public static void main(String[] args) {
		List<Plane> aircrafts = Controller.buildPlanes();
		for (int i = 0; i < aircrafts.size(); i++) {
			aircrafts.get(i).thread.start();
		}
	}
}

class View {
	public static void display(String message) {
		System.out.print(message);
	}
}