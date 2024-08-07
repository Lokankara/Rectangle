/**
 * 
 */
package com.test.boyarsky;

/**
 * @author PPoliak
 *
 */
public class Review {

	/**
	 * 
	 */
	public Review() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A$B = 0;
		int _hi = 0;
		int Public = 0;
//   int 1980_s = 0; 

		short numPets = 5;
		String name = "Scruffy";
		name.length();
//		int numGrains = 5.6;
//		numPets.length();
//		numGrains.length();
	}
}

class Snake {
	String result = "done";

	public void shed(boolean time) {
		if (time) {
		}
		System.out.println(result);
	}
}
//F. None of these can make the code compile.
//44 Chapter 1 ■ Java Building Blocks
//c01.indd 1½ 4/2014 Page 44
//6. Given the following classes, what is the maximum number of imports that can be removed 
//and have the code still compile?
//package aquarium; public class Water { }
//package aquarium;
//import java.lang.*;
//import java.lang.System;
//import aquarium.Water;
//import aquarium.*;
//public class Tank {
// public void print(Water water) {
// System.out.println(water); } }
//A. 0
//B. 1
//C. 2
//D. 3
//E. 4
//F. Does not compile.
//7. Given the following classes, which of the following snippets can be inserted in place of 
//INSERT IMPORTS HERE and have the code compile? (Choose all that apply)
//package aquarium;
//public class Water {
// boolean salty = false;
//}
//package aquarium.jellies;
//public class Water {
// boolean salty = true;
//}
//package employee;
// INSERT IMPORTS HERE
//public class WaterFiller {
// Water water;
//}
//A. import aquarium.*;
//B. import aquarium.Water;
//import aquarium.jellies.*;
//C. import aquarium.*;
//import aquarium.jellies.Water;
//Review Questions 45
//c01.indd 1½ 4/2014 Page 45
//D. import aquarium.*;
//import aquarium.jellies.*;
//E. import aquarium.Water;
//import aquarium.jellies.Water;
//F. None of these imports can make the code compile.
//8. Given the following class, which of the following calls print out Blue Jay? (Choose all that 
//apply)
//public class BirdDisplay {
// public static void main(String[] name) { 
// System.out.println(name[1]);
//} }
//A. java BirdDisplay Sparrow Blue Jay
//B. java BirdDisplay Sparrow "Blue Jay"
//C. java BirdDisplay Blue Jay Sparrow
//D. java BirdDisplay "Blue Jay" Sparrow
//E. java BirdDisplay.class Sparrow "Blue Jay"
//F. java BirdDisplay.class "Blue Jay" Sparrow
//G. Does not compile.
//9. Which of the following legally fill in the blank so you can run the main() method from the 
//command line? (Choose all that apply)
//public static void main( ) 
//A. String[] _names
//B. String[] 123
//C. String abc[]
//D. String _Names[]
//E. String... $n
//F. String names
//G. None of the above.
//10. Which of the following are legal entry point methods that can be run from the command 
//line? (Choose all that apply)
//A. private static void main(String[] args) 
//B. public static final main(String[] args) 
//C. public void main(String[] args) 
//D. public static void test(String[] args) 
//E. public static void main(String[] args) 
//F. public static main(String[] args) 
//G. None of the above.
//46 Chapter 1 ■ Java Building Blocks
//c01.indd 1½ 4/2014 Page 46
//11. Which of the following are true? (Choose all that apply)
//A. An instance variable of type double defaults to null.
//B. An instance variable of type int defaults to null.
//C. An instance variable of type String defaults to null.
//D. An instance variable of type double defaults to 0.0.
//E. An instance variable of type int defaults to 0.0.
//F. An instance variable of type String defaults to 0.0.
//G. None of the above.
//12. Which of the following are true? (Choose all that apply)
//A. A local variable of type boolean defaults to null.
//B. A local variable of type float defaults to 0.
//C. A local variable of type Object defaults to null.
//D. A local variable of type boolean defaults to false.
//E. A local variable of type boolean defaults to true.
//F. A local variable of type float defaults to 0.0.
//G. None of the above.
//13. Which of the following are true? (Choose all that apply)
//A. An instance variable of type boolean defaults to false.
//B. An instance variable of type boolean defaults to true.
//C. An instance variable of type boolean defaults to null.
//D. An instance variable of type int defaults to 0.
//E. An instance variable of type int defaults to 0.0.
//F. An instance variable of type int defaults to null.
//G. None of the above.
//14. Given the following class in the file /my/directory/named/A/Bird.java:
//INSERT CODE HERE
//public class Bird { }
//Which of the following replaces INSERT CODE HERE if we compile from /my/directory? 
//(Choose all that apply)
//A. package my.directory.named.a;
//B. package my.directory.named.A;
//C. package named.a;
//D. package named.A;
//E. package a;
//F. package A;
//G. Does not compile.
//Review Questions 47
//c01.indd 1½ 4/2014 Page 47
//15. Which of the following lines of code compile? (Choose all that apply)
//A. int i1 = 1_234;
//B. double d1 = 1_234_.0;
//C. double d2 = 1_234._0;
//D. double d3 = 1_234.0_;
//E. double d4 = 1_234.0;
//F. None of the above.
//16. Given the following class, which of the following lines of code can replace INSERT CODE 
//HERE to make the code compile? (Choose all that apply)
//public class Price {
// public void admission() {
// INSERT CODE HERE
// System.out.println(amount);
// } }
//A. int amount = 9L;
//B. int amount = 0b101;
//C. int amount = 0xE;
//D. double amount = 0xE;
//E. double amount = 1_2_.0_0;
//F. int amount = 1_2_;
//G. None of the above.
//17. Which of the following are true? (Choose all that apply)
//public class Bunny {
// public static void main(String[] args) {
// Bunny bun = new Bunny();
//} }
//A. Bunny is a class.
//B. bun is a class.
//C. main is a class.
//D. Bunny is a reference to an object.
//E. bun is a reference to an object.
//F. main is a reference to an object.
//G. None of the above