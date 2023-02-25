package test.java.com.test.heller;

public class A
{
    static int x;
    public static void main(String[] args) {
        A that1 = new A();
        A that2 = new A();
//        that1.x = 5;
//        that2.x = 1000;
        x = -1;
        System.out.println(x);
    }
    void action(){};
}
class B extends A 
{

	@Override
	protected void action() {
		// TODO Auto-generated method stub
		super.action();
	}
	
}