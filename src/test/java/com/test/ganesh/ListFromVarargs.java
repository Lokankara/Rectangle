package com.test.ganesh;

import java.util.*;

class ListFromVarargs {
	public static <T> List<T> asList1(T... elements) {
		ArrayList<T> temp = new ArrayList<>();
		for (T element : elements) {
			temp.add(element);
		}
		return temp;
	}

	public static <T> List<?> asList2(T... elements) {
		ArrayList<? super T> temp = new ArrayList<>();
		for (T element : elements) {
			temp.add(element);
		}
		return temp;
	}

	public static <T> List<?> asList3(T... elements) {
		ArrayList<T> temp = new ArrayList<>();
		for (T element : elements) {
			temp.add(element);
		}
		return temp;
	}

	public static <T> List<?> asList4(T... elements) {
		List<T> temp = new ArrayList<T>();
		for (T element : elements) {
			temp.add(element);
		}
		return temp;
	}
}