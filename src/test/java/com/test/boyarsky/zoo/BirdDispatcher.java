/**
 * 
 */
package com.test.boyarsky.zoo;

import com.test.boyarsky.zoo.birds.Bird;
import com.test.boyarsky.zoo.birds.Hawk;
import com.test.boyarsky.zoo.birds.Nightingale;
import com.test.boyarsky.zoo.birds.Pelican;
import com.test.boyarsky.zoo.birds.Penguin;
import com.test.boyarsky.zoo.birds.Strauss;

/**
 * @author PPoliak
 *
 */
public class BirdDispatcher implements Dispatcher<Bird> {

	private final static Bird[] birds = new Bird[10];

	public BirdDispatcher() {
	}

	public static void main(String[] args) {
		Beetle beetle = new Beetle();
	
		Nightingale florence = new Nightingale();
		System.out.println("Before: " + Bird.getRefCount());
		florence.fly();

		Hawk h = new Hawk();
		Pelican pelican = new Pelican();
		Penguin p = new Penguin();
		Strauss s = new Strauss();
		birds[0] = h;
		birds[1] = s;
		birds[2] = p;
		birds[3] = florence;
		birds[3] = pelican;
		for (Bird bird : birds) {
			if(bird !=null) {
				System.out.println(bird);
				bird.move();
			}
		}
		System.out.println("After: " + Bird.getRefCount());
	}
}