package com.homework.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ParallelStream {
    private static final String[] FIRST_NAMES = {"Adam", "Bob", "Charlie", "David", "Edward", "Frank", "George", "Harry", "Isaac", "John", "Kevin", "Luke", "Mike", "Nathan", "Oliver", "Peter", "Quincy", "Robert", "Steven", "Tom", "Ulysses", "Victor", "William", "Xavier", "Yuri", "Zachary"};
    private static final String[] NAMES = {"John", "Jane", "Mike", "Sarah", "David", "Emily", "Tom", "Kate", "Alex", "Julia"};

    public static void main(String[] args) {
        List<String> nameList = Stream.of(NAMES, FIRST_NAMES).flatMap(Arrays::stream).collect(toCollection(ArrayList::new));

//        Map<Integer, Set<String>> treeSetMap = nameList.stream().parallel().collect(groupingBy(String::length, toCollection(TreeSet::new)));
//        Map<Integer, List<String>> treeSetMap = nameList.stream().parallel().collect(groupingBy(String::length, mapping(String::toUpperCase, toList())));
//        Map<Integer, String> treeSetMap = nameList.stream().parallel().collect(groupingBy(String::length, joining(", ")));
//        Map<Integer, Long> treeSetMap = nameList.stream().parallel().collect(groupingBy(String::length, counting()));
//        treeSetMap.entrySet().forEach(System.out::println);

        List<Integer> numbers = LazyEager.getNumbers(0, 10, 1000000);
//        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().parallel().collect(partitioningBy(i -> i % 2 == 0));
//        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().parallel().collect(partitioningBy(i -> i < 0, mapping(n -> n % 2 == 0 ? n * 2 : n * 5, toList())));

        long startP = System.nanoTime();
        Stream<Integer> stream = numbers.stream();
        Map<Integer, Long> parallelMap = stream.sorted().filter(e -> e % 2 == 0).collect(groupingBy(n -> n, counting()));
        long endP = System.nanoTime();
        System.out.printf("parallel Execute time, %s%s%n", (endP - startP) / 1000, parallelMap);


        Stream<Integer> stream2 = numbers.stream().parallel();
        long startS = System.nanoTime();
        Map<Integer, Long> sequentialMap = stream2.sorted().filter(e -> e % 2 == 0)
                .collect(groupingBy(n -> n, counting())).entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        long endS = System.nanoTime();
        System.out.printf("sequential Execute time, %s%s%n", (endS - startS) / 1000, sequentialMap);

        Map<Integer, Long> parallel = numbers.stream().sorted().filter(e -> e % 2 == 0).collect(groupingBy(n -> n, counting()));
        TreeMap<Integer, Long> sortedByValues = new TreeMap<>(
                (k1, k2) -> parallel.get(k1).compareTo(parallel.get(k2)) == 0
                        ? 1 : parallel.get(k1).compareTo(parallel.get(k2)));
        sortedByValues.putAll(parallel);

        System.out.printf("sequential Execute time, %s%s%n", (endS - startS) / 1000, sortedByValues);

    }
//Task
//    take items from the list of employees, select those under 40, sort by last name, and put them in a new list.
//   read all the json files in the books folder, deserialize them into a list of book objects,
//   process the items in all those lists, and then group the books by author.
}
