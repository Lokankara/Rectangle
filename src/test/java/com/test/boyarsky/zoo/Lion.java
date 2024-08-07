package com.test.boyarsky.zoo;

class Lion extends BigCat {

    private int age;

    public Lion(int age, String name) {
        super(age, name);
    }

    public void roar() {
        System.out.printf("The %d year old lion says: Roar!%n", getAge());
    }
}
