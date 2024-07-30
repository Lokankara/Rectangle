/**
 * 
 */
package test.java.com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
interface CanHop {
}

public class Frog implements CanHop {
	/**
	 * 
	 */
	public Frog() {
		// TODO Auto-generated constructor stub
	}

	/**
	 */
	public static void main(String[] args) {
		Frog frog = new TurtleFrog();

		System.out.println(frog);

	}
}

class BrazilianHornedFrog extends Frog {
}