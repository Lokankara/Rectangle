package com.homework.mvc;

import java.util.ArrayList;

class Service {
	private static ArrayList<Entity> entities = new ArrayList<>();

	public void getValue(ArrayList<String> array, String[] args) {
		for (int i = 1; i < args.length; i++) {
			int mark = Integer.parseInt(args[i]);
			System.out.println(array.get(mark));
			entities.add(new Entity(args[0], mark, array.get(mark)));
		}
	}

	public void getMarks() {
		for (Entity entity : entities) {
			System.out.println(entity);
		}
		;
	}
}

class ArgsMvc {

	private static final Service service = new Service();

	public static void main(String[] args) {

//		String[] args = {"MARKS", "3", "5", "2", "3", "4", "4", "3", "4"};
//		String[] args = {"PLANETS", "3", "5", "2", "3", "4", "4", "3", "4"};
//		String[] args = {"WEEK_DAYS", "3", "5", "2", "3", "4", "4", "3", "4"};

		switch (args[0]) {
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
		service.getMarks();
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
	private String type;
	private int mark;
	private String value;

	public Entity(String type, int mark, String value) {
		this.mark = mark;
		this.value = value;
		this.setType(type);
	};

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

	@Override
	public String toString() {
		return type + " {mark: " + mark + ", value: " + value + "}";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
