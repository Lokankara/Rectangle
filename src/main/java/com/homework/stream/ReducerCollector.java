package com.homework.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class ReducerCollector {
    private static final String[] FIRST_NAMES = {"Adam", "Bob", "Charlie", "David", "Edward", "Frank", "George", "Harry", "Isaac", "John", "Kevin", "Luke", "Mike", "Nathan", "Oliver", "Peter", "Quincy", "Robert", "Steven", "Tom", "Ulysses", "Victor", "William", "Xavier", "Yuri", "Zachary"};
    private static final String[] NAMES = {"John", "Jane", "Mike", "Sarah", "David", "Emily", "Tom", "Kate", "Alex", "Julia"};

    public static void main(String[] args) {
        Function<Integer, ArrayList> keyMapper = ArrayList::new;
        Function<Integer, ArrayList> valueMapper = ArrayList::new;
        List<String> nameList = Stream.of(NAMES, FIRST_NAMES).flatMap(Arrays::stream).collect(toCollection(ArrayList::new));

        Collector<String, ?, Map<Boolean, Long>> collector = Collectors.partitioningBy(s -> s.length() > 4, Collectors.counting());
        Map<Boolean, Long> booleanLongMap = nameList.stream().collect(collector);

        Collector<String, ?, Map<Boolean, List<String>>> collectorList = Collectors.partitioningBy(s -> s.length() > 4);
        Map<Boolean, List<String>> listMap = nameList.stream().collect(collectorList);

        Collector<String, ?, Map<Integer, List<String>>> collectorString = Collectors.groupingBy(String::length);
        Map<Integer, List<String>> integerListMap = nameList.stream().collect(collectorString);

        Collector<String, ?, Map<Integer, Set<String>>> collectorSet = Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new));
        Map<Integer, Set<String>> integerSetMap = nameList.stream().collect(collectorSet);

        Collector<String, ?, Map<Integer, String>> mapCollector = Collectors.toMap(String::length, Function.identity(), "%s %s"::formatted, ConcurrentHashMap::new);
        Map<Integer, String> collectMap = nameList.stream().collect(mapCollector);


        Collector<String, ?, LinkedHashMap<Character, String>> linkedCollector = Collectors.toMap(name -> name.charAt(0), name -> name, "%s, %s"::formatted, LinkedHashMap::new);
        LinkedHashMap<Character, String> linkedHashMap = nameList.stream().collect(linkedCollector);

        Collector<List<Integer>, ?, List<Integer>> flatMapping = Collectors.flatMapping(l -> l.stream().filter(i -> i % 2 == 0), Collectors.toList());
        List<Integer> listInt = Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)).collect(flatMapping);

        Collector<List<Integer>, ?, Map<Integer, List<Integer>>> listMapCollector = Collectors.groupingBy(Collection::size, Collectors.flatMapping(l -> l.stream().filter(i -> i % 2 == 0), Collectors.toList()));
        Map<Integer, List<Integer>> map = Stream.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10)).collect(listMapCollector);

        System.out.println(map);
        System.out.println(listInt);
        System.out.println(linkedHashMap);
        System.out.println(collectMap);
        System.out.println(integerSetMap);
        System.err.println(listMap.get(true));
        System.err.println(listMap.get(false));
        System.out.println(booleanLongMap);
        System.out.println(integerListMap);

        Map<Boolean, List<Integer>> numbers = positiveOrNegative(1, 10, 8, 5);
        List<Integer> more = numbers.get(false);
        List<Integer> less = numbers.get(true);

        Supplier<TreeSet<String>> treeSetSupplier = TreeSet::new;

        List<String> names = Stream.of(FIRST_NAMES, NAMES)
                .flatMap(Arrays::stream)
                .filter(name -> name.startsWith("J"))
                .collect(toCollection(ArrayList::new));

        System.out.println(names);
        System.out.println("List names: " + nameList);

        ArrayList<Integer> collect = more.stream().collect(ArrayList::new, (list, element) -> list.add(element * 2), ArrayList::addAll);

        System.out.println((collect));


        Integer reduce = more.stream().reduce(1, (a, b) -> a * b, (a, b) -> a + b + 2);
        System.out.println(reduce);

        List<Integer> list = Stream
                .of(more, less)
                .flatMap(Collection::stream)
                .collect(toCollection(ArrayList::new));

        System.out.println(list);

        List<Integer> all = new ArrayList<>();
        Arrays.asList(more, less).forEach(all::addAll);
        System.err.println(all);

        List<Integer> finalList = list;
        List<Integer> integerList = list.stream().filter(i -> i > finalList.stream().mapToInt(integer -> integer).sum() / finalList.size()).toList();
        int i1 = list.stream().mapToInt(integer -> integer).sum() / list.size();
        System.out.println(i1);
        System.out.println(integerList);

        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();

        List<Integer> integers = list.stream().filter(i -> i > stats.getAverage()).toList();

        System.err.println(stats.getAverage());
        System.err.println(integers);

        list = IntStream.concat(list.stream().filter(i -> i != stats.getMax())
                                .filter(i -> i != stats.getMin())
                                .mapToInt(Integer::intValue),
                        IntStream.of(stats.getMin(), stats.getMax()))
                .boxed().toList();

        System.out.println(list);
    }

    private static Map<Boolean, List<Integer>> positiveOrNegative(int min, int max, int range, int condition) {
        return ThreadLocalRandom.current()
                .ints(min, max + 1)
                .limit(range)
                .boxed()
                .collect(Collectors.groupingByConcurrent(n -> n < condition));
    }
}
