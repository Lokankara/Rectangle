package com.exam.thread;

import java.util.ArrayList;
import java.util.List;

class Plane implements Runnable {
    private final int id;
    private final List<Family> families;

    public Plane(int id, List<Family> families) {
		super();
		this.id = id;
		this.families = families;
	}

	public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\u001B[36m -seat aircraft#%s who arrive at the gate\u001B[m".formatted(id);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public List<Family> getFamilies() {
		return families;
	}
}

class Bus extends Transport {
    private final int places;
    private final String driveTo;

    public Bus(String city, List<Family> families, int places) {
        super(new ArrayList<>(families));
        this.driveTo = city;
        this.places = places;
    }

    public String getDriveTo() {
        return driveTo;
    }

    @Override
    public String toString() {
        return "The %s-bus with %s goes to %s".formatted(places, getFamilies(), driveTo);
    }

	@Override
	public void run() {
	}
}

abstract class Transport implements Runnable {

    protected Thread thread;
    private final List<Family> families;

    protected Transport(List<Family> families) {
        this.families = families;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public int getMembers() {
        return families.stream().mapToInt(Family::getCount).sum();
    }
}
