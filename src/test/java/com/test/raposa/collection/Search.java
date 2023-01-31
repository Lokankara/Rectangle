package com.test.raposa.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Search {
	static class ProductComparator implements Comparator<Product> {
		public int compare(Product a, Product b) {
			return Double.compare(a.price, b.price);
		}
	}

	static class DescriptionSorter implements Comparator<Product> {

		@Override
		public int compare(Product a, Product b) {
			return a.description.compareTo(b.description);
		}
	}

	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();

		Product toFindFood = new Product("milk", 3, 111);

		Product[] products = { toFindFood, 
				new Product("eggs", 4.00, 222), 
				new Product("butter", 2.75, 333),
				new Product("bread", 1.99, 444) };

		DescriptionSorter ds = new DescriptionSorter();
		Arrays.<Product>sort(products, ds);
		
		for(Product p : products) {
			System.out.println(String.format("%s %.2f%n", p.description, p.price));
		}

		int i = Arrays.<Product>binarySearch(products, toFindFood, ds);
		System.out.printf("%n%s: %d%n", toFindFood, i);
		
		Product toFind = new Product("shirt", 99, 101);
		list.add(toFind);

		list.add(new Product("shoes", 100, 202));
		list.add(new Product("tie", 50, 303));

		ProductComparator pc = new ProductComparator();
		Collections.sort(list, pc);
		list.forEach(p -> p.toString());
		int index = Collections.binarySearch(list, toFind, pc);
		System.out.println("Index of shirt is " + list.get(index));
	}
}

class Product {
	int id;
	String description;
	double price;

	public Product(String description, double price, int id) {
		super();
		this.description = description;
		this.price = price;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return String.format("Product [id=%d, description=%s, price=%.2f]", id, description, price);
	}
}