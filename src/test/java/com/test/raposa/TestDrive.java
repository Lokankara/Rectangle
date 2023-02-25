package test.java.com.test.raposa;

public class TestDrive{
	public static void go(Car car){
		car.velocity +=10;
	}
	public static void main(String [] args) {
		System.out.print("Ch#1 Q#9");
		Car porsche = new Car();
		go(porsche);
		
		Car stolen = porsche;
		go(stolen);
		go(porsche);
		
		System.out.print(porsche.velocity);
	}
}
class Car{
	public int velocity = 10;
}