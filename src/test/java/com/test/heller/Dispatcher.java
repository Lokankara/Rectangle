/**
 * 
 */
package com.test.heller;

/**
 * @author PPoliak
 *
 */
public class Dispatcher {

	public Dispatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hawk h = new Hawk();
		Penguin p = new Penguin();
		Strauss s = new Strauss();
		Bird[] birds = new Bird[3];
		birds[0] = h;
		birds[1] = s;
		birds[2] = p;
		for (Bird bird : birds) {
			bird.move();
		}
	}
}