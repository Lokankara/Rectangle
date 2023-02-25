package main.java.com.homework.threads.sparrow;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Runners {
    public static void main(String[] args) {

        List<String> fileNames = List.of("f1", "f2", "f3");

        List<FileWrapper> fileWrappersList = fileNames.stream()
                .map(FileWrapper::new)
                .toList();

        new Counter(fileWrappersList);
        new WordsModifier(fileWrappersList);

    }

}

class Counter implements Runnable {
    private List<FileWrapper> fileWrappersList;

    public Counter(List<FileWrapper> fileWrappersList) {
        this.fileWrappersList = fileWrappersList;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Method run  invoked in Counter");

        for (var fileWrapper : fileWrappersList) {
            fileWrapper.countSpaces();
        }
    }
}


class WordsModifier implements Runnable {

    private final List<FileWrapper> fileWrappersList;

    public WordsModifier(List<FileWrapper> fileWrappersList) {
        this.fileWrappersList = fileWrappersList;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Method run  invoked in WordsModifier");

        for (var fileWrapper : fileWrappersList) {
            fileWrapper.capitalizeLetters();
        }
    }
}


class FileWrapper {
    private final String fileName;

    private int spacesCount;
    private boolean spacesAreCounted = false;

    public FileWrapper(String fileName) {
        this.fileName = fileName;
    }

    public synchronized void countSpaces() {
        while (spacesAreCounted) {
            try {
                System.out.println("Wait ");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Method countSpaces invoked fileName: " + fileName);
        spacesCount = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (char c : line.toCharArray()) {
                    if (c == ' ') {
                        spacesCount++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        spacesAreCounted = true;
        notify();
    }

    public synchronized void capitalizeLetters() {
        while (!spacesAreCounted) {
            try {
                wait();
                System.out.println("Wait ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("capitalizeLetters: " + spacesCount);
        try (Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(fileName)));
             BufferedWriter output = new BufferedWriter(new FileWriter(fileName.substring(0, fileName.length()) + "new.txt"))) {

            String inputLine;
            String outputLine;

            while (input.hasNextLine()) {
                inputLine = input.nextLine();

                outputLine = Pattern.compile(spacesCount % 2 == 0 ? Regexes.FIRST_LETTER : Regexes.LAST_LETTER)
                        .matcher(inputLine)
                        .replaceAll(m -> m.group().toUpperCase());

                output.write(outputLine + "\n");
            }
            spacesAreCounted = false;
            notifyAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


interface Regexes {
    String WORD_REGEX = "\\b[\\w]{1,}\\b";
    String SPACE_REGEX = " ";

    String FIRST_LETTER = "\\b\\w";
    String LAST_LETTER = "\\w\\b";
}