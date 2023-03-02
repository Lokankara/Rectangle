//package com.exam.thread;
//
//import static com.homework.threads.airport.Airport.AMOUNT;
//import static com.homework.threads.airport.Airport.PLANES;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CountDownLatch;
//import java.util.stream.IntStream;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.atomic.DoubleAdder;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class AeroFly {
//	public static void main(String[] args) {
//		List<Plane> aircraft = Service.buildPlanes(PLANES, AMOUNT);
//		System.out.println(aircraft);
//        
//        
////	List<GateRunner> runners = 
////			IntStream.range(1, aircraft.size() + 1).mapToObj(id -> 
////				new GateRunner(id, aircraft)).toList();
////
//
//	Map<String, List<Bus>> buses = new ConcurrentHashMap<>();
//
//		 int poolSize = aircraft.size();
//		private static final DoubleAdder totalSum = new DoubleAdder();
//		 CountDownLatch latch = new CountDownLatch(poolSize);
//
//			List<Wrapper> wrappers = 
//					Arrays.stream(files).map(file -> 
//						new Wrapper(path + file, latch, totalSum)).toList();
//
//			List<Runner> runners = 
//					IntStream.range(1, poolSize + 1).mapToObj(id -> 
//						new Runner(id, wrappers)).toList();
//
//			long start = System.nanoTime();
//			runners.forEach(runner -> runner.thread.start());
//			long end = System.nanoTime();
//
//			System.out.printf("Execution time: %s microseconds%n", (end - start) / 1000);
//
//	}
//}
//
//class Ticket {
//	int place;
//	Lock lock = new ReentrantLock();
//	boolean isBought = false;
//	int cashier;
//
//	public Ticket(int place) {
//		this.place = place;
//	}
//
//	void buy(int id) {
//
//		if (!isBought) {
//			isBought = true;
//			cashier = id;
//			System.out.println(this);
//		}
//	}
//
//	@Override
//	public String toString() {
//		if(isBought) {
//			return String.format("Ticket for seat#%d was bought by the Cashier#%d", place, cashier);			
//		}
//		else {
//			throw new RuntimeException();
//		}
//	}
//}
