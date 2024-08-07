/**
 *
 */
package com.test.boyarsky.zoo;

import com.test.heller.Animal;

/**
 * @author PPoliak
 */
public class Gorilla extends Animal {
    public String getName() { // DOES NOT COMPILE
        return "Gorilla";
    }

    public Gorilla() {
        super(100);
    }
}
