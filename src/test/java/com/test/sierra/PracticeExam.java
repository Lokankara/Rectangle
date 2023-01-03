package com.test.sierra;

public class PracticeExam {
}

class Glank implements Vonk {
	Jooker[] j;
}

abstract class Bostron {
	String yoodle;
	Bostron b;
}

interface Protefor {
}

interface Vonk extends Protefor {
	int x = 7;
}

class Jooker {
	Bostron b;
}

//###56. Given:
//A. Glanks have a Bostron.
////B. Jookers implement Protefors.
////C. Glanks implement Bostrons.
//D. Jookers have a String.
////E. Bostrons implement Vonks.
//F. Bostrons have a Bostron.
//A, D, and F correctly describe some of the relationships within the code. Glanks have 
//Bostrons indirectly through Jookers. Jookers have Strings indirectly through Bostrons, and 
//Bostrons have Bostrons because it’s very common to want to make linked lists with your 
//Bostrons.

//	###56. Given a partial API:
//		 Final class Items implements no interfaces and has one constructor:
//		Items(String name, int value)
//		 And given that you want to make collections of Items objects and sort them (using classes 
//		and interfaces in java.lang or java.util), sometimes by name, and sometimes by value, 
//		which are true? (Choose all that apply.)
//		 A. It’s likely that you’ll use the Arrays class.
//		 B. It’s likely that you’ll use the Collections class.
//		 C. It’s likely that you’ll implement Comparable at least twice.
//		 D. It’s likely that you’ll implement Comparator at least twice.
//		 E. It’s likely that you’ll implement the compare() method at least twice.
//		 F. It’s likely that you’ll implement the compareTo() method at least twice

//	B, D, and E are correct. The most natural way to use the Java API in this case would be to 
//	create two classes, each of which implements Comparator. Each class that implements 
//	Comparator will implement a compare() method. Once this is done, you’d use 
//	Collections.sort() to sort the collections
//	
