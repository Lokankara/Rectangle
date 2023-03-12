package com.homework.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyEager {

    public static void main(String[] args) {

        String path = "";
        String filename = "matrix.txt";
        String sentences = readFile(path + filename);

        //Task#1 - the beginning of each word with a capital letter
        String upperCaseWords = capitalize(sentences);
        System.out.println(upperCaseWords);

        //Task#2 - display all sentences of the text in increasing number of words
        printSortedSentences(sentences);

        //Task#3.1 -divide the collection of integers into collections of positive and negative elements.
        List<Integer> numbers = getNumbers(-100, 100, 20);
        List<Integer> positive = positiveOrNegative(numbers, true);
        List<Integer> negative = positiveOrNegative(numbers, false);
        print("Source numbers: ", numbers);
        print("Positive numbers: ", positive);
        print("Negative numbers: ", negative);

        //Task#3.2 -divide the collection of integers into collections of positive and negative elements.
        Map<Boolean, List<Integer>> positiveOrNegative = positiveOrNegative(-100, 100, 20);
        print("Positive numbers: ", positiveOrNegative.get(true));
        print("Negative numbers: ", positiveOrNegative.get(false));
    }

    private static String readFile(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    private static String capitalize(String sentences) {
        return Pattern.compile("\\b[a-z]")
                .matcher(sentences)
                .replaceAll(matcher -> matcher.group().toUpperCase());
    }

    private static void printSortedSentences(String sentences) {
        Pattern.compile("[^.!?]+[.!?]+(\\s|$)")
                .matcher(sentences)
                .results()
                .map(MatchResult::group)
                .filter(word -> !word.isEmpty())
                .map(sentence -> Arrays.stream(sentence.split("[\\s\\-]"))
                        .filter(word -> word.length() > 0)
                        .toList())
                .sorted(Comparator.comparingInt(List::size))
                .map(list -> String.join(" ", list))
                .toList().forEach(System.out::println);
    }

    public static List<Integer> getNumbers(int min, int max, int range) {
        return IntStream
                .range(0, range)
                .mapToObj(i -> ThreadLocalRandom.current().nextInt(min, max + 1))
                .toList();
    }

    private static List<Integer> positiveOrNegative(List<Integer> numbers, boolean flag) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > -1))
                .get(flag);
    }

    private static Map<Boolean, List<Integer>> positiveOrNegative(int min, int max, int range) {
        return ThreadLocalRandom.current()
                .ints(min, max + 1)
                .limit(range)
                .boxed()
                .collect(Collectors.groupingByConcurrent(n -> n > -1));
    }

    private static void print(String message, Object data) {
        System.out.printf("%s%s%n", message, data);
    }
}
