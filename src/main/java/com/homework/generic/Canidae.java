package com.homework.generic;

import java.util.Objects;
//dog,wolf,fox = 19,23,29
abstract class Canidae extends Animal { 
	protected void sniff() {
		System.out.printf("The %.2f weight %s sniffs%n", weight, type);
	}
	public Canidae(Long age, Double weight) {
		super(age, weight, "Woof");
	}
	public Canidae(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}	
}

class Dog extends Canidae {
	public Dog(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 19;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
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
		Dog other = (Dog) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Wolf extends Canidae {
	
	public Wolf(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 23;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
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
		Wolf other = (Wolf) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Fox extends Canidae {

	public Fox(Long age, Double weight) {
		super(age, weight);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = prime + this.age.hashCode();
		hash = prime * hash + this.weight.hashCode();
		hash = prime * hash + this.voice.hashCode();
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
		return true;
	}
}
