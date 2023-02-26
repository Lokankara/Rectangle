package com.classwork.threads.airport.d;

import java.util.PriorityQueue;
import java.util.Queue;

enum Town {
	KALUSH, KOSIV, GALYCH, KOLOMIYA;

	private final Queue<Family> queue;
	private int personInQueueCount;

	Town() {
		this.queue = new PriorityQueue<>();
	}

	public Queue<Family> getQueue() {
		return queue;
	}

	public int getPersonInQueueCount() {
		return personInQueueCount;
	}

	public void setPersonInQueueCount(int personInQueueCount) {
		this.personInQueueCount = personInQueueCount;
	}
}