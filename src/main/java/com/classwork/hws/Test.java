package com.classwork.hws;

public class Test { 
 int state = 0; 
 Test(int s) { state = s; }
 
   @Override
public String toString() {
	return "Test [state=" + state + "]";
}

public static void main(String... hi) { 
	   Test b1 = new Test(1); 
	   Test b2 = new Test(2); 
//   System.out.println(b1.go(b1) + " " + b2.go(b2)); 
   System.out.println(b1.go(b2) + " " + b2.go(b1));
   } 
   int go(Test b) { 
	   System.out.println(b);
	   
  if(this.state == 2) { 
  b.state = 5; 
 go(this); 
 } 
 return ++this.state; 
 } }