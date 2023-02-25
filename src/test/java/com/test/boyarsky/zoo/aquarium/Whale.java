/**
 * 
 */
package test.java.com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public abstract class Whale { // implements CanSwim
	public void dive() {
	}; // remove abstract

	public static void main(String[] args) {
		Whale whale = new Orca();
		whale.dive();
	}
}

class Orca extends Whale {
	public void dive(int depth) {
		System.out.println("Orca diving");
	}
}