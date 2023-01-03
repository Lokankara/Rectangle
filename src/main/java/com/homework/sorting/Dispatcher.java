package com.homework.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Dispatcher {

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();

		persons.add(new Person("George", "UA", 1946, true));
		persons.add(new Person("Bob", "DE", 1952, true));
		persons.add(new Person("Curt", "FR", 1867, true));
		persons.add(new Person("Amy", "UK", 1967, true));
		persons.add(new Person("Harry", "USA", 2000, true));
		persons.add(new Person("Fred", "USA", 1995, true));
		persons.add(new Person("Billie", "USA", 1950, false));
		persons.add(new Person("Sia", "AU", 1972, false));

		Person[] ps = persons.toArray(new Person[persons.size()]);

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		
		if (num == 1) {
			Arrays.sort(ps, new ComparatorByRegion());
			System.out.printf("ComparatorByRegion%s%n", Arrays.toString(ps));

		} else if (num == 2) {
			Arrays.sort(ps, new ComparatorByBirthYear());
			System.out.printf("ComparatorByBirthYear%s%n", Arrays.toString(ps));

		} else if (num == 3) {
			Arrays.sort(ps, new ComparatorByMale());
			System.out.printf("ComparatorByMale%s%n", Arrays.toString(ps));

		} else {
			Arrays.sort(ps, new ComparatorByName());
			System.out.printf("ComparatorByName %s%n", Arrays.toString(ps));
		}
	}
}

class Compare {

	//0: name, 1: region, 2: year, 3:male
	Integer[] get(Person a, Person b) {
		Integer[] result = { 
				a.name.compareTo(b.name), 
				a.region.compareTo(b.region), 
				b.birthYear - a.birthYear,
				(a.isMale == b.isMale) ? 0 : (a.isMale ? 1 : -1) };
//		a.isMale && b.isMale || !a.isMale && !b.isMale ? 1 : -1 };
		return result;
	}

}
class ComparatorByBirthYear implements Comparator<Person> {
	// 2: birthYear => isMale => name => region,
	// return year != 0 ? year : gender != 0 ? gender : name != 0 ? name : region;
			
	@Override
	public int compare(Person a, Person b) {
		
		Integer[] params = new Compare().get(a, b);

		return params[2] != 0 ? params[2] : params[3] != 0 ? params[3] : params[0] != 0 ? params[0] : params[1];
	}	
}

class ComparatorByRegion implements Comparator<Person> {

	// 1: region => name => male => year. 

	@Override
	public int compare(Person a, Person b) {

		Integer[] params = new Compare().get(a, b);

		return params[1] != 0 
				? params[1] : params[0] != 0 
				? params[0] : params[3] != 0 
				? params[3] : params[2];
	}
}

class ComparatorByName implements Comparator<Person> {
	// 4. name => region => birthYear => isMale 
	//- при введенні будь-якого іншого String або відсутності введених Strings – 

	@Override
	public int compare(Person a, Person b) {
		Integer[] params = new Compare().get(a, b);
		
		return params[0] != 0 
				? params[0] : params[1] != 0 
				? params[1] : params[2] != 0 
				? params[2] : params[3];
	}	
}

class ComparatorByMale implements Comparator<Person> {

	// 3: isMale => name => region => birthYear

	@Override
	public int compare(Person a, Person b) {

		Integer[] params = new Compare().get(a, b);

		return params[3] != 0 
				? params[3] : params[0] != 0 
				? params[0] : params[1] != 0 
				? params[1] : params[2];
	}
}

class Person {
	String name;
	String region;
	int birthYear;
	boolean isMale;

	public Person(String name, String region, int birthYear, boolean isMale) {
		super();
		this.name = name;
		this.region = region;
		this.birthYear = birthYear;
		this.isMale = isMale;
	}

	public Person() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthYear, isMale, name, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return birthYear == other.birthYear && isMale == other.isMale && Objects.equals(name, other.name)
				&& Objects.equals(region, other.region);
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, region=%s, birthYear=%d, isMale=%s]", name, region, birthYear, isMale);
	}
}
