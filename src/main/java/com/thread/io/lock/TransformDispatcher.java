package com.thread.io.lock;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class TransformDispatcher {
    public static void main(String[] args) {
        Controller.runDoubleThread();
        Controller.runMultiThread();
    }
}

class Controller {
    private Controller() {}
    static Manager manager = new Manager();
    static List<Runs> threadPool = new ArrayList<>();
    static List<String> filenames = new ArrayList<>(Arrays.asList("READ.md", "TODO.md", "HELP.md"));

    public static void runDoubleThread() {
    	long start = System.nanoTime();
        new Counters(manager).thread.start();
        new Transformers(manager).thread.start();
        long end = System.nanoTime();
        System.out.printf("Execution time using dual-threading: %s microseconds%n", (end - start) / 1000);
    }

    public static void runMultiThread() {
        for (String filename : filenames) {
        	threadPool.add(new Counter(filename, manager));
        	threadPool.add(new Transformer(filename, manager));
        }
        long start = System.nanoTime();
        for (int i = 0; i < threadPool.size(); i++) {
			threadPool.get(i).thread.start();
		}
        long end = System.nanoTime();
        System.out.printf("Execution time using multi-threading: %s microseconds%n", (end - start) / 1000);
    }
}

abstract class Runs implements Runnable {
    Thread thread;
    Manager manager;

    Runs(String name, Manager manager) {
        this.manager = manager;
        this.thread = new Thread(this, name);
    }
}

class Counters extends Runs {
    public Counters(Manager manager) {
        super("Counter", manager);
    }

    @Override
    public void run() {
        for (String filename : Controller.filenames) {
            manager.count(new FileWrapper(filename));
        }
    }
}

class Transformers extends Runs {
    public Transformers(Manager manager) {
        super("Transformer", manager);
    }

    @Override
    public void run() {
        for (int n = 0; n < Controller.filenames.size(); n++) {
            manager.transform();
        }
    }
}

class Transformer extends Runs {
    public Transformer(String filename, Manager manager) {
        super(filename, manager);
    }

    @Override
    public void run() {
        manager.transform();
    }
}

class Counter extends Runs {

    public Counter(String filename, Manager manager) {
        super(filename, manager);
    }

    @Override
    public void run() {
        manager.count(new FileWrapper(thread.getName()));
    }
}

class FileWrapper {
	private final File file;
    private final AtomicLong counter;

    public FileWrapper(String filename) {
        this.file = new File(filename);
        this.counter = new AtomicLong();
    }
    public File getFile() {
        return file;
    }
    public long getCounter() {
        return counter.get();
    }
    public void add(long value) {
        this.counter.addAndGet(value);
    }

    private static char changeLowerCase(char[] letters, int n) {
        return letters.length == 1 ? letters[0]
                : (char) (letters[n] >= 96 && letters[n] <= 122 ? letters[n] - 32 : letters[n]);
    }

    synchronized void count() {

        try (Scanner scanner = new Scanner(file)) {

            counter.addAndGet(scanner.findAll(" ").count());
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            notifyAll();
        }
    }

    synchronized void transform() {
        int n;
        int k;
        char[] letters;
        StringBuilder buffer = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {

                letters = scanner.nextLine().toLowerCase().toCharArray();
                for (n = 0; n < letters.length; n++) {

                    k = n;

                    while (n < letters.length && letters[n] != ' ' && letters[n] != ',' && letters[n] != '.'
                            && letters[n] != '\'' && letters[n] != '`' && letters[n] != ';' && letters[n] != ':'
                            && letters[n] != '"' && letters[n] != '?' && letters[n] != '!' && letters[n] != '–'
                            && letters[n] != '(' && letters[n] != ')' && letters[n] != '{' && letters[n] != '}'
                            && letters[n] != '[' && letters[n] != ']' && letters[n] != '«' && letters[n] != '»'
                            && letters[n] != '@' && letters[n] != '…' && letters[n] != '„' && letters[n] != '“'
                            && letters[n] != '”' && letters[n] != '*' && letters[n] != '_' && letters[n] != '\t') {
                        n++;
                    }

                    if (counter.get() % 2 != 0 && (n > 0)) {
                        letters[n - 1] = changeLowerCase(letters, n - 1);
                    } else {
                        letters[k] = changeLowerCase(letters, k);
                    }
                }

                buffer.append(new String(letters));
                buffer.append(System.lineSeparator());
            }

            try (PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8)) {
                writer.append(buffer.toString());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            notifyAll();
        }
    }
}

class Manager {
    private FileWrapper resource;
    private final AtomicBoolean lock = new AtomicBoolean(false);

    synchronized void transform() {
        while (!lock.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("InterruptedException");
            }
        }
        resource.transform();
        lock.set(false);
        notifyAll();
        
        System.out.printf("The %s of all the words found in file %s have been capitalized by %s-thread #%s%n",
                resource.getCounter() % 2 == 0 ? "first letters" : "last letters",
                resource.getFile().getName(),
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
    }

    synchronized void count(FileWrapper resource) {
        while (lock.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("InterruptedException");
            }
        }
        this.resource = resource;
        resource.count();
        lock.set(true);
        notifyAll();

        System.out.printf("%s spaces found in file %s by %s-thread #%s%n",
                resource.getCounter(),
                resource.getFile().getName(),
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
    }
}