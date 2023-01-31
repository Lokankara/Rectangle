package com.homework.generic;

import java.util.Objects;
//cat,tiger,lion,lynx = 13,11,17,7  
abstract class Felidae extends Animal {
	protected void purr() {
		System.out.printf("The %.2f weight %s purrs%n", weight, type);		
	}
	public Felidae(Long age, Double weight) {
		super(age, weight, "Meow");
	}
	public Felidae(Long age, Double weight, String voice) {
		super(age, weight, voice);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Felidae other = (Felidae) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Cat extends Felidae {
	public Cat(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 13;
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
		Cat other = (Cat) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Tiger extends Felidae {
	public Tiger(Long age, Double weight) {
		super(age, weight, "Argthhh");
	}
	@Override
	public int hashCode() {
		final int prime = 11;
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
		Tiger other = (Tiger) obj;
		return Objects.equals(voice, other.voice);
	}
}

class Lion extends Felidae {
	public Lion(Long age, Double weight) {
		super(age, weight, "Roar");
	}
	@Override
	public int hashCode() {
		final int prime = 17;
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
		Lion other = (Lion) obj;
		return Objects.equals(voice, other.voice);
	}
}
class Lynx extends Felidae {
	public Lynx(Long age, Double weight) {
		super(age, weight);
	}
	@Override
	public int hashCode() {
		final int prime = 7;
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
		Lynx other = (Lynx) obj;
		return Objects.equals(voice, other.voice);
	}
}
