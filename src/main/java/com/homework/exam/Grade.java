package com.homework.exam;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Grade {

    private int grade;

    private List<Pupil> boys = new ArrayList<>();

    private List<Pupil> girls = new ArrayList<>();

    private Pupil maxMarkBoys = new Pupil();

    private double average = 0;
    private Pupil maxMarkGirls = new Pupil();

    public Grade(int grade) {
        this.grade = grade;
    }

    public void addBoy(Pupil pupil) {
        boys.add(pupil);
        if (this.maxMarkBoys.getMark() < pupil.getMark()) {
            this.maxMarkBoys = pupil;
        }
    }

    public void addGirl(Pupil pupil) {
        girls.add(pupil);
        if (this.maxMarkGirls.getMark() < pupil.getMark()) {
            this.maxMarkGirls = pupil;
        }
    }

    public void setAverage(double mark) {
        this.average += mark;
    }
}
