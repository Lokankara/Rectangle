package com.classwork.threads.io;

import static com.classwork.threads.basic.MarksCounterDispatcher.marks;
import static com.classwork.threads.basic.MarksCounterDispatcher.path;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadTest {

	static Integer count = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		ReaderManager.getInstance().read();

//	Book r = new Book();
		Runnable run = () -> {
			long start = System.nanoTime();
				String name = Thread.currentThread().getName();
				System.out.println("Run by " + name);

				Pattern pattern = Pattern.compile(marks);
				Matcher matcher;
				try (Scanner scanner = new Scanner(new File(String.format("%s%s%s", path,"src\\main\\resources\\", name)))) {

					while (scanner.hasNext()) {
						matcher = pattern.matcher(scanner.next());
							if (matcher.find()) {
								System.out.println(matcher.group());
								count++;
						}
					}
				} catch (Exception e) {
					System.err.printf("%s", e.getMessage());
				}
				long end= System.nanoTime();
				System.out.println("Run by " + (end-start)/1000000);
		};

		Thread foo = new Thread(run);
		Thread bar = new Thread(run);
		Thread buzz = new Thread(run);

		foo.setName("matrix.txt");
		bar.setName("robot.txt");
		buzz.setName("robby.txt");
//
		foo.start();
		bar.start();
		buzz.start();

//	List<String> searchFiles = DirReader.searchFiles(".txt");
//	FileReader.readFile(searchFiles.get(0));

//		execute();

	}

	private static void execute() {
		String[] split = marks.split("");

		Runnable run = () -> {

			for (int i = 0; i < split.length; i++) {

				try {
					Thread.sleep(10);
					String s = split[i];
					System.out.printf("%s ", s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
	}
}
