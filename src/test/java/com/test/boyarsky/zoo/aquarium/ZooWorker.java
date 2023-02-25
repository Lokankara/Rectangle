/**
 * 
 */
package test.java.com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public class ZooWorker {
	public static void feed(Reptile reptile) {
		System.out.println("Feeding reptile " + reptile.getName());
	}

	public static void main(String[] args) {
		feed(new Alligator());
		feed(new Crocodile());
		feed(new Reptile());
	}
}