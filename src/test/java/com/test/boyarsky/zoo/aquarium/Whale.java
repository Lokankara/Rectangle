/**
 * 
 */
package com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public abstract class Whale { // implements CanSwim
	protected abstract void sing();

	protected abstract void dive(int depth);

	public void dive() {
	}; // remove abstract

	public static void main(String[] args) {
		Whale orca = new Orca();
		Whale humpback = new HumpbackWhale();
		orca.dive(20);
		humpback.sing();
	}

}

class Orca extends Whale {
	public void dive(int depth) {
		System.out.println(String.format("Orca diving %d miles under the water", depth));
	}

	@Override
	protected void sing() {
		System.out.println("Orca singing");
	}
}

class HumpbackWhale extends Whale {
	protected void sing() {
		System.out.println("Humpback whale is singing");
	}

	@Override
	protected void dive(int depth) {
		System.out.println(String.format("Humpback diving %d miles under the water", depth));
	}
}