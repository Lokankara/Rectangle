package com.homework.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Exam {

    public static void main(String[] args) {

        char space = ' ';
        char dot = '.';
        int slice = 0;
        int length = 0;
        int wordCounter = 0;
        int sentenceCounter = 0;
        List<Integer> slicer = new ArrayList<>();
        List<Integer> spaces = new ArrayList<>();
        List<String> wordz = new ArrayList<>();

        final String sentience_1 = "I originally approached Java as just another programming language. But as time\n" +
                "passed and I studied it more deeply. I began to see that the fundamental intent of\n" +
                "this language was different from other languages I had seen up to that point.\n" +
                "Programming is about managing complexity. The complexity of the problem you\n" +
                "want to solve. Laid upon the complexity of the machine in which it is solved.";

        final String sentience_2 = "Because of this complexity most of our programming projects fail. And yet of all\n" +
                "the programming languages of which I am aware. Almost none have gone all out\n" +
                "and decided that their main design goal would be to conquer the complexity of\n" +
                "developing and maintaining programs. Many language design decisions were made\n" +
                "with complexity in mind. But at some point there were always other issues that\n" +
                "were considered essential to be added into the mix.";

        long time = System.currentTimeMillis();
        String sentience = sentience_1 + sentience_2;
        String[] words = sentience.split(" ");
        int size = words.length;

        String[] first = Arrays.copyOfRange(words, 0, (size + 1) / 2);
        String[] second = Arrays.copyOfRange(words, (size + 1) / 2, size);

        List<String> min = new ArrayList<>();
        Collections.addAll(min, first);
        List<String> max = IntStream
                .iterate(second.length - 1, index -> index >= 0, index -> index - 1)
                .mapToObj(index -> second[index])
                .collect(Collectors.toList());

        out.printf("%d min words: %s%n", first.length, min);
        out.printf("%d max words: %s%n", max.size(), max);

        for (char letter : sentience.toCharArray()) {
            length++;
            if (space == letter) {
                spaces.add(length);
                wordCounter++;
                slice++;
            } else if (dot == letter) {
                sentenceCounter++;
                slicer.add(slice);
                slice = 0;
            } else {
                wordz.add(String.format("%s", letter));
            }
        }
        Collections.sort(wordz);

        time = System.currentTimeMillis() - time;
        out.printf("Words: %s, length: %s, sentence:%s, time: %s, slice: %s %n", wordCounter, length, sentenceCounter, time, slicer);
        out.println(spaces);
        out.println(wordz);


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
        Pupil pupil = new Pupil();

        for (int index = 0; index < names.length; index++) {
            pupil.setName(names[index]);
            pupil.setGrade(classes[index]);
            pupil.setMark(marks[index]);
            pupil.setBoy(isBoy[index]);
            pupilList.add(pupil);

            if (classes[index] == 8) {
                distribute(eight, pupil);
            } else if (classes[index] == 9) {
                distribute(nine, pupil);
            } else {
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
