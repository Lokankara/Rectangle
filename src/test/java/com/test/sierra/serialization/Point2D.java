package com.test.sierra.serialization;

import java.io.*;

class Point2D implements Externalizable {
	private int x, y;

	public Point2D(int x, int y) {
		this.x = x;
	}

	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Point " + x + ":" + y);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		/* empty */
	}

	public static void main(String[] args) {
		Point2D point = new Point2D(10, 20);
		System.out.println(point);
	}
}