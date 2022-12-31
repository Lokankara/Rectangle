package ua.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return grade == grade1.grade && Objects.equals(boys, grade1.boys) && Objects.equals(girls, grade1.girls) && Objects.equals(maxMarkBoys, grade1.maxMarkBoys) && Objects.equals(maxMarkGirls, grade1.maxMarkGirls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, boys, girls, maxMarkBoys, maxMarkGirls);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", boys=" + boys +
                ", girls=" + girls +
                ", maxMarkBoys=" + maxMarkBoys +
                ", average=" + average +
                ", maxMarkGirls=" + maxMarkGirls +
                '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Pupil> getBoys() {
        return boys;
    }

    public void setBoys(List<Pupil> boys) {
        this.boys = boys;
    }

    public List<Pupil> getGirls() {
        return girls;
    }

    public void setGirls(List<Pupil> girls) {
        this.girls = girls;
    }

    public double getAverage() {
        return average;
    }

    public Pupil getMaxMarkBoys() {
        return maxMarkBoys;
    }

    public void setMaxMarkBoys(Pupil maxMarkBoys) {
        this.maxMarkBoys = maxMarkBoys;
    }

    public Pupil getMaxMarkGirls() {
        return maxMarkGirls;
    }

    public void setMaxMarkGirls(Pupil maxMarkGirls) {
        this.maxMarkGirls = maxMarkGirls;
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
