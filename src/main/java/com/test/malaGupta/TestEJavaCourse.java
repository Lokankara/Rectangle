package com.test.malaGupta;
class Course {
 int enrollments;
}
public class TestEJavaCourse {
 public static void main(String args[]) {
 Course c1 = new Course();
 Course c2 = new Course();
 c1.enrollments = 100;
 c2.enrollments = 200;
 System.out.println("#86: " + c1.enrollments + c2.enrollments);

 String ejgStr[] = new String[][]{{null},
	 new String[]{"a","b","c"},
	 {new String()}}[0] ;
	 String ejgStr1[] = null;
	 String ejgStr2[] = {null};

	 System.out.print("#87: ");
	 System.out.println(ejgStr[0]);
	 System.out.println(ejgStr2[0]);
//	 System.out.println(ejgStr1[0]);
 }
}