package com.test.heller;

import java.io.StreamCorruptedException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestModule {
    public static void main(String[] args) {

        try {

            String s ="http://localhost:8080";
            URL u = new URL(s);

//            Object o = in.readObject();
            System.out.println("Success");
            }
        catch (MalformedURLException e) {
            System.out.println("Bad URL");
//            }
//        catch (StreamCorruptedException e) {
            System.out.println("Bad file contents");
            }
        catch (Exception e) {
            System.out.println("General exception");
            }
        finally {
            System.out.println("Doing finally part");
            }
        System.out.println("Carrying on");

        
//        while (int i<7) {
//            i++;
//            System.out.println("i is " + i);
//        }
//
//        int a = 3;
//        while (a) {
//            System.out.println("i is " + a);
//        }

//        int j = 0;
//        for (int k=0, j+k != 10; j++,k++) {
//            System.out.println("j=" + j + ", k=" + k);
//        }
//
//        int b=0;
//        do {
//            System.out.println("j=" + b++);
//            if (b==3)
//                continue loop;
//        } while (b<10);
    }
}
