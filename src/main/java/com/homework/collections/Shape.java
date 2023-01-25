package com.homework.collections;

import java.io.Serializable;
import java.util.ArrayList;

abstract class Shape implements Serializable{
	private static final long serialVersionUID = 291364212463245L;
	private long counter;
	public long getCounter() {
		return counter;
	}
	protected void setCounter(long count) {
		this.counter = count;
	}
	protected abstract long setCounter(ArrayList<? extends Shape> shapes);
}