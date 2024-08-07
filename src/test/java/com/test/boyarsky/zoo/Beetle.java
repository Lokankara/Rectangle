/**
 *
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 */
public class Beetle extends Insect {
    public int getNumberOfLegs() {
        return 6;
    }

    public Beetle() {
    }

    @Override
    public int getNumberOfSections() {
        return 0;
    }
}
