package com.exam;

import java.util.ArrayList;
import java.util.List;

public class Grade {
	private int grade;
	private double totalMarks;
	private List<Pupil> boys= new ArrayList<>();
	private List<Pupil> girls = new ArrayList<>();
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}	
}