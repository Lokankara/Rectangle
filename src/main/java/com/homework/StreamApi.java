package com.homework;

// масив розділити на дві колекції:
//         + від’ємних та додатніх чисел,
//         - парних та непарних чисел,
//         - визначити середні арифметичні двох масивів, утворити колекцію з елементів обидвох
//         масивів, що знаходяться в межах між значеннями середніх арифметичних.

//         2.Із використанням стандартних функціональних інтерфейсів з пакету java.util.function
//         та лямбда-виразів розділити кілька вхідних колекцій об’єктів класу Car із полем int
//         maxSpeed на дві колекції з об’єктів, швидкість яких менше (перша колекція) та не
//         менше (друга колекція) заданого значення.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    static List<Integer> positive = new ArrayList<>();
    static List<Integer> negative = new ArrayList<>();
    static List<Integer> range = new ArrayList<>();
    static List<Integer> even = new ArrayList<>();
    static List<Integer> odd = new ArrayList<>();
    static Integer[] array = {7, 6, 10, -1, 4, 3, -9, 2, -6, -7, -5, 8};

    static ArrayList<Integer> numberList = (ArrayList<Integer>) List.of(array);
    static Predicate<Integer> isNeg = i -> i < 0;
    static Predicate<Integer> isPos = i -> i > 0;
    static Predicate<Integer> isEven = i -> i % 2 == 0;
    static Predicate<Integer> isOdd = i -> i % 2 != 0;
    static BinaryOperator<Integer> accumulator = Integer::sum;


    public static void main(String[] args) {
        System.out.println("StreamApi");
        StreamApi api = new StreamApi();
        api.start();

        int averagePos = sum(positive.stream()).get() / positive.size();
        int averageNeg = sum(negative.stream()).get() / negative.size();
//        numberList.stream()range(averageNeg, averagePos).forEach(range::add);
        int[] runs = IntStream.range(0, array.length)
                .filter(i -> i == 0 || array[i] > array[i])
                .toArray();
        System.out.println(Arrays.toString(runs));

        System.out.println("average positive = " + averagePos);
        System.out.println("average negative = " + averageNeg);
        System.out.printf("Range number list between %d and %d: %s", averagePos, averageNeg, range);
    }

    public static Optional<Integer> sum(Stream<Integer> stream) {
        return stream.reduce(accumulator);
    }

    public void start() {
        System.out.println("start");

        numberList.stream().filter(isPos)
                .forEach(positive::add);

        numberList.stream()
                .filter(isNeg)
                .forEach(negative::add);

        numberList.stream()
                .filter(isEven)
                .forEach(even::add);

        numberList.stream()
                .filter(isOdd)
                .forEach(odd::add);

    }
}
