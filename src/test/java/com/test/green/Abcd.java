package test.java.com.test.green;

abstract class BaseA{
    abstract public void function();
    public void another(){
        System.out.println("Another method");
    }
}
public class Abcd extends BaseA{
    public static void main(String argv[]){
        Abcd a = new Abcd();
        a.method();
        System.out.println(" To write optimised code for performance in a language such as C/C++");

    }
    public void function(){
        System.out.println("#4: The compiler will complain that the Base class is not declared as abstract");
    }
    public void method(){
        function();
    }




}
