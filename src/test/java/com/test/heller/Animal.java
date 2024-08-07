package com.test.heller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

interface Washer {
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Animal {
    private final int age;
    private final String name;
    private final double weight;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
        this.weight = 1;
    }

    public Animal(double weight) {
        this.age = 0;
        this.name = "Animal";
        this.weight = weight;
    }
}

class Mammal extends Animal {
    public Mammal() {
        super(0, "Mammal");
    }

    public Mammal(int age, String name) {
        super(age, name);
    }
}

class Dog extends Mammal {
}

class Cat extends Mammal implements Washer {
}

class Raccoon extends Mammal implements Washer {
}

class Swamp extends Mammal {
}
