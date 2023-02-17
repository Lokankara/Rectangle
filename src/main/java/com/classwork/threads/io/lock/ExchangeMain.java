package com.classwork.threads.io.lock;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangeMain {
	public static void main(String[] args) throws InterruptedException {
		ItemAction action = new ItemAction();
		Item o1 = new Item(5.0, "Tie");
		Item o2 = new Item(7.0, "Gloves");
		System.out.println(o1 + "\n" + o2);

		new Thread(() -> action.doActionPrice(o1, 0.9f)).start();
		new Thread(() -> action.doActionDescription(o2, " with discount")).start();

		TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);

		System.out.println(o1 + "\n" + o2);
	}
}

class Item {
	private double price;
	private String description;

	public Item(double price, String description) {
		this.price = price;
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("%s, price=%4.2f, description=%s", Thread.currentThread(), price, description);
	}
}

class ItemAction {

	private static Exchanger<Item> exchanger = new Exchanger<>();

	public void doActionPrice(Item item, float discount) {
		item.setPrice(item.getPrice() * discount);
		try {
			item = exchanger.exchange(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		item.setPrice(item.getPrice() * discount);
	}

	public void doActionDescription(Item item, String addDescription) {

		item.setDescription(item.getDescription() + addDescription);
		try {
			item = exchanger.exchange(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		item.setDescription(item.getDescription() + addDescription);
	}
}