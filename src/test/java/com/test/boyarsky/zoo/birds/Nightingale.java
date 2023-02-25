package test.java.com.test.boyarsky.zoo.birds;

public class Nightingale extends Bird {
	public Nightingale() {
		referenceCount++;
	}

	@Override
	public String toString() {
		return  getClass() + "#" + hashCode();
		}	
}
