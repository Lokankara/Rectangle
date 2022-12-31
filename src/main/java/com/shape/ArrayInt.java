package com.shape;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayInt {

    private static final int size = 25;

    public static void main(String[] args) {

        int sumEven = 0;
        int even = 0;


        int[] pros = new int[size];
        int[] cons = new int[size];

        int[] array = IntStream.range(0, size).map(i -> getRandomNumber(-100, 100)).toArray();

        Arrays.stream(array).distinct().toArray();

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                even++;
                sumEven += array[i];
            }
            if (array[i] > 0) {
                pros[i] = array[i];
            } else {
                cons[i] = array[i];
            }
        }

        int[] prosArray = trim(pros);
        int[] consArray = trim(cons);
        int minP = Arrays.stream(prosArray).min().getAsInt();
        int maxC = Arrays.stream(consArray).max().getAsInt();

        int[] newArray = modification(array);
        //  int[] consDecrease = modification(consArray, -1);

        out.println("Even Count: " + even);
        out.println("Even Sum: " + sumEven);
        out.println("Max consArray: " + maxC);
        out.println("Min prosArray: " + minP);
        out.println("Array: " + Arrays.toString(array));
        out.println("Increase: " + Arrays.toString(newArray));

        out.println("Average: " + Arrays.toString(new double[]{average(array)}));

        out.println("Delete min and max: ");
        int[] remove = remove(array, minP, maxC);
        out.println("removed: " + remove);

        out.println("Amount: " + Arrays.toString(new int[]{amount(array)}));

        Arrays.sort(array);
        out.println("sorted: " + Arrays.toString(array));


    }

    private static int[] remove(int[] array, int minP, int maxC) {
        return IntStream.range(0, array.length)
                .filter(i -> i != minP || i != maxC)
                .map(i -> array[i])
                .toArray();
    }

    private static int[] modification(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                result[i] = array[i] + 1;
            } else if (array[i] < 0) {
                result[i] = array[i] - 1;
            }
        }
        return result;
    }

    private static int[] trim(int[] array) {
        int i = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[i++] = array[j];
            }
        }

        int[] result = new int[i];
        System.arraycopy(array, 0, result, 0, i);
        return result;
    }

    private static int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static double average(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return (double) sum / array.length;
    }

    public static int amount(int[] array) {
        int count = 0;
        for (int j : array) {
            if (j > average(array)) {
                count++;
            }
        }
        return count;
    }
}

