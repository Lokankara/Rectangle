package com.classwork;

class Factory {
	public static void main(String[] args) {
//		DogFactory factory = new DogFactory();
//		DogFactory pitbullfactory = new PitbullFactory();
//		Dog dog = factory.create();
//		Dog pitbull = pitbullfactory.create();
//		Pitbull castPitbull = (Pitbull) pitbullfactory.create();
	}
}

interface Animal<T>{}

class Dog {
}

class Pitbull extends Dog {
}

class TigerPitbull extends Pitbull {
}

class DogFactory {
	Dog create() {
		return new Dog();
	}
}

class TigerPitbullFactory extends DogFactory {
	TigerPitbull create() {
		return new TigerPitbull();
	}
}

class PitbullFactory extends DogFactory {
//	Dog create() {return new Pitbull();}
	Pitbull create() {
		return new Pitbull();
	}
}