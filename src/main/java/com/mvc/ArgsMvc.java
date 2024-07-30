package com.mvc;

import java.util.ArrayList;

class ArgsMvc {

	private static final Service service = new Service();

	public static void main(String[] argv) {

//		String[] args = {"ArgsMvc", "MARKS", "3", "5", "2", "3", "4", "4", "3", "4"};
//		String[] args = {"ArgsMvc", "PLANETS", "3", "5", "2", "3", "4", "4", "3", "4"};
		String[] args = {"ArgsMvc", "WEEK_DAYS", "3", "5", "2", "3", "4", "4", "3", "4"};
		
		switch (args[1]) {
		case ("MARKS"):
			getMarks(args);
			break;
		case ("WEEK_DAYS"):
			getWeekDays(args);
			break;
		case ("PLANETS"):
			getPlanets(args);
			break;
		}
	}

	private static void getMarks(String[] args) {
		ArrayList<String> marks = setMarks();
		service.getValue(marks, args);

	}

	private static void getPlanets(String[] args) {
		ArrayList<String> planets = setPlanets();
		service.getValue(planets, args);
	}

	private static void getWeekDays(String[] args) {
		ArrayList<String> weekDays = setWeekDays();

		service.getValue(weekDays, args);
	}

	private static ArrayList<String> setWeekDays() {
		ArrayList<String> weekDays = new ArrayList<>();
		weekDays.add(null);
		weekDays.add("Monday");
		weekDays.add("Tuesday");
		weekDays.add("Wednesday");
		weekDays.add("Thursday");
		weekDays.add("Friday");
		weekDays.add("Saturday");
		weekDays.add("Sunday");
		return weekDays;
	}

	private static ArrayList<String> setPlanets() {
		ArrayList<String> planets = new ArrayList<>();
		planets.add(null);
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");
		planets.add("Mars");
		planets.add("Jupiter");
		planets.add("Saturn");
		planets.add("Uran");
		planets.add("Neptune");
		return planets;
	}

	private static ArrayList<String> setMarks() {
		ArrayList<String> marks = new ArrayList<>();
		marks.add("Unsatisfactory");
		marks.add("Unsatisfactory");
		marks.add("Unsatisfactory");
		marks.add("Satisfactory");
		marks.add("Good");
		marks.add("Excellent");
		return marks;
	}
}

class Entity {
	private int mark;
	private String value;

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

class Service {
	
	public void getValue(ArrayList<String> array, String[] args) {
		for (int i = 2; i < args.length; i++) {
			int index = Integer.parseInt(args[i]);
			System.out.println(array.get(index));
		}
	}
}