package com.test.selikov.boyarsky;

public class PoliceBox {
String color;
long age;
	public PoliceBox() {
	color ="blue";
	age = 1200;
	}

	public static void main(String[] args) {
	var p = new PoliceBox();
	var q = new PoliceBox();
	p.age = 1400;
	p.color = "green";
	p = q;
	q = p;
	System.out.println(q);
	System.out.println(p);
	}

	@Override
	public String toString() {
		return "PoliceBox [color=" + color + ", age=" + age + "]";
	}

}
