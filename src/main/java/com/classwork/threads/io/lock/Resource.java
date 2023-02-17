package com.classwork.threads.io.lock;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Resource {
	private final File file;
    private final AtomicLong counter;

    AtomicLong lines = new AtomicLong();
    Map<Long, String> map = new ConcurrentHashMap<>();
	private String nextLine;
	private Scanner sc;

    public Resource(String filename) {
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

    void count() {

        try (Scanner scanner = new Scanner(file)) {
            
            while(scanner.hasNextLine()) {
            	nextLine = scanner.nextLine();
            	sc = new Scanner(nextLine);
            	while(sc.hasNext()) {
            		if(sc.next()!= null) {
            			counter.incrementAndGet();            			
            		}
            	}
            	map.put(lines.incrementAndGet(), nextLine);
            }
//            counter.addAndGet(scanner.findAll(" ").count());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
//            notifyAll();
//            System.out.println(map);
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