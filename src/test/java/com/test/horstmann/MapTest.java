package com.test.horstmann;

import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		var staff = new HashMap<String, Employee>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		System.out.println(staff);
		staff.remove("567-24-2546");
		staff.put("456-62-5527", new Employee("Francesca Miller"));
		System.out.println(staff.get("157-62-7935"));
		staff.forEach((k, v) -> System.out.printf("key: %s, value=%s", k, v));
		
		var counts= new HashMap<String, Integer>();
		
		String word = "a";
		//Then get returns null, and a NullPointerException occurs
		counts.put(word , counts.get(word) + 1);
		counts.put(word, counts.getOrDefault(word, 0) + 1);

		// now we know that get will succeed
		counts.putIfAbsent(word, 0);
		counts.put(word, counts.get(word) + 1); 
		// best practice
		counts.merge(word, 1, Integer::sum);
	}
}
