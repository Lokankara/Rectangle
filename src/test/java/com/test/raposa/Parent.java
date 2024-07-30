package test.java.com.test.raposa;

public class Parent {
	
	protected void sayHi() {
		  System.out.print("Hi");
		 }
	
	public float computePay(double d) {
		System.out.println("In Parent");
		return 0.0F;
	}

	{
		System.out.print("1");
	}

	public Parent(String greeting) {
		System.out.print("2");
	}

	public void print(int i) {
		System.out.print("Parent");
	}

	public static void main(String[] args) {
		Parent parent = new Child();
		parent.sayHi();
		Child child = new Child();
		child.print(10);
//		 child.print(3.14);
		new Child().computePay(0.0);
	}
}

class Child extends Parent {

	public void sayHi() {
		  System.out.print("Hello");
		 }	
	
	public float computePay(double d) {
		System.out.println("In Child ");
		return 0.0F;
	}

	public Child(String greeting) {
		super(greeting);
	}

	Child() {
		super("child");
	}

	static {
		System.out.print("3");
	}
	{
		System.out.print("4");
	}

	public void print(int i) {
		System.out.print("Child");
	}
}
