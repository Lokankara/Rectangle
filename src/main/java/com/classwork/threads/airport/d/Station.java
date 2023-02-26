package com.classwork.threads.airport.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

class Station extends Thread {

	private static int count = 1;
	private final List<Bus> completedTransfer = new ArrayList<>();
	private final Plane plane;

	public Station(Plane plane) {
		super("Manager" + count++);
		this.plane = plane;
		this.start();
	}

	public List<Bus> getCompletedTransfer() {
		return this.completedTransfer;
	}

	public void run() {

		for (Family family : plane.getFamilyList()) {
			toTransfer(family);
		}
	}

	public void toTransfer(Family family) {
		Town destination = Town.valueOf(family.getTravelTo());
		Queue<Family> queue;
		int personCount;
		synchronized (destination) {
			queue = destination.getQueue();
			personCount = destination.getPersonInQueueCount();
			queue.add(family);
			personCount += family.getCount();
			destination.setPersonInQueueCount(personCount);
			if (personCount > 5 && personCount < 9) {
				completedTransfer.add(new Bus(destination));
				destination.setPersonInQueueCount(0);
				destination.getQueue().clear();
			} else if (personCount > 8) {
				Family forReplace = queue.poll();
				destination.setPersonInQueueCount(personCount - forReplace.getCount());
				completedTransfer.add(new Bus(destination));
				queue.clear();
				queue.add(forReplace);
				destination.setPersonInQueueCount(forReplace.getCount());
			}
		}
	}

	public Map<String, Map<Integer, Long>> getTransferMap() {
		return completedTransfer.stream().collect(Collectors.groupingBy(Bus::getDriveTo,
				Collectors.groupingBy(Bus::getPassengersCount, Collectors.counting())));
	}

	public long getTransferedPersonsCount() {
		return getCompletedTransfer().stream().collect(Collectors.summarizingInt(Bus::getPassengersCount))
				.getSum();
	}
}