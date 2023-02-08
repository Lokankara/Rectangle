package com.test.horstmann.io.atomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBank {

	private Lock bankLock;
	private Condition sufficientFunds;
	private final double[] accounts;
	private volatile boolean done;

	public boolean isDone() {
		return done;
	}

	public void setDone() {
		done = true;
	}

	public static AtomicLong nextNumber = new AtomicLong();
	long id = nextNumber.incrementAndGet();
	LongAdder a = new LongAdder();
	LongAccumulator acc = new LongAccumulator(Long::sum, 0);

//	largest.updateAndGet(x -> Math.max(x, observed)); 

	public ReentrantLockBank(int n, double initialBalance) {
		bankLock = new ReentrantLock();
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
		sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, int amount)

	{
		bankLock.lock();
		try {
			System.out.print(Thread.currentThread());

			while (accounts[from] < amount) {
				sufficientFunds.await();
			}

			System.out.printf("%s", Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

			sufficientFunds.signalAll();

			getTotalBalance();

		} catch (InterruptedException e) {
			System.err.println(e);
		} finally {
			bankLock.unlock();
		}
	}

	private double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;

			for (double a : accounts) {
				sum += a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}

	public int size() {
		return accounts.length;
	}
}