package test.java.com.test.raposa;

import java.util.List;
import java.util.Vector;

//Assessment Tests
public class Raposa {

    public static void main(String[] args) {
        //Assessment Test#4
        byte x = 23, y = 4;
        int z = 23 % 4;
        // TODO#4. What is the result of the following code?
        System.out.println(z);

        // TODO#6 which of the following statements are valid method Alerts to print ?
        PrintStrings.print();
        PrintStrings.print("abc");
//        PrintStrings.print('a', 'b', 'c');
        PrintStrings.print("a", "b", "c");
//        PrintStrings.print(new java.util.Date());

        // TODO#8 which of the following statements are valid method Alerts to print ?
        Integer i = 5;
        switch (i) {
            case 1:
                System.out.print(1);
                break;
            case 3:
                System.out.print(3);
            case 5:
                System.out.print(5);
            case 7:
                System.out.print(7);
                break;
            default:
                System.out.print("default");
        }
        // TODO 1#19 D. Compiler error on line 25
        System.out.println("D. Compiler error on line 25");
        List<Number> data = new Vector<Number>();
        data.add(10);
//        data.add("4.5F");
        data.add(new Double(56.7));
        for (Number number : data) {
            System.out.println(number);
        }

        // TODO 1#20 D. Compiler error on line 25
        System.out.println("// TODO 1#20 a string 123");
        Box<String> one = new Box<String>("a string");
        Box<Integer> two = new Box<Integer>(123);
        System.out.println(one.getValue());
        System.out.println(two.getValue());

//        DecimalFormat df = new DecimalFormat("#,000.0#");
        double pi = 3.141592653;
//        System.out.println(df.format(pi));
//    A. 3.141592653
//    B. 0,003.14
//    C. ,003.1
//    D. 003.14
//    E. 00.04
        // TODO 1# TV a = new TV("Philips", "42PFL5603D");
        System.out.println("TV a = new TV(\"Philips\");");
        TV a = new TV("Philips", "42PFL5603D");
        TV b = new TV("Philips", "42PFL5603D");
        if (a.equals(b)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
//    Suppose you need to write data that consists of char values and String objects to a file
//    that maintains the format of the original data. The data needs to be buffered to improve
//    performance. Which two java.io classes can be chained together to best achieve this
//    result?
//    A. FileWriter
//    B. FileOutputStream
//    C. BufferedOutputStream
//    D. BufferedWriter
//    E. PrintWriter
//    F. PipedOutputStream
    }
}
