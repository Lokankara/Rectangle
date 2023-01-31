package com.homework.generic;

import java.util.Objects;

interface Mammal {abstract void say();}

abstract class Animal implements Mammal {
	protected final String type = this.getClass().getSimpleName();
	protected Long age;
	protected Double weight;
	protected String voice;
	protected void eat(Double food) {
		System.out.printf("The %.2f weight %s was fed%n", weight += food, type);
	}
	@Override
	public void say() {
		System.out.printf("The %d year-old %s says '%s'%n", age, type, voice);
	}
	public Animal(Long age, Double weight, String voice) {
		super();
		this.age = age;
		this.weight = weight;
		this.voice = voice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, weight, voice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(voice, other.voice)
				&& Objects.equals(age, other.age);
//				&& Objects.equals(weight, other.weight);	
	}
}