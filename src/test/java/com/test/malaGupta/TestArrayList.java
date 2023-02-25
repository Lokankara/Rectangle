package test.java.com.test.malaGupta;

import java.util.*;
class Person {}
class Emp extends Person {}
class TestArrayList {
 public static void main(String[] args) {
	 System.out.print("#88 : ");

	 ArrayList<Object> list = new ArrayList<Object>();

 list.add(new String("1234")); //LINE1
 list.add(new Person()); //LINE2
 list.add(new Emp()); //LINE3
 list.add(new String[]{"abcd", "xyz"});//LINE4
 System.out.println(list.toString());
 }
 
}