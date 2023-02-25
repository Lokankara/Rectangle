package test.java.com.test.boyarsky.zoo.birds;

public interface CanFly {

	void fly();
}

interface HasWings {
	public abstract Object getWindSpan();
}

abstract class Falcon implements CanFly, HasWings {

}
