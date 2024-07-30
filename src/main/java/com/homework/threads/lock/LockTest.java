package com.homework.threads.lock;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockTest {

    private static final Path TEST_FILES_DIR = Paths.get("", "", "");
    final DoubleAdder totalSum = new DoubleAdder();
    final CountDownLatch latch = new CountDownLatch(3);

    @Test
    public void testSummingThreads() throws IOException {
        // Create some sample data to read from
        String[] data = {
                "1 2 3 4 5",
                "6 7 8 9 10",
                "11 12 13 14 15"
        };

        File[] files = new File[3];

        for (int i = 0; i < files.length; i++) {
            files[i] = File.createTempFile("test", ".txt");
            FileWriter writer = new FileWriter(files[i]);
            writer.write(data[i]);
            writer.close();
        }

        List<Wrapper> wrappers = Arrays.stream(files).map(file -> new Wrapper(file.getName(), latch, totalSum)).toList();

        List<Runner> runners = IntStream.range(0, 10).mapToObj(i -> new Runner(i + 1, wrappers)).toList();

        runners.forEach(runner -> runner.thread.start());

        String expected = "Total sum: 120.0";
        String actual = new String(Files.readAllBytes(Paths.get("output.txt")));
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleFiles() throws InterruptedException {

        Path inputFile1 = TEST_FILES_DIR.resolve("file.txt");
        Runner summingThreads = new Runner(1, List.of(new Wrapper(inputFile1.toString(), latch, totalSum)));
        Thread thread = new Thread(summingThreads);
        thread.start();
        thread.join();
//        assertEquals(49.1, Locker.totalSum.doubleValue(), 0.01);
    }
//        Locker summingThreads = new Locker(files[0].getPath(), files[1].getPath(), files[2].getPath());
//        Thread t = new Thread(summingThreads).start();
//        t.join();
//    @Test
//    public void testSingleFile() throws IOException, InterruptedException {
//        Path inputFile = TEST_FILES_DIR.resolve("file1.txt");
//        Runner summingThreads = new Runner(1,  List.of(new Wrapper(inputFile.toString(), latch, totalSum)));
//        Thread thread = new Thread(summingThreads);
//        thread.start();
//        thread.join();
//        assertEquals(22.5, totalSum.doubleValue(), 0.01);
//    }
    //    @Test
//    public void testSingleFile() throws IOException, InterruptedException {
//        Path inputFile = TEST_FILES_DIR.resolve("file1.txt");
//        SummingThreads summingThreads = new SummingThreads(new FileWrapper(inputFile.toString()));
//        Thread thread = new Thread(summingThreads);
//        thread.start();
//        thread.join();
//        assertEquals(22.5, summingThreads.getTotalSum(), 0.01);
//    }
//
//    @Test
//    public void testMultipleFiles() throws IOException, InterruptedException {
//        Path inputFile1 = TEST_FILES_DIR.resolve("file1.txt");
//        Path inputFile2 = TEST_FILES_DIR.resolve("file2.txt");
//        SummingThreads summingThreads1 = new SummingThreads(new FileWrapper(inputFile1.toString()));
//        SummingThreads summingThreads2 = new SummingThreads(new FileWrapper(inputFile2.toString()));
//        Thread thread1 = new Thread(summingThreads1);
//        Thread thread2 = new Thread(summingThreads2);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        assertEquals(49.1, summingThreads1.getTotalSum() + summingThreads2.getTotalSum(), 0.01);
//    }
}