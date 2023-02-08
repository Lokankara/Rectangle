package com.homework.threads.io;

import static com.homework.threads.io.BattleThreads.marks;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

class Wrapper implements Comparable<Wrapper> {

	private final File file;
	private int counter;

	public Wrapper(File file) {
		super();
		this.file = file;
	}

	public Integer getCounter() {
		return counter;
	}

	void countMarks() {
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				if (Pattern.compile(marks).matcher(scanner.next()).find()) {
					counter++;
				}
			}
		} catch (IOException e) {
			System.err.printf("%s", e.getMessage());
		}
	}
	@Override
	public int compareTo(Wrapper file) {
		return Integer.compare(file.counter, this.counter);
	}
	@Override
	public int hashCode() {
		return Objects.hash(counter, file);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wrapper other = (Wrapper) obj;
		return Objects.equals(counter, other.counter) && Objects.equals(file, other.file);
	}
	@Override
	public String toString() {
		return String.format("There are %s punctuation marks in %s", counter, file.getName());
	}
}