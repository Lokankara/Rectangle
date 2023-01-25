package com.test.raposa;

import java.util.regex.Pattern;

public class Parse {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("x.y");
		String[] values = { "xy", "xay", "xaby", "xa" };
		for (String value : values) {
			if (p.matcher(value).matches()) {
				System.out.println(value);
			}
		}
		String stuff = "of coursewyeswnowmaybe";
		String[] value = stuff.split("w");
		System.out.println(value.length);
	}
}
