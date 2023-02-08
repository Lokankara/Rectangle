package com.test.sierra.exam;

import java.util.*;

public class Birthdays {

	public static void main(String[] args) {
		args= new String []{"Draumur"};
		Map<Friends, String> hm = new HashMap<Friends, String>();
		hm.put(new Friends("Charis"), "Summer 2009");
		hm.put(new Friends("Draumur"), "Spring 2002");
		Friends f = new Friends(args[0]);
		System.out.println(hm.get(f));
		System.out.println(f);
		for(Friends fr : hm.keySet()) {
			System.out.println(fr);
		}
	}
}

class Friends {
	String name;

	Friends(String n) {
		name = n;
	}
	
}