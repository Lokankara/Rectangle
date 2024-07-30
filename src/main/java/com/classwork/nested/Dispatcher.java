package com.classwork.nested;

/**
 * @author PPoliak
 */
public class Dispatcher {

    public static void main(String[] args) {

        Outer.Inner inner = new Outer().new Inner();
        inner.display();
        Outer outer = new Outer();
//		outer.m().new InnerLocale();
        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
        innerStatic.display();
    }
}

//top-level class
class Outer {
    //	Inner inner; //compose
    private int x = 10;
    static int y = 50;

    void m() {
        final int a = 50; //effectively final a++
        class InnerLocale {
            void display() {
                System.out.println("OuterLocale: y= " + Outer.this.y);
                System.out.println("InnerLocale: a= " + a);
            }
        }
    }

    /// nested
    static class InnerStatic { // nested
        void display() {
            System.out.println("nested static: y= " + y);
        }
    }

    ;

    protected class Inner { // regular
        private int x = 20;

        void display() {
            System.out.println("outer: x= " + Outer.this.x);
            System.out.println("inner: x= " + x);
        }
    }
}
