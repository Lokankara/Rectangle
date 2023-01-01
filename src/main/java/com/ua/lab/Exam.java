//package ua.lab;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//
//class Pupil {
//    private String name;
//    private int grade;
//    private double mark;
//    private boolean isBoy;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getGrade() {
//        return grade;
//    }
//
//    public void setGrade(int grade) {
//        this.grade = grade;
//    }
//
//    public double getMark() {
//        return mark;
//    }
//
//    public void setMark(double mark) {
//        this.mark = mark;
//    }
//
//    public boolean isBoy() {
//        return isBoy;
//    }
//
//    public void setBoy(boolean boy) {
//        isBoy = boy;
//    }
//
//    public Pupil() {
//    }
//
//    public Pupil(String name, int grade, double mark, boolean isBoy) {
//        this.name = name;
//        this.grade = grade;
//        this.mark = mark;
//        this.isBoy = isBoy;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pupil pupil = (Pupil) o;
//        return grade == pupil.grade && Double.compare(pupil.mark, mark) == 0 && isBoy == pupil.isBoy && Objects.equals(name, pupil.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, grade, mark, isBoy);
//    }
//
//    @Override
//    public String toString() {
//        return "\n" + "Pupil{" +
//                "name='" + name + '\'' +
//                ", grade=" + grade +
//                ", mark=" + mark +
//                ", isBoy=" + isBoy +
//                '}';
//    }
//}
//
//
//class Grade {
//    private int grade;
//
//    private List<Pupil> boys = new ArrayList<>();
//
//    private List<Pupil> girls = new ArrayList<>();
//
//    private Pupil maxMarkBoys = new Pupil();
//    private double average = 0;
//    private Pupil maxMarkGirls = new Pupil();
//
//    public Grade(int grade) {
//        this.grade = grade;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Grade grade1 = (Grade) o;
//        return grade == grade1.grade && Objects.equals(boys, grade1.boys) && Objects.equals(girls, grade1.girls) && Objects.equals(maxMarkBoys, grade1.maxMarkBoys) && Objects.equals(maxMarkGirls, grade1.maxMarkGirls);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(grade, boys, girls, maxMarkBoys, maxMarkGirls);
//    }
//
//    @Override
//    public String toString() {
//        return "Grade{" +
//                "grade=" + grade +
//                ", boys=" + boys +
//                ", girls=" + girls +
//                ", maxMarkBoys=" + maxMarkBoys +
//                ", average=" + average +
//                ", maxMarkGirls=" + maxMarkGirls +
//                '}';
//    }
//
//    public int getGrade() {
//        return grade;
//    }
//
//    public void setGrade(int grade) {
//        this.grade = grade;
//    }
//
//    public List<Pupil> getBoys() {
//        return boys;
//    }
//
//    public void setBoys(List<Pupil> boys) {
//        this.boys = boys;
//    }
//
//    public List<Pupil> getGirls() {
//        return girls;
//    }
//
//    public void setGirls(List<Pupil> girls) {
//        this.girls = girls;
//    }
//
//    public double getAverage() {
//        return average;
//    }
//
//    public Pupil getMaxMarkBoys() {
//        return maxMarkBoys;
//    }
//
//    public void setMaxMarkBoys(Pupil maxMarkBoys) {
//        this.maxMarkBoys = maxMarkBoys;
//    }
//
//    public Pupil getMaxMarkGirls() {
//        return maxMarkGirls;
//    }
//
//    public void setMaxMarkGirls(Pupil maxMarkGirls) {
//        this.maxMarkGirls = maxMarkGirls;
//    }
//
//    public void addBoy(Pupil pupil) {
//        boys.add(pupil);
//        if (this.maxMarkBoys.getMark() < pupil.getMark()) {
//            this.maxMarkBoys = pupil;
//        }
//    }
//
//    public void addGirl(Pupil pupil) {
//        girls.add(pupil);
//        if (this.maxMarkGirls.getMark() < pupil.getMark()) {
//            this.maxMarkGirls = pupil;
//        }
//    }
//
//    public void setAverage(double mark) {
//        this.average += mark;
//    }
//}
//
//public class Exam {
//
//
//    public static void main(String[] args) {
//
//        List<Pupil> pupilList = new ArrayList<>();
//
//        String[] names = {"Mary", "Serg", "Ann", "Lucy", "Mark", "Andrew", "Alex", "Iren",
//                "Bob", "John", "Diana", "Arthur", "Mike", "Nick", "July", "Mary", "Ron", "Paul"};
//
//        int[] classes = {8, 9, 8, 10, 9, 8, 10, 8, 9, 10, 10, 9, 9, 10, 9, 8, 10, 8};
//
//        double[] marks = {9.7, 10.1, 9.9, 11.3, 10.2, 10.4, 11.2, 9.8, 10.5, 10.9, 11.2, 11.1, 10.5,
//                9.6, 10.7, 9.8, 9.7, 11.1};
//
//        boolean[] isBoy = {false, true, false, false, true, true, true, false, true, true, false, true,
//                true, true, false, false, true, true};
//
//        Grade eight = new Grade(8);
//        Grade nine = new Grade(9);
//        Grade ten = new Grade(10);
//
//        for (int index = 0; index < names.length; index++) {
//            Pupil pupil = new Pupil();
//
//            pupil.setName(names[index]);
//            pupil.setGrade(classes[index]);
//            pupil.setMark(marks[index]);
//            pupil.setBoy(isBoy[index]);
//            pupilList.add(pupil);
//
//            if (classes[index] == 8) {
//                distribute(eight, pupil);
//            } else if (classes[index] == 9) {
//                distribute(nine, pupil);
//            } else {
//                distribute(ten, pupil);
//            }
//        }
//
//        double averageEight = getAverage(eight);
//        double averageNine = getAverage(nine);
//        double averageTen = getAverage(ten);
//
//        System.out.println(averageEight);
//        System.out.println(averageNine);
//        System.out.println(averageTen);
//
//        System.out.println(eight.getMaxMarkBoys());
//        System.out.println(eight.getMaxMarkGirls());
//        System.out.println(nine.getMaxMarkBoys());
//        System.out.println(nine.getMaxMarkGirls());
//
//        System.out.println(ten.getMaxMarkBoys());
//        System.out.println(ten.getMaxMarkGirls());
//    }
//
//    private static double getAverage(Grade eight) {
//        return eight.getAverage() / (eight.getBoys().size() + eight.getGirls().size());
//    }
//
//    private static void distribute(Grade grade, Pupil pupil) {
//
//        if (pupil.isBoy()) {
//            grade.addBoy(pupil);
//        } else {
//            grade.addGirl(pupil);
//        }
//        grade.setAverage(pupil.getMark());
//    }
//}


