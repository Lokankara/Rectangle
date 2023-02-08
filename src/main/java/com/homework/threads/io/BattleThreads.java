package com.homework.threads.io;

import java.util.List;

public class BattleThreads {
	public static final String marks = "[`'\"*«»“”„,;:?!….\\-‒—―|#~%@&]";

	public static void main(String[] args) {

		List<String> filenames = DirReader.searchFiles(".txt");
		
		System.out.printf("Found %s file(s): %s%n", filenames.size(), filenames);

		long durationOneThread = Controller.readSingleThread(filenames);
		long durationMultiThread = Controller.readMultiThreads(filenames);
		long durationRunnerMultiThread = Controller.runMultiThreads(filenames);

//		Controller.oneTreeSet.forEach(System.out::println);
		Controller.runTreeSet.forEach(System.out::println);
		Controller.multiTreeSet.forEach(System.out::println);

		System.out.printf("Single-threaded mode file reading time: %d millis%n", durationOneThread / 1_000);
		System.out.printf("Execute-threaded mode file reading time: %d millis%n", durationMultiThread / 1_000);
		System.out.printf("Runnable-threaded mode file reading time: %d millis%n", durationRunnerMultiThread / 1_000);
		System.out.printf("Single-mode duration difference: %s milliseconds%n",
				(durationOneThread - durationMultiThread) / 1_000_000);
		System.out.printf("Multi-mode duration difference: %s milliseconds%n",
				(durationMultiThread - durationRunnerMultiThread ) / 1_000_000);
	}
}
