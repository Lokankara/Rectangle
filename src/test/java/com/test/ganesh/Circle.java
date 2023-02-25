package test.java.com.test.ganesh;

class Circle extends Shape {
	private int xPos, yPos, radius;

	public void area() {
		System.out.println("area:" + 3.14 * radius * radius);
	}

	public Circle() {
		xPos = 20;
		yPos = 20;
		radius = 10;
	}

	public String toString() {
		return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
	}

	public static void main(String[] s) {
		System.out.println("Ch3, #1-3");
		System.out.println(new Circle());
		Circle circle = new Circle();
		circle.area();

	}

}

class Shape {
}

class Circles {
	public void getArea() {
		Circle circle = new Circle();
		circle.area();
	}
}

class Canvas {
	void getArea() {
		Circle circle = new Circle();
		circle.area();
	}
}