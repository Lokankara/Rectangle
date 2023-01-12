package com.test.jaworsky;

import java.util.*;

public class Question {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		v1.add("This");
		v1.add(v2);
		String s = (String) v1.elementAt(0);
		v1 = v2;
		v2 = v1;
		v1.add(s);
	}
}