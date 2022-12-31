package ua.lab;

import java.util.Objects;

public class Pupil {
    private String name;
    private int grade;
    private double mark;
    private boolean isBoy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
    }

    public Pupil() {
    }

    public Pupil(String name, int grade, double mark, boolean isBoy) {
        this.name = name;
        this.grade = grade;
        this.mark = mark;
        this.isBoy = isBoy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return grade == pupil.grade && Double.compare(pupil.mark, mark) == 0 && isBoy == pupil.isBoy && Objects.equals(name, pupil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade, mark, isBoy);
    }

    @Override
    public String toString() {
        return "\n" + "Pupil{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", mark=" + mark +
                ", isBoy=" + isBoy +
                '}';
    }
}
