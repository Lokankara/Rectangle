package com.classwork.threads.io.atomic;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtomicRunner implements Runnable{
	
	private final Accumulator wrapper;
	
	public AtomicRunner(Accumulator wrapper) {
		super();
		this.wrapper = wrapper;
	}

	public Accumulator getWrapper() {
		return wrapper;
	}

	@Override
	public void run() {
		Matcher matcher;
		try (Scanner scanner = new Scanner(wrapper.getFile())) {
			while (scanner.hasNext()) {
				matcher = Pattern.compile("\\d[0-9]{1,13}([,\\.][0-9]{1,5})?").matcher(scanner.next());
				if (matcher.find()) {
					wrapper.getLock().lock();
					AICounter.sum++;
//					AtomicCounter.sum.set(Double.parseDouble(matcher.group().replace(",", ".")));
//					AtomicCounter.getAndAdd(Double.parseDouble(matcher.group().replace(",", ".")));
				}
			}
		} catch (IOException e) {
			System.out.printf("%s", e.getMessage());
		} finally {
			wrapper.getLock().unlock();
		}	
	}
}
