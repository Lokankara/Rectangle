/**
 *
 */
package com.test.boyarsky.zoo;

import com.test.heller.Animal;

/**
 * @author PPoliak
 */
public abstract class BigCat extends Animal {

    public BigCat(int age, String name) {
        super(age, name);
    }

    public abstract void roar();
}
