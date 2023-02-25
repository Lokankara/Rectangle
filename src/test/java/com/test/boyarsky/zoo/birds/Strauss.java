package test.java.com.test.boyarsky.zoo.birds;

public class Strauss extends Bird {

	public Strauss() {
		super();
		referenceCount++;
	}

	public void move() {
		System.out.println("Run");
	}

	@Override
	public String toString() {
		return getClass() + "#" + hashCode();
	}
}
