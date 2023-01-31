package com.homework.collector;

import java.util.Objects;


class ZooWorker extends Zoo<Worker> {}
class ZooKeeper extends Zoo<Keeper> {}
class ZooVisitor extends Zoo<Visitor> {}

abstract class Zoo<T extends Person> {
}

abstract class Person {
	protected Long age;
	protected String name;

	public Person(Long age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}

class Visitor extends Person {
	private String ticket;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	void admire(Animal animal) {
		animal.say();
		ticket = "";
	};

	public Visitor(Long age, String name) {
		super(age, name);
		this.ticket = "animal";
	}

	@Override
	public int hashCode() {
		final int prime = 41;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.name.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		return Objects.equals(ticket, other.ticket);
	}
}

class Worker extends Person {
	private Double food;
	public Double getFood() {
		return food;
	}
	public void setFood(Double food) {
		this.food = food;
	}

	public void feed(Animal bigCat) {
		System.out.print("Feeding big Cat: ");
		bigCat.eat(food);
	}

	public Worker(Long age, String name) {
		super(age, name);
	}
	@Override
	public int hashCode() {
		final int prime = 37;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.name.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(food, other.food);
	}
}

class Keeper extends Person {
	public static <T extends Animal> void say(T t) {
		t.say();
	}

	public Keeper(Long age, String name) {
		super(age, name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.name.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keeper other = (Keeper) obj;
		return Objects.equals(this, other);
	}	
}

class Animal{

	public void say() {
		// TODO Auto-generated method stub
		
	}

	public void eat(Double food) {
		// TODO Auto-generated method stub
		
	}}