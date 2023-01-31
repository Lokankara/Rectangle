package com.test.heller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Wrapper {
	public int x;
}
public class Tester implements Comparable<Tester> {
	private static void bump(int n, Wrapper w) {
		n++;
		w.x++;
 }
 public static void main(String[] args) {
	 
	 	 Set<Tester> set = new TreeSet<Tester>();
		  set.add(new Tester());
		   set.add(new Tester());
		   set.add(new Tester());
		  
		 
	 
//	 Map<String> names = new HashMap<String>();

//	 Iterator<String> iter = names.iterator();
	 
//	 B. for (String s:names)
//	 C. while (String s:names)
//	 
	 int n = 10;
	 Wrapper w = new Wrapper();
	 w.x = 10;
	 bump(n, w);
	 System.out.println(String.format("#47, page 491%n%s%n%s", n, w.x));
 }
@Override
public int compareTo(Tester o) {
	// TODO Auto-generated method stub
	return 0;
}
}