/**
 *
 */
package com.test.boyarsky.zoo;

import com.test.heller.Animal;

/**
 * @author PPoliak
 *
 */
public class ZooKeeper {

    public ZooKeeper() {
    }

    public static void main(String[] args) {
        Animal animal = new Gorilla();
        System.out.println(animal.getName());
    }
}
