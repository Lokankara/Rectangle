package com.classwork.threads.accumulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccumulatorDispatcher {
	public static final String path = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\";

	public static void main(String[] args) {

		final List<String> filenames = new ArrayList<>(Arrays.asList("HELP.md", "README.md", "TODO.md"));

		long sync = Controller.syncStart(filenames);

		long atomic = Controller.atomicStart(filenames);

		System.out.printf("Time using atomic concurrent: %d microseconds%n", atomic / 1_000);

		System.out.printf("Time using synchronized keyword: %d microseconds%n", sync / 1_000);

		System.err.printf("Difference: %s microseconds%n", (sync - atomic) / 1000);
	}
}
