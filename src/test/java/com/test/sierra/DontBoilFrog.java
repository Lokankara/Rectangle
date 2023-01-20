package com.test.sierra;

public class DontBoilFrog implements FrogBoilable {

	public static void main(String[] args) {
		new DontBoilFrog().go();
	}

	  void go() {

System.out.println(hop());	
//System.out.println(getCtoF(100));	
System.out.println(FrogBoilable.getCtoF(100));	
	DontBoilFrog dbf = new DontBoilFrog();
//	dbf.getCtoF(100));	
	  }

	private String hop() {
		return "hopping";
	}

}
interface FrogBoilable{
	static int getCtoF(int cTemp) {
		return (cTemp * 9/5 ) + 32;
	}
}