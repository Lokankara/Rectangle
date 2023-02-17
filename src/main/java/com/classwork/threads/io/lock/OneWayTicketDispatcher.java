package com.classwork.threads.io.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OneWayTicketDispatcher {

	public static void main(String[] args) throws InterruptedException {
		Ticket[] tickets = new Ticket[100];
		for (int i = 0; i < 100; i++) {
			tickets[i] = new Ticket(i + 1);
		}
		Cashier[] cashiers = { new Cashier(200, tickets), new Cashier(300, tickets)};

		for (Cashier cashier : cashiers) {
			cashier.start();
		}
	}
}

class Ticket {
	int place;
	Lock lock = new ReentrantLock();
	boolean isBought = false;
	int cashier;

	public Ticket(int place) {
		this.place = place;
	}

	void buy(int id) {

		if (!isBought) {
			isBought = true;
			cashier = id;
			System.out.println(this);
		}
	}

	@Override
	public String toString() {
		if(isBought) {
			return String.format("Ticket for seat#%d was bought by the Cashier#%d", place, cashier);			
		}
		else {
			throw new RuntimeException();
		}
	}
}

class Cashier extends Thread {
	int id;
	int num;
	int count;
	Ticket[] tickets;

	public Cashier(int id, Ticket[] tickets) {
		super();
		this.id = id;
		this.tickets = tickets;
	}

	public void run() {
		for (Ticket ticket : tickets) {
			try {
				while (!ticket.lock.tryLock()) {
					num++;
				}
				ticket.buy(id);
			} finally {
				ticket.lock.unlock();
			}
		}
	}
//	synchronized void buy() {
//		for (Ticket ticket : tickets) {
//			if (!ticket.isBought) {
//				ticket.isBought = true;
//				System.out.printf("Cashier #%d is bought ticket %s%n", id, ticket);
//			}
//		}
//	}
}
