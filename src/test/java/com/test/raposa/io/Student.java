package com.test.raposa.io;

 public class Student implements java.io.Serializable {
 private String name;

 public static void main(String [] args) {
	 Student s = new Senior();
 }
 }

 class Senior extends Student {}

 class Junior extends Student {}