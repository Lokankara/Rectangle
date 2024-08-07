/**
 *
 */
package com.test.boyarsky.zoo;

import com.test.heller.Animal;

/**
 * @author PPoliak
 */
public class Tiger extends Animal {
    public Tiger(int age, String name) {
        super(age, name);
    }

    private void roar() {
        System.out.println("The " + getAge() + " year old tiger says: Argthhh!");
    }
}
