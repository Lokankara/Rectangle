package com.homework.generic;
import java.util.Objects;
// hamster, beaver,chipmunk : 101,103,107
abstract class Rodent extends Animal {
	protected void chew() {
		System.out.printf("The %.2f weight %s chews%n", weight, type);
	}
	public Rodent(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}
	public Rodent(Long age, Double weight) {
		super(age, weight, "Squeak");
	}		
}

class Hamster extends Rodent {
	public Hamster(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 101;
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
		Hamster other = (Hamster) obj;
		return Objects.equals(voice, other.voice);
	}	
}

class Beaver extends Rodent {
	public Beaver(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 103;
		int hash = 1;
		hash += prime * hash;
		hash += prime * this.age.hashCode();
		hash += prime * this.weight.hashCode();
		hash += prime * this.voice.hashCode();
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
		Beaver other = (Beaver) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Chipmunk extends Rodent {
	public Chipmunk(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 107;
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
		Chipmunk other = (Chipmunk) obj;
		return Objects.equals(voice, other.voice);
	}
}