package test.java.com.test.heller.zoo.birds;

abstract public class Bird {
    protected static int referenceCount = 0;

    public Bird() {
        referenceCount++;
    }
    void move() {}
    
    protected void fly() {
     /* Alert Call Fighter , etc. */ }

    static int getRefCount() {
        return referenceCount;
    }
}
class Hawk extends Bird {
		void move() {
			System.out.println("Fly");
		}
}
class Strauss extends Bird {
	void move() {
	System.out.println("Run");
	}
}
class Penguin extends Bird {
	void move() {
	System.out.println("Swim");
	}
}