package com.homework.kata;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.homework.kata.Stats.getMinAvgMax;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatsTest {
    @Test
    public void testGetMinAvgMax() {
        int discard = 2;
        double[][] data = {{800, 1200, 2100, 4100, 1300, 700}, {1000, 1500, 4500, 5000, 5800, 2000, 1500}};
        double[][] expect = {{2100, 3100, 4100}, {4500, 5100, 5800}, {2100, 4300, 5800}};
        double[][] actual = getMinAvgMax(discard, data);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testRandom1() {
        testRandom(2, 3, 5, 2);
    }

    @Test
    public void testRandom2() {
        testRandom(5, 5, 10, 5);
    }

    @Test
    public void testRandom3() {
        testRandom(50, 50, 100, 20);
    }

    @Test
    public void testRandom4() {
        testRandom(500, 500, 1000, 200);
    }

    private void testRandom(int arrays, int lenMin, int lenMax, int discard) {
        Random rnd = new Random();
        double[][] data = rnd
                .ints(arrays, lenMin + 2 * discard, lenMax + 2 * discard)
                .mapToObj(len -> rnd.ints(len, 0, 10000).mapToDouble(i -> i).toArray())
                .toArray(double[][]::new);
        double[][] expect = getMinAvgMax(discard, data);
        double[][] actual = getMinAvgMax(discard, data);
        assertEquals(expect.length, actual.length);
        for (int i = 0; i < expect.length; i++) {
            assertArrayEquals(expect[i], actual[i], 1e-6);
        }
    }
}
