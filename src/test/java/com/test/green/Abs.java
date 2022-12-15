package com.test.green;

abstract class Base{
    abstract public void function();
    public void another(){
        System.out.println("Another method");
    }
}
public class Abs extends Base{
    public static void main(String argv[]){
        Abs a = new Abs();
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
