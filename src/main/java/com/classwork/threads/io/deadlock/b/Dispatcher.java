package com.classwork.threads.io.deadlock.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dispatcher {

	public static void main(String[] args) {

		ArrayList<String> filenames = new ArrayList<>(Arrays.asList("f1","f4", "f5", "f4"));

//		Controller.runDuoThreads(filenames);
		 Controller.runMultiThreads(filenames);

	}
}

class Controller {

	public static void runDuoThreads(ArrayList<String> filenames) {

		List<Wrapper> files = new ArrayList<>();

		for (String filename : filenames) {

			files.add(new Wrapper(filename));
		}

		for (Wrapper wrapper : files) {
			new CounterTwoRunner(wrapper);
			new TransformDuoRunner(wrapper);
		}

	}

	public static void runMultiThreads(ArrayList<String> filenames) {

		List<Wrapper> files = new ArrayList<>();
		List<Thread> threadPool = new ArrayList<>();

		for (String filename : filenames) {
			files.add(new Wrapper(filename));
		}

		for (Wrapper wrapper : files) {
			threadPool.add(new Thread(new CounterMultiRunner(wrapper)));
			threadPool.add(new Thread(new CounterMultiRunner(wrapper)));
			threadPool.add(new Thread(new TransformMultiRunner(wrapper)));
			threadPool.add(new Thread(new TransformMultiRunner(wrapper)));
			threadPool.add(new Thread(new TransformMultiRunner(wrapper)));
		}

		for (Thread thread : threadPool) {
			try {
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
