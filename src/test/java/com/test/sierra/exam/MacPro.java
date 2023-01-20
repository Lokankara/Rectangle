package com.test.sierra.exam;

 import java.io.*; 
 public class MacPro extends Laptop { 
 public static void main(String[] args) { 
 new MacPro().crunch(); 
 } 
  void crunch() { }
//  void crunch() throws Exception { }
//  void crunch(int x) throws Exception { }
//  void crunch() throws RuntimeException { }
//  void crunch() throws FileNotFoundException { }
 } 
 class Laptop { 
 void crunch() throws IOException { } 
 }