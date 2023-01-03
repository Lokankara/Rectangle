package com.test.schildt;

class Shipment extends BoxWeight {
	double cost;

	public Shipment(Shipment ob) {
		super(ob);
		cost = ob.cost;
	}

	public Shipment() {
		super();
		cost = -1;
	}
	
	public Shipment(double len, double weight, double cost) {
		super(len, weight);
		this.cost = cost;
	}
	public Shipment(double width, double height, double depth, double weight, double cost) {
		super(width, height, depth, weight);
		this.cost = cost;
	}
}

public class Box {
	double width;
	double height;
	double depth;
	double weight;

	Box(Box ob) {
		this.width = ob.width;
		this.height = ob.height;
		this.depth = ob.depth;
	}

	public Box(double width, double height, double depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public Box() {
		width = -1;
		height = -1;
		depth = -1;
	}

	Box(double len) {
		width = height = depth = len;
	}

	double volume() {
		return width * height * depth;
	}
}

class BoxWeight extends Box {
	double len;
	double weight;

	public BoxWeight(double len, double weight) {
		this.len = len;
		this.weight = weight;
	}

	public BoxWeight() {
		super();
		this.weight = -1;
	}

	BoxWeight(double w, double h, double d, double m) {
		width = w;
		height = h;
		depth = d;
		weight = m;
	}

	public BoxWeight(Shipment ob) {
		// TODO Auto-generated constructor stub
	}
}

class BoxColor extends Box {
	int color;

	BoxColor(double w, double h, double d, int c) {
		width = w;
		height = h;
		depth = d;
		color = c;
	}
}