package main.java.com.ua.lab;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {

        List<Pupil> pupilList = new ArrayList<>();

        String[] names = {"Mary", "Serg", "Ann", "Lucy", "Mark", "Andrew", "Alex", "Iren",
                "Bob", "John", "Diana", "Arthur", "Mike", "Nick", "July", "Mary", "Ron", "Paul"};

        int[] classes = {8, 9, 8, 10, 9, 8, 10, 8, 9, 10, 10, 9, 9, 10, 9, 8, 10, 8};

        double[] marks = {9.7, 10.1, 9.9, 11.3, 10.2, 10.4, 11.2, 9.8, 10.5, 10.9, 11.2, 11.1, 10.5,
                9.6, 10.7, 9.8, 9.7, 11.1};

        boolean[] isBoy = {false, true, false, false, true, true, true, false, true, true, false, true,
                true, true, false, false, true, true};

        Grade eight = new Grade(8);
        Grade nine = new Grade(9);
        Grade ten = new Grade(10);

        for (int index = 0; index < names.length; index++) {
            Pupil pupil = new Pupil(names[index], classes[index], marks[index], isBoy[index]);
            pupilList.add(pupil);

            if (pupil.getGrade() == 8) {
                distribute(eight, pupil);
            } else if (pupil.getGrade() == 9) {
                distribute(nine, pupil);
            } else if (pupil.getGrade() == 10) {
                distribute(ten, pupil);
            }
        }
        double averageEight = getAverage(eight);
        double averageNine = getAverage(nine);
        double averageTen = getAverage(ten);

        System.out.println(averageEight);
        System.out.println(averageNine);
        System.out.println(averageTen);

        System.out.println(eight.getMaxMarkBoys());
        System.out.println(eight.getMaxMarkGirls());
        System.out.println(nine.getMaxMarkBoys());
        System.out.println(nine.getMaxMarkGirls());
        System.out.println(nine.getMaxMarkBoys());
        System.out.println(nine.getMaxMarkGirls());
    }

    private static double getAverage(Grade eight) {
        return eight.getAverage() / (eight.getBoys().size() + eight.getGirls().size());
    }

    private static void distribute(Grade grade, Pupil pupil) {

        if (pupil.isBoy()) {
            grade.addBoy(pupil);
        } else {
            grade.addGirl(pupil);
        }
        grade.setAverage(pupil.getMark());
    }
}
//            Pupil pupil = new Pupil();
//            pupil.setName(names[index]);
//            pupil.setGrade(classes[index]);
//            pupil.setMark(marks[index]);
//            pupil.setBoy(isBoy[index]);
