package com.classwork.threads.basic;

import static com.classwork.threads.basic.MarksCounterDispatcher.marks;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Caller implements Callable<Wrapper> {
	
    private final Wrapper wrapper;

    public Caller(Wrapper wrapper) {
        this.wrapper = wrapper;
    }
    public Wrapper call() {
    	int count = 0;
		Matcher matcher;

        try (Scanner scanner = new Scanner(this.wrapper.getFile())) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile(marks).matcher(scanner.next());
				if (matcher.find()) {
					count++;
				}
			}        
        } catch (Exception e) {
            System.err.printf("%s", e.getMessage());
        }
        this.wrapper.setCounter(count);
        return this.wrapper;
    }
}
