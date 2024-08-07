package com.thread.lock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TripleTest {

    Counter counter = new Counter();

    @Test
    public final void anti_cheat() {
        try {
            Files.lines(Paths.get("/workspace/solution.txt"))
                    .forEach(line -> {
                        String detected = detectTriggers(line);
                        if (detected != null) {
                            fail("Anti-Cheat Triggered for: '" + detected + "'");
                        }
                    });
        } catch (IOException e) {
            fail("file opening failed");
        }
    }

    private final String[] triggers = new String[]{
            "\\u", "reflect", "field", "getclass"
    };

    private final String detectTriggers(String line) {
        line = line.toLowerCase();
        for (String trigger : triggers) if (line.contains(trigger)) return trigger;
        return null;
    }

    @Test
    public void the_correct_numbers_are_counted() {

        ThreadedCounting.countInThreads(counter);

        Set<Integer> expected = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> actual = new HashSet<>(counter.getNumbers());

        assertEquals(expected, actual);
    }

    @Test
    public void the_correct_numbers_are_counted_in_sequence() {

        ThreadedCounting.countInThreads(counter);

        List<Integer> expected = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> actual = counter.getNumbers();

        assertEquals(
                expected, actual);
    }

    @Test
    public void three_threads_are_used() {
        Counter counter = new Counter();
        ThreadedCounting.countInThreads(counter);

        assertEquals(3, counter.getThreadIds().size());
    }

    @Test
    public void numbers_are_in_the_correct_threads() {

        ThreadedCounting.countInThreads(counter);

        List<Integer> expected1 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expected2 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 2)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expected3 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 0)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(
                expected1, counter.getNumbersInSameThreadAs(1));
        assertEquals(
                expected2, counter.getNumbersInSameThreadAs(2));
        assertEquals(
                expected3, counter.getNumbersInSameThreadAs(3));
    }

    @Test
    public void the_correct_numbers_are() throws InterruptedException {


        ThreadedCounting.countInThreads(counter);

        Set<Integer> expected = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> actual = new HashSet<>(counter.getNumbers());

        assertEquals(
                expected, actual);
    }

    @Test
    public void the_correct_numbers_in_sequence() throws InterruptedException {


        ThreadedCounting.countInThreads(counter);

        List<Integer> expected = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> actual = counter.getNumbers();

        assertEquals(
                expected, actual);
    }

    @Test
    public void three_threads_are_used_size() throws InterruptedException {
        ThreadedCounting.countInThreads(counter);

        assertEquals(
                3, counter.getThreadIds().size());
    }

    @Test
    public void numbers_are_in_the_correct_threads_size() throws InterruptedException {


        ThreadedCounting.countInThreads(counter);

        List<Integer> expected1 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expected2 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 2)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expected3 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 0)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(
                expected1, counter.getNumbersInSameThreadAs(1));
        assertEquals(
                expected2, counter.getNumbersInSameThreadAs(2));
        assertEquals(
                expected3, counter.getNumbersInSameThreadAs(3));
    }
}