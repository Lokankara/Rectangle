package com.classwork.threads.io.atomic;

public class OneWayTicketDispatcher {

	public static void main(String[] args) throws InterruptedException {
		Ticket[] tickets = { new Ticket(10), new Ticket(11), new Ticket(12) };
		Cashier[] cashiers = { new Cashier(100, tickets), new Cashier(101, tickets), new Cashier(102, tickets) };

		for (Cashier cashier : cashiers) {
			cashier.start();
		}
	}
}

class Ticket {
	int place;
	boolean isBought = false;

	public Ticket(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return String.format("Ticket [place=%d, isBought=%s]", place, isBought);
	}
}

class Cashier extends Thread {
	int id;
	Ticket[] tickets;

	public Cashier(int id, Ticket[] tickets) {
		super();
		this.id = id;
		this.tickets = tickets;
	}

	public void run() {
		buy();
	}

	synchronized void buy() {
		for (Ticket ticket : tickets) {
			if (!ticket.isBought) {
				ticket.isBought = true;
				System.out.printf("Cashier #%d is bought ticket %s%n", id, ticket);
			}
		}
	}
}

//
//class Controller {
//
//	static void syncStarter(List<Thread> threads) {
//
//		long start = System.nanoTime();
//
//		for (int i = 0; i < threads.size(); i++) {
//			thre ads.get(i).start();
//		}
//		long end = System.nanoTime();
//
//		System.err.printf("Locking using atomic concurrent mode, read time: %d microseconds%n", (end - start) / 1_000);
//	}
//}
//
//class SyncAdder {
//	private double sum;
//
//	synchronized void add(double d) {
//		sum += d;
//	}
//
//	public synchronized double get() {
//		return sum;
//	}
//}
//
//class SyncRunner implements Runnable {
//
//	private final SyncAdder sum;
//	private final SyncAccumulator accumulator;
//
//	SyncRunner(SyncAccumulator file) {
//		this.accumulator = file;
//		this.sum = new SyncAdder();
////        new Thread(this).start();
//	}
//
//	@Override
//	public void run() {
//		accumulator.accumulate(sum);
//	}
//}
//
//class SyncAccumulator {
//	private final String patternNumber = "\\d[0-9]{1,13}([,\\.][0-9]{1,5})?";
//
//	private final File file;
//
//	SyncAccumulator(String fileName) {
//		this.file = (new File(fileName));
//	}
//
//	void accumulate(SyncAdder sum) {
//		Matcher matcher;
//		try (Scanner scanner = new Scanner(file)) {
//			while (scanner.hasNext()) {
//				matcher = Pattern.compile(patternNumber).matcher(scanner.next());
//				if (matcher.find()) {
//					sum.add(Double.parseDouble(matcher.group().replace(",", ".")));
//				}
//			}
//		} catch (IOException | NumberFormatException e) {
//			System.err.println(e);
//		} finally {
//			System.err.printf("File was read by thread #%s, the total sum of number is %s %n",
//					Thread.currentThread().getId(), sum.get());
//		}
//	}
//}
