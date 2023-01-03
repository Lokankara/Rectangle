/**
 * 
 */
package com.test.boyarsky;

/**
 * @author PPoliak
 *
 */
class Order {
	final String value1 = "1";
	static String value2 = "2";
	String value3 = "3";
	static String result = "";
	{
		result += "scope#1 ";
	}
	static {
		value2 = "static ";
		result += "static ";
	}

	{
		value3 = "scope ";
		
		result += "scope#2 ";
	}

	String value = "t";
	{
		value += "a";
	}
	{
		value += "c";
	}

	public Order() {
		value += "b";
	}

	public Order(String s) {
		value += s;
	}
}

public class OrderDriver {
	public static void main(String[] args) {
		System.out.print("ch4 #22 init scopes: ");
		System.out.print(Order.result);
		System.out.print(Order.result);
		new Order();
		new Order();

		System.out.println(Order.result);
		System.out.print("ch4 #23 init constructors: ");
		Order order = new Order("f");
		order = new Order();
		System.out.println(order.value);
		System.out.println(order.value1);
		System.out.println(order.value2);
		System.out.println(order.value3);
	}
}