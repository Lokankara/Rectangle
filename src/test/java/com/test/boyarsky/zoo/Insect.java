/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
abstract class Insect implements HasExoskeleton {
	abstract int getNumberOfSections();

	public Insect() {
	}
}

interface HasExoskeleton {
	public static String Number = "";
	public static String num = "";

//	private String s = "";
//	final String fine = 0;
//	protected String Num;
	abstract int getNumberOfLegs();
}
