package com.classwork.threads.io.atomic;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantSync {
	
	private static final AtomicBoolean locked = new AtomicBoolean(false);
	private final ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
	private final Lock lock = new ReentrantLock();
	
	private final Lock readLock = reentrantLock.readLock();
	private final Lock writeLock = reentrantLock.writeLock();

	
//    static Result result = new Result();
    public static void main(String[] args)  {
//    	ReadWrapper reader = new ReadWrapper(new File("TODO.md"));
//    	reader.fileRead();
//    	System.out.println(reader.toString());
    }
    
}

//    	System.out.println("Main thread started (" + Thread.currentThread().getId() + ")");
//
//        List<FileWrapper> listFileNames = new ArrayList<>();
//        listFileNames.add(new FileWrapper("File1"));
//        listFileNames.add(new FileWrapper("File2"));
//        listFileNames.add(new FileWrapper("File3"));
//
//        Controller.treadsStarter(listFileNames);
//
//        System.out.println(result);
//        System.out.println("Main thread finished (" + Thread.currentThread().getId() + ")");
//    }
//}
//
//
//class Controller {
//    static void treadsStarter(List<FileWrapper> fileWrapperList) {
//
//        List<Thread> threads = new ArrayList<>();
//        for (FileWrapper file : fileWrapperList) {
//            Thread temp =  new Thread(new NumberFinder(file));
//            threads.add(temp);
//            temp.start();
//        }
//
//        for (Thread thread : threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//class Result {
//    double result;
//
//    synchronized void add(double d) {
//        result += d;
//    }
//
//    @Override
//    public String toString() {
//        return "Result = " + this.result;
//    }
//}
//
//
//class NumberFinder implements Runnable {
//    private final FileWrapper file;
//
//
//    public FileWrapper getFile() {
//        return this.file;
//    }
//
//    NumberFinder(FileWrapper file) {
//        this.file = file;
//    }
//
//    @Override
//    public void run() {
//        file.sumOfNumbers();
//    }
//}
//
//
//class FileWrapper {
//    private final String fileName;
//
//    public String getFileName() {
//        return this.fileName;
//    }
//
//    FileWrapper(String fileName) {
//        this.fileName = fileName;
//    }s
//
//    void sumOfNumbers() {
//        long id = Thread.currentThread().getId();
//        System.out.println("Start tread (Id " + id + ")");
//        Pattern pattern = Pattern.compile("\\d");
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                for (String word : line.split(" ")) {
//                    Matcher matcher = pattern.matcher(word);
//                    if (matcher.find()) {
//                        Dispatcher.result.add(Double.parseDouble(word));
//                    }
//                }
//            }
//            System.out.println("Thread number: " + id + " finished.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}