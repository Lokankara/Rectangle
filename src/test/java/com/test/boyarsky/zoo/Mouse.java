/**
 *
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 */
public class Mouse extends Rodent {
    protected int weight = 8;


    public void printMouseDetails() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.printMouseDetails();
    }
}

class Rodent {
    protected Integer chew() throws Exception {
        System.out.println("Rodent is chewing");
        return 1;
    }
}

class Beaver extends Rodent {
    public Integer chew() throws RuntimeException {
        System.out.println("Beaver is chewing on wood");
        return 2;
    }
}
