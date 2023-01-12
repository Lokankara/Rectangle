package com.test.boyarsky.strings;

public class Builder {
// 5 tuna, 4 1 // G
	public static void main(String abc[]) {

		System.out.print("Ch3 #1: ");

		int numFish = 4;
		String fishType = "tuna";
//		 String anotherFish = numFish + 1;
//		 System.out.println(anotherFish + " " + fishType);
		System.out.printf("%d %d%n", numFish, 1);
// one three four
		System.out.print("Ch3 #2: ");

		String s = "Hello";
		String t = new String(s);
		if ("Hello".equals(s))
			System.out.print("one ");
		if (t == s)
			System.out.print("two ");
		if (t.equals(s))
			System.out.print("three ");
		if ("Hello" == s)
			System.out.printf("four%n");

		System.out.println("Ch3 #3: B/E/F");
		System.out.println("Ch3 #4: B - abbaccca");
		System.out.printf("Ch3 #5: Incompatible operand types String and StringBuilder");
		String s1 = "java";
		StringBuilder s2 = new StringBuilder("java");
//	if(s1 == s2)
		System.out.print("1%n");
		if (s1.equals(s2))
			System.out.printf("2");

		System.out.printf("%nCh3 #6: B - ");

		String roar1 = "roar";
		StringBuilder roar2 = new StringBuilder("roar");
		new Lion().roar(roar1, roar2);

		System.out.printf("%s %s", roar1, roar2);

		System.out.printf("%nCh3 #7: B/D/F - bound exception");
		String letters = "abcdef";
		System.out.print(letters.length());
		System.out.print(letters.charAt(3));
//		System.out.print(letters.charAt(6));
		
		
		System.out.printf("%nCh3 #8: A/D/E");
		String numbers = "012345678"; 
//		System.out.print(numbers.substring(1, 3));
//		System.out.print(numbers.substring(7,7));
//		System.out.print(numbers.substring(7));
		
		System.out.printf("%nCh3 #9: ");
		String sp = "purr";
		sp.toUpperCase();
		sp.trim();
		sp.substring(1,3);
		sp += " two";
		System.out.print(sp.length());
		System.out.printf("%nCh3 #10: ");
		String a = "";
		a +=2;
		a+='c';
		a+= false;
		if(a=="2cfalse") System.out.println("==");
		if(a.equals("2cfalse")) System.out.println("equals");
	}
}

class Lion {
	public void roar(String roar1, StringBuilder roar2) {
		roar1.concat("!!!");
		roar2.append("!!!");
	}
}