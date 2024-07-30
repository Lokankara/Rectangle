/**
 * 
 */
package test.java.com.test.boyarsky.zoo.birds;

/**
 * @author PPoliak
 *
 */
abstract public class Bird {
	protected static int referenceCount = 0;

	public Bird() {
		referenceCount++;
	}

	public void move() {
	}

	public void fly() {
		System.out.println("Bird is flying");
	}

	public static int getRefCount() {
		return referenceCount;
	}
}