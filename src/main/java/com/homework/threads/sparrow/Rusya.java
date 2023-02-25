package main.java.com.homework.threads.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Rusya {

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] files = { "f1", "f2", "f3" };
        long startTime = 0L;
        // WIth notify
        startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (String file : files) {
            FileAction fileAction = new FileAction(file);
            executorService.execute(fileAction.getFirstAction());
            executorService.execute(fileAction.getSecondAction());
        }
        executorService.shutdown();
        System.out.println("With notify wait: " + (System.nanoTime() - startTime)/1000 + " ms");

        // Without notify
        startTime = System.nanoTime();
        List<Thread> threads = new ArrayList<>();
        for (String file : files) {
            threads.add(new Thread(() -> {
                long spaceCount;
                try {
                    spaceCount = FileHandler.countSpaces(file);
                    if (spaceCount % 2 == 0) {
                        FileHandler.capitalizeFirstLetter(file);
                    } else {
                        FileHandler.capitalizeLastLatter(file);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Without notify wait: " + ((System.nanoTime() - startTime)/1000) + " ms");
    }
}

class FileAction {
    private long spaceCount = -1;
    private String filename;

    public FileAction(String filename) {
        this.filename = filename;
    }

    public synchronized void setSpaceCount() {
        try {
            spaceCount = FileHandler.countSpaces(filename);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        notifyAll();
    }

    public synchronized void capitalize() {
        try {
            while (spaceCount == -1) {
                wait();
            }
        } catch (InterruptedException e1) {
            System.out.println("Inerrupted");
        }

        try {
            if (spaceCount % 2 == 0) {
                FileHandler.capitalizeFirstLetter(filename);
            } else {
                FileHandler.capitalizeLastLatter(filename);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public Runnable getFirstAction() {
        return this::setSpaceCount;
    }

    public Runnable getSecondAction() {
        return () -> this.capitalize();
    }

}

class FileHandler {
    public static long countSpaces(String filename) throws IOException {
        return Files.lines(Paths.get(filename)).mapToLong(line -> line.chars().filter(c -> c == ' ').count()).sum();
    }

    public static void capitalizeFirstLetter(String filename) throws IOException {
        List<String> replaced = Files.lines(Paths.get(filename)).map(line -> capitalizeLettersByPattern("\\b\\w", line))
                .collect(Collectors.toList());
        Files.write(Paths.get(filename), replaced);
    }

    public static void capitalizeLastLatter(String filename) throws IOException {
        List<String> replaced = Files.lines(Paths.get(filename)).map(line -> capitalizeLettersByPattern("\\w\\b", line))
                .collect(Collectors.toList());
        Files.write(Paths.get(filename), replaced);
    }

    private static String capitalizeLettersByPattern(String pattern, String line) {
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        StringBuilder res = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(res, matcher.group().toUpperCase());
        }
        matcher.appendTail(res);
        return res.toString();
    }
}