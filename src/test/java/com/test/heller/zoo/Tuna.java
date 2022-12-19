/**
 * 
 */
package com.test.heller.zoo;

import com.test.heller.zoo.ocean.Fish;

/**
 * @author PPoliak
 *
 */
public class Tuna extends Fish {
//		void swim() { }
	public void swim() {
	}

	public Tuna() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Tuna tuna = new Tuna();
		System.out.println("Before: " + tuna);
		(new Tuna()).size = 12;
	}

	@Override
	public String toString() {
		return "Tuna [size=" + size + "]";
	}	
}
