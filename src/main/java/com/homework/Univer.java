package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Univer {


	public static void main(String[] args) {
		Group group = new Group();
		Student alice = new Student("Alice", 6, 7, 5, 7, 8, 5, 7, 5);
		Student bob = new Student("Bob", 9, 8, 9, 8, 9, 6, 8);
		Student clark = new Student("Clark", 10, 12, 11, 12, 10);
		Student dan = new Student("Dan", 11, 9, 12, 10);
		Student ellie = new Student("Ellie", 8, 9, 6, 7, 8, 10);

		group.add(alice);
		group.add(bob);
		group.add(clark);
		group.add(dan);
		alice.set(2, 8);
//		dan.close();
		dan.add(12);
		dan.add(12);
		group.close();
		group.add(ellie);


		System.out.println(group.getBy(10));
		
		System.out.printf("%s%n", group);
	}
}

class Student {
	private String name;
	private boolean closed;
	
	private List<Integer> marks = new ArrayList<>();

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void add(Integer mark) {
		if(!isClosed()) {
			marks.add(mark);			
		} else {
			System.out.printf("You can`t add the mark, student %s has closed%n", this.name);
		}
	}
	public void set(int index, Integer mark) {
		if(!isClosed()) {
			marks.set(index, mark);			
		} else {
			System.out.printf("You can`t set the mark, student %s has closed%n", this.name);
		}
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, Integer... integers) {
		super();
		this.name = name;
		marks.addAll(Arrays.asList(integers));
	}

	public Student() {
	}

	public void close() {
		marks = Collections.unmodifiableList(marks);
		closed = true;
	}

	@Override
	public String toString() {
		return String.format("%nStudent %s has marks %s", name, marks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(marks, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(marks, other.marks) && Objects.equals(name, other.name);
	}

	public double getAverageMark() {
		double result = 0;
		for(int mark : marks) {
			result+=mark;
		}
		return result/ marks.size();
	}
}

class Group {
	private List<Student> students = new ArrayList<>();
	private boolean closed;
	
	public List<Student> getAll() {
		return students;
	}
	public Student getBy(String name) {
		Student result = new Student();
		for (Student student: students) {
			if(student.getName().equals(name)) {
				result = student;
			}
		}
		return result;
	}

	public List<Student> getBy(int mark) {
		final List<Student> result = new ArrayList<>();

		for (Student student : students) {
			if (mark <= student.getAverageMark()) {
				result.add(student);
			}
		}
		return result;
	}
	
	public void add(Student student) {
		if(!students.contains(student) && !closed) {
			students.add(student);
		} else {
			System.out.printf("You can`t add the student, this group has closed%n", this);
		}
	}
	
	public Student edit(String name) {
		Student result = getBy(name);
		for (Student student: students) {
			if(student.getName().equals(name)) {
				result = student;
			}
		}
		return result;
	}

	public void close() {
		students = Collections.unmodifiableList(students);
		this.closed = true;
	}

	@Override
	public String toString() {
		return String.format("Group of students: %s", students);
	}
}