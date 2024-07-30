/**
 * 
 */
package test.java.com.test.boyarsky.zoo.birds;

/**
 * @author PPoliak
 *
 */
public class Pelican extends Bird {

	public Pelican() {
		super();
		referenceCount++;
	}

	public void fly() {
		System.out.println("Pelican is flying");
	}

	public void move() {
		System.out.println("Fly");
	}

	@Override
	public String toString() {
		return getClass() + "#" + hashCode();
	}
}